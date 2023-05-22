package ma.sir.event.service.impl.admin;

import com.corundumstudio.socketio.SocketIOServer;
import com.google.common.collect.ImmutableList;
import ma.sir.event.bean.core.Evenement;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.bean.history.EvenementHistory;
import ma.sir.event.dao.criteria.core.EvenementCriteria;
import ma.sir.event.dao.criteria.history.EvenementHistoryCriteria;
import ma.sir.event.dao.facade.core.EvenementDao;
import ma.sir.event.dao.facade.history.EvenementHistoryDao;
import ma.sir.event.dao.specification.core.EvenementSpecification;
import ma.sir.event.service.facade.admin.EvenementAdminService;
import ma.sir.event.service.facade.admin.EvenementStateAdminService;
import ma.sir.event.service.facade.admin.SalleAdminService;
import ma.sir.event.ws.converter.EvenementRedisConverter;
import ma.sir.event.zynerator.service.AbstractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

import static redis.clients.jedis.Protocol.Keyword.KEY;

@Service
public class EvenementAdminServiceImpl extends AbstractServiceImpl<Evenement, EvenementHistory, EvenementCriteria, EvenementHistoryCriteria, EvenementDao,
        EvenementHistoryDao> implements EvenementAdminService {

    private final SocketIOServer socketIOServer;
    @Autowired
    private EvenementRedisConverter evenementRedisConverter;
    @Autowired
    private EvenementAdminRedisServiceImpl evenementAdminRedisService;
    @Autowired
    private ReactiveRedisTemplate<String, EvenementRedis> template;

    @Override
    public Evenement create(Evenement evenement) {
        String referenceBlocOperatoir = evenement.getSalle().getBlocOperatoir().getReference();
        Mono<EvenementRedis> evenementRedis = evenementAdminRedisService.findByReference(referenceBlocOperatoir, evenement.getReference())
                .switchIfEmpty(Mono.just(new EvenementRedis()));

        evenementRedis.subscribe(redis -> {
            if (redis.getId() == null) {
                try {
                    Evenement saved = super.create(evenement);
                    EvenementRedis savedRedis = evenementRedisConverter.toDto(saved);
                    evenementAdminRedisService.save(savedRedis);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    Evenement updated = super.update(evenement);
                    EvenementRedis updatedRedis = evenementRedisConverter.toDto(updated);
                    evenementAdminRedisService.save(updatedRedis);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return evenement;
    }


    public Evenement findByReferenceEntity(Evenement t) {
        return dao.findByReference(t.getReference());
    }


    // @Cacheable(cacheNames = "itemCache", key = "#id", cacheManager = "redisCacheManager")
    public List<Evenement> findBySalleId(Long id) {
        return dao.findBySalleId(id);
    }

    @Override
    public List<EvenementRedis> findBySalleBlocOperatoirReference(String reference) {
        Flux<EvenementRedis> evenementRedisFlux = findBySalleBlocOperatoirReferenceInRedis(reference);
        List<EvenementRedis> evenementRedisList = evenementRedisFlux.collectList().block();
        if (evenementRedisList != null && !evenementRedisList.isEmpty()) {
            System.out.println("******************* REDIS *******************");
            return ImmutableList.copyOf(evenementRedisList);
        } else {
            List<EvenementRedis> evenementRedis = retrieveFromDatabase(reference);
            if (!evenementRedis.isEmpty()) {
                System.out.println("******************* DB *******************");
                Map<String, List<EvenementRedis>> evenementRedisMap = new HashMap<>();
                evenementRedisMap.put(reference, evenementRedis);
                template.opsForHash()
                        .putAll(reference, evenementRedisMap)
                        .block();
                return evenementRedis;
            } else {
                return Collections.emptyList();
            }
        }
    }

    private List<EvenementRedis> retrieveFromDatabase(String ref) {
        List<Evenement> evenementList = dao.findBySalleBlocOperatoirReference(ref);
        List<EvenementRedis> evenementRedisList = convert(evenementList);
        if (!evenementRedisList.isEmpty()) {
            for (EvenementRedis evenementRedis : evenementRedisList) {
                template.opsForHash()
                        .put(ref, String.valueOf(evenementRedis.getReference()), evenementRedis)
                        .subscribe();
            }
        }

        return evenementRedisList;
    }


    private List<EvenementRedis> convert(List<Evenement> evenementList) {
        List<EvenementRedis> res = new ArrayList<>();
        if (evenementList != null) {
            for (Evenement evenement : evenementList) {
                res.add(evenementRedisConverter.toDto(evenement));
            }
        }
        return res;
    }

    private Flux<EvenementRedis> findBySalleBlocOperatoirReferenceInRedis(String reference) {
        return template.opsForHash().get(String.valueOf(KEY), reference)
                .flux()
                .map(object -> (EvenementRedis) object);
    }

    public int deleteBySalleId(Long id) {
        return dao.deleteBySalleId(id);
    }

    public List<Evenement> findByEvenementStateId(Long id) {
        return dao.findByEvenementStateId(id);
    }

    public int deleteByEvenementStateId(Long id) {
        return dao.deleteByEvenementStateId(id);
    }

    @Override
    public Evenement findByReference(String reference) {
        return dao.findByReference(reference);
    }

    public void configure() {
        super.configure(Evenement.class, EvenementHistory.class, EvenementHistoryCriteria.class, EvenementSpecification.class);
    }

    @Autowired
    private EvenementStateAdminService evenementStateService;
    @Autowired
    private SalleAdminService salleService;

    public EvenementAdminServiceImpl(EvenementDao dao, EvenementHistoryDao historyDao, SocketIOServer socketIOServer) {
        super(dao, historyDao);
        this.socketIOServer = socketIOServer;
    }

}