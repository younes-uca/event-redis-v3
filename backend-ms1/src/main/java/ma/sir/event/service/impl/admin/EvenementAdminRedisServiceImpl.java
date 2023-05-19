package ma.sir.event.service.impl.admin;

import lombok.extern.slf4j.Slf4j;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.ws.dto.BlocOperatoirDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@Service
public class EvenementAdminRedisServiceImpl {

    @Autowired
    private ReactiveRedisTemplate<String, EvenementRedis> template;

    private final Map<String, Sinks.Many<EvenementRedis>> sinksMap = new ConcurrentHashMap<>();//store sinks, each bloc has its own sink ;-))

    public Sinks.Many<EvenementRedis> getOrCreateSink(String referenceBloc) {
        return sinksMap.computeIfAbsent(referenceBloc, key -> Sinks.many().multicast().onBackpressureBuffer());
    }

    public void sendEvent(EvenementRedis evenement) {
        String referenceBloc = evenement.getSalle().getBlocOperatoir().getReference();
        Sinks.Many<EvenementRedis> sink = sinksMap.get(referenceBloc);
        if (sink != null) {
            sink.tryEmitNext(evenement);
        }
    }


    public Mono<EvenementRedis> save(EvenementRedis evenement) {
        if (getBlocOperatoir(evenement) != null) {
            template.opsForHash()
                    .put(getBlocOperatoirReference(evenement), String.valueOf(evenement.getReference()), evenement)
                    .thenReturn(evenement)
                    .subscribe();

            sendEvent(evenement);
        }
        log.info("save" + evenement.getSalle().getBlocOperatoir().getReference());

        return Mono.empty();
    }

    public Flux<EvenementRedis> findAll(String referenceBloc) {
        return template.opsForHash().values(referenceBloc)
                .map(object -> (EvenementRedis) object);
    }


    public Mono<EvenementRedis> findByReference(String referenceBloc, String reference) {
        return template.opsForHash().get(referenceBloc, reference)
                .map(obj -> (EvenementRedis) obj)
                .switchIfEmpty(Mono.empty());
    }


    public Mono<Long> deleteByReference(String referenceBloc, String reference) {
        return template.opsForHash().remove(referenceBloc, reference);
    }

    private BlocOperatoirDto getBlocOperatoir(EvenementRedis evenement) {
        return evenement.getSalle().getBlocOperatoir();
    }

    private String getBlocOperatoirReference(EvenementRedis evenement) {
        BlocOperatoirDto blocOperatoir = getBlocOperatoir(evenement);
        if (blocOperatoir != null) {
            return blocOperatoir.getReference();
        }
        return null;
    }





}
