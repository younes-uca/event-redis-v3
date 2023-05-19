package  ma.sir.event.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.event.zynerator.util.StringUtil;
import ma.sir.event.zynerator.converter.AbstractConverter;
import ma.sir.event.zynerator.util.DateUtil;
import ma.sir.event.bean.history.EvenementHistory;
import ma.sir.event.bean.core.Evenement;
import ma.sir.event.ws.dto.EvenementDto;

@Component
public class EvenementConverter extends AbstractConverter<Evenement, EvenementDto, EvenementHistory> {

    @Autowired
    private EvenementStateConverter evenementStateConverter ;
    @Autowired
    private SalleConverter salleConverter ;
    private boolean salle;
    private boolean evenementState;

    public  EvenementConverter(){
        super(Evenement.class, EvenementDto.class, EvenementHistory.class);
    }

    @Override
    public Evenement toItem(EvenementDto dto) {
        if (dto == null) {
            return null;
        } else {
        Evenement item = new Evenement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getEvenementStart()))
                item.setEvenementStart(DateUtil.stringEnToDate(dto.getEvenementStart()));
            if(StringUtil.isNotEmpty(dto.getEvenementEnd()))
                item.setEvenementEnd(DateUtil.stringEnToDate(dto.getEvenementEnd()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.salle && dto.getSalle()!=null)
                item.setSalle(salleConverter.toItem(dto.getSalle())) ;

            if(this.evenementState && dto.getEvenementState()!=null)
                item.setEvenementState(evenementStateConverter.toItem(dto.getEvenementState())) ;



        return item;
        }
    }

    @Override
    public EvenementDto toDto(Evenement item) {
        if (item == null) {
            return null;
        } else {
            EvenementDto dto = new EvenementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getEvenementStart()!=null)
                dto.setEvenementStart(DateUtil.dateTimeToString(item.getEvenementStart()));
            if(item.getEvenementEnd()!=null)
                dto.setEvenementEnd(DateUtil.dateTimeToString(item.getEvenementEnd()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.salle && item.getSalle()!=null) {
            dto.setSalle(salleConverter.toDto(item.getSalle())) ;
        }
        if(this.evenementState && item.getEvenementState()!=null) {
            dto.setEvenementState(evenementStateConverter.toDto(item.getEvenementState())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.salle = value;
        this.evenementState = value;
    }


    public EvenementStateConverter getEvenementStateConverter(){
        return this.evenementStateConverter;
    }
    public void setEvenementStateConverter(EvenementStateConverter evenementStateConverter ){
        this.evenementStateConverter = evenementStateConverter;
    }
    public SalleConverter getSalleConverter(){
        return this.salleConverter;
    }
    public void setSalleConverter(SalleConverter salleConverter ){
        this.salleConverter = salleConverter;
    }
    public boolean  isSalle(){
        return this.salle;
    }
    public void  setSalle(boolean salle){
        this.salle = salle;
    }
    public boolean  isEvenementState(){
        return this.evenementState;
    }
    public void  setEvenementState(boolean evenementState){
        this.evenementState = evenementState;
    }
}
