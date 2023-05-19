package ma.sir.event.ws.converter;

import ma.sir.event.bean.core.Evenement;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.zynerator.util.DateUtil;
import ma.sir.event.zynerator.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EvenementRedisConverter {

    @Autowired
    private EvenementStateConverter evenementStateConverter;
    @Autowired
    private SalleConverter salleConverter;
    private boolean salle;
    private boolean evenementState;

    public EvenementRedisConverter() {
    }

    public Evenement toItem(EvenementRedis redis) {
        if (redis == null) {
            return null;
        } else {
            Evenement item = new Evenement();
            if (StringUtil.isNotEmpty(redis.getId()))
                item.setId(redis.getId());
            if (StringUtil.isNotEmpty(redis.getReference()))
                item.setReference(redis.getReference());
            if (StringUtil.isNotEmpty(redis.getEvenementStart()))
                item.setEvenementStart(DateUtil.stringEnToDate(redis.getEvenementStart()));
            if (StringUtil.isNotEmpty(redis.getEvenementEnd()))
                item.setEvenementEnd(DateUtil.stringEnToDate(redis.getEvenementEnd()));
            if (StringUtil.isNotEmpty(redis.getDescription()))
                item.setDescription(redis.getDescription());
            if (this.salle && redis.getSalle() != null)
                item.setSalle(salleConverter.toItem(redis.getSalle()));

            if (this.evenementState && redis.getEvenementState() != null)
                item.setEvenementState(evenementStateConverter.toItem(redis.getEvenementState()));


            return item;
        }
    }

    public EvenementRedis toDto(Evenement item) {
        if (item == null) {
            return null;
        } else {
            EvenementRedis dto = new EvenementRedis();
            if (StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if (StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if (item.getEvenementStart() != null)
                dto.setEvenementStart(DateUtil.dateTimeToString(item.getEvenementStart()));
            if (item.getEvenementEnd() != null)
                dto.setEvenementEnd(DateUtil.dateTimeToString(item.getEvenementEnd()));
            if (StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if (this.salle && item.getSalle() != null) {
                dto.setSalle(salleConverter.toDto(item.getSalle()));
            }
            if (this.evenementState && item.getEvenementState() != null) {
                dto.setEvenementState(evenementStateConverter.toDto(item.getEvenementState()));
            }


            return dto;
        }
    }


    public void initObject(boolean value) {
        this.salle = value;
        this.evenementState = value;
    }


    public EvenementStateConverter getEvenementStateConverter() {
        return this.evenementStateConverter;
    }

    public void setEvenementStateConverter(EvenementStateConverter evenementStateConverter) {
        this.evenementStateConverter = evenementStateConverter;
    }

    public SalleConverter getSalleConverter() {
        return this.salleConverter;
    }

    public void setSalleConverter(SalleConverter salleConverter) {
        this.salleConverter = salleConverter;
    }

    public boolean isSalle() {
        return this.salle;
    }

    public void setSalle(boolean salle) {
        this.salle = salle;
    }

    public boolean isEvenementState() {
        return this.evenementState;
    }

    public void setEvenementState(boolean evenementState) {
        this.evenementState = evenementState;
    }
}
