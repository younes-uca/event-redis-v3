package ma.sir.event.service.impl.admin;

import com.corundumstudio.socketio.SocketIOServer;
import ma.sir.event.bean.core.BlocOperatoirMetaData;
import ma.sir.event.bean.core.Evenement;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.bean.history.EvenementHistory;
import ma.sir.event.dao.criteria.core.EvenementCriteria;
import ma.sir.event.dao.criteria.history.EvenementHistoryCriteria;
import ma.sir.event.dao.facade.core.BlocOperatoirMetaDataDao;
import ma.sir.event.dao.facade.core.EvenementDao;
import ma.sir.event.dao.facade.history.EvenementHistoryDao;
import ma.sir.event.dao.specification.core.EvenementSpecification;
import ma.sir.event.service.facade.admin.EvenementAdminService;
import ma.sir.event.service.facade.admin.EvenementStateAdminService;
import ma.sir.event.service.facade.admin.SalleAdminService;
import ma.sir.event.ws.converter.EvenementRedisConverter;
import ma.sir.event.zynerator.service.AbstractServiceImpl;
import ma.sir.event.zynerator.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EvenementAdminServiceImpl extends AbstractServiceImpl<Evenement, EvenementHistory, EvenementCriteria, EvenementHistoryCriteria, EvenementDao,
        EvenementHistoryDao> implements EvenementAdminService {

    private final SocketIOServer socketIOServer;
    @Autowired
    private EvenementRedisConverter evenementRedisConverter;
    @Autowired
    private EvenementAdminRedisServiceImpl evenementAdminRedisService;
    @Autowired
    private BlocOperatoirMetaDataDao blocOperatoirMetaDataDao;
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
                    saveOrUpdateBlocOperatoireMetaData(evenement.getSalle().getBlocOperatoir().getReference());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    Evenement updated = super.update(evenement);
                    EvenementRedis updatedRedis = evenementRedisConverter.toDto(updated);
                    evenementAdminRedisService.save(updatedRedis);
                    saveOrUpdateBlocOperatoireMetaData(evenement.getSalle().getBlocOperatoir().getReference());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return evenement;
    }

    private void saveOrUpdateBlocOperatoireMetaData(String referenceBlocOperatoire) {
        BlocOperatoirMetaData blocOperatoirMetaData = blocOperatoirMetaDataDao.findByReference(referenceBlocOperatoire);
        if (blocOperatoirMetaData == null) {
            blocOperatoirMetaDataDao.save(new BlocOperatoirMetaData(referenceBlocOperatoire));
        }else{
            blocOperatoirMetaData.setLastUpdate(LocalDateTime.now());
            blocOperatoirMetaDataDao.save(blocOperatoirMetaData);
        }
    }

    private void saveBlocOperatoireMetaData(String referenceBlocOperatoire) {
        blocOperatoirMetaDataDao.save(new BlocOperatoirMetaData(referenceBlocOperatoire));
    }


    public Evenement findByReferenceEntity(Evenement t) {
        return dao.findByReference(t.getReference());
    }


    // @Cacheable(cacheNames = "itemCache", key = "#id", cacheManager = "redisCacheManager")
    public List<Evenement> findBySalleId(Long id) {
        return dao.findBySalleId(id);
    }

    @Override
    public BlocOperatoireInformation findBySalleBlocOperatoirReference(String reference, LocalDateTime lastUpdateInFrontEnd) {
        BlocOperatoirMetaData blocOperatoirMetaData = blocOperatoirMetaDataDao.findByReference(reference);
        int flag = 1;
        if (blocOperatoirMetaData == null) {
            saveBlocOperatoireMetaData(reference);
        } else if (!blocOperatoirMetaData.getLastUpdate().equals(lastUpdateInFrontEnd)) {
            flag = 2;
        } else {
            System.out.println("******************* NO CHANGE DETECTED *******************");
            return null;
        }
        if (flag ==2) {
            Flux<EvenementRedis> evenementRedisFlux = findBySalleBlocOperatoirReferenceInRedis(reference);
            List<EvenementRedis> evenementRedisList = evenementRedisFlux.collectList().block();
            System.out.println("******************* REDIS *******************");
            //ImmutableList.copyOf(evenementRedisList)
            return new BlocOperatoireInformation(blocOperatoirMetaData.getReference(), DateUtil.convert(blocOperatoirMetaData.getLastUpdate()),evenementRedisList);
        } else {
            System.out.println("******************* DB *******************");
            List<Evenement> evenementList = dao.findBySalleBlocOperatoirReference(reference);
            List<EvenementRedis> evenementRedis = putInRedis(reference, evenementList);
            return new BlocOperatoireInformation(blocOperatoirMetaData.getReference(), DateUtil.convert(blocOperatoirMetaData.getLastUpdate()),evenementRedis);
        }
    }

    private List<EvenementRedis> putInRedis(String reference, List<Evenement> evenementList) {
        List<EvenementRedis> evenementRedisList = convert(evenementList);
        if (!evenementRedisList.isEmpty()) {
            for (EvenementRedis evenementRedis : evenementRedisList) {
                template.opsForHash()
                        .put(reference, String.valueOf(evenementRedis.getReference()), evenementRedis)
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
        return template.opsForHash().values(reference)

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