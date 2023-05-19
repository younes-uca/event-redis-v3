package ma.sir.event.scheduler;

import lombok.extern.slf4j.Slf4j;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.service.impl.admin.EvenementAdminRedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@EnableScheduling
public class ClearEventCache {

    @Autowired
    private EvenementAdminRedisServiceImpl eventService;

    @Scheduled(cron = "00 59 00 * * *")
    public void cleanOldEventsFromCache() {
        boolean isOlderEvent;
        LocalDate extractedEventDate;
        // TODO adapt find all to find all hash
        List<EvenementRedis> olderEvents = new ArrayList<>();// eventService.findAll();
        if (!olderEvents.isEmpty()) {
            for (EvenementRedis event : olderEvents) {
                extractedEventDate = extractAndConvertToLocalDate(event.getReference());
                isOlderEvent = compareDates(extractedEventDate);
                deleteOldEventFromCache(isOlderEvent, event);
                logDeletingStatus(isOlderEvent, event);
            }
        }
    }

    public LocalDate extractAndConvertToLocalDate(String eventReference) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String extractedDate = eventReference.split("_")[3];
        return LocalDate.parse(extractedDate, formatter);
    }

    public boolean compareDates(LocalDate eventDate) {
        return eventDate.isBefore(LocalDate.now());
    }

    public void deleteOldEventFromCache(boolean isOlderEvent, EvenementRedis event) {
        if (isOlderEvent) {
            String referenceBlockOperatoir = event.getSalle().getBlocOperatoir().getReference();
            eventService.deleteByReference(referenceBlockOperatoir, event.getReference());
        }
    }

    public void logDeletingStatus(boolean isComparesDatesReturnsTrue, EvenementRedis event) {
        if (isComparesDatesReturnsTrue) {
            log.info("Event with reference " + event.getReference() + " deleted with success");
        }
    }
}
