package ma.sir.event.ws.facade.admin;


import io.swagger.annotations.Api;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.service.impl.admin.EvenementAdminRedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Api("Manages evenement services")
@RestController
@RequestMapping("/api/admin/evenement/redis/")
public class EvenementRedisRestAdmin  {

    @Autowired
    private EvenementAdminRedisServiceImpl evenementAdminRedisService;

    /*@PostMapping("")
    public EvenementRedis save(@RequestBody EvenementRedis evenement) {
        return evenementAdminRedisService.save(evenement);
    }

    @GetMapping("/bloc-operatoire/{referenceBloc}")
    public List<EvenementRedis> findAll(@PathVariable String referenceBloc) {
        return evenementAdminRedisService.findAll(referenceBloc);
    }

    @GetMapping("/bloc-operatoire/{referenceBloc}/reference/{reference}")
    public EvenementRedis findByReference(@PathVariable String referenceBloc,@PathVariable String reference) {
        return evenementAdminRedisService.findByReference(referenceBloc,reference);
    }
    @DeleteMapping("/bloc-operatoire/{referenceBloc}/reference/{reference}")
    public int deleteByReference(@PathVariable String referenceBloc,@PathVariable String reference)   {
        return evenementAdminRedisService.deleteByReference(referenceBloc,reference);
    }*/


    @PostMapping("")
    public Mono<EvenementRedis> save(@RequestBody EvenementRedis evenement) {
        return evenementAdminRedisService.save(evenement);
    }

    @GetMapping("/bloc-operatoire/{referenceBloc}")
    public Flux<EvenementRedis> findAll(@PathVariable String referenceBloc) {
        return evenementAdminRedisService.findAll(referenceBloc);
    }

    @GetMapping("/bloc-operatoire/{referenceBloc}/reference/{reference}")
    public Mono<EvenementRedis> findByReference(@PathVariable String referenceBloc, @PathVariable String reference) {
        return evenementAdminRedisService.findByReference(referenceBloc, reference);
    }

    @DeleteMapping("/bloc-operatoire/{referenceBloc}/reference/{reference}")
    public Mono<Long> deleteByReference(@PathVariable String referenceBloc, @PathVariable String reference) {
        return evenementAdminRedisService.deleteByReference(referenceBloc, reference);
    }

    @GetMapping(value = "event/stream/{referenceBloc}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<EvenementRedis>> streamEvents(@PathVariable String referenceBloc) {
        Sinks.Many<EvenementRedis> sink = evenementAdminRedisService.getOrCreateSink(referenceBloc);

        Flux<EvenementRedis> eventFlux = evenementAdminRedisService.findAll(referenceBloc);
        return eventFlux.concatWith(sink.asFlux())
                .map(e -> ServerSentEvent.<EvenementRedis>builder()
                        .id(e.getReference())
                        .event(e.getDescription())
                        .data(e)
                        .build());
    }


}