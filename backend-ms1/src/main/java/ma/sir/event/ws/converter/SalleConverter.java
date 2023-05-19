package  ma.sir.event.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.event.zynerator.util.StringUtil;
import ma.sir.event.zynerator.converter.AbstractConverter;
import ma.sir.event.zynerator.util.DateUtil;
import ma.sir.event.bean.history.SalleHistory;
import ma.sir.event.bean.core.Salle;
import ma.sir.event.ws.dto.SalleDto;

@Component
public class SalleConverter extends AbstractConverter<Salle, SalleDto, SalleHistory> {

    @Autowired
    private BlocOperatoirConverter blocOperatoirConverter ;
    private boolean blocOperatoir;

    public  SalleConverter(){
        super(Salle.class, SalleDto.class, SalleHistory.class);
    }

    @Override
    public Salle toItem(SalleDto dto) {
        if (dto == null) {
            return null;
        } else {
        Salle item = new Salle();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.blocOperatoir && dto.getBlocOperatoir()!=null)
                item.setBlocOperatoir(blocOperatoirConverter.toItem(dto.getBlocOperatoir())) ;



        return item;
        }
    }

    @Override
    public SalleDto toDto(Salle item) {
        if (item == null) {
            return null;
        } else {
            SalleDto dto = new SalleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
        if(this.blocOperatoir && item.getBlocOperatoir()!=null) {
            dto.setBlocOperatoir(blocOperatoirConverter.toDto(item.getBlocOperatoir())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.blocOperatoir = value;
    }


    public BlocOperatoirConverter getBlocOperatoirConverter(){
        return this.blocOperatoirConverter;
    }
    public void setBlocOperatoirConverter(BlocOperatoirConverter blocOperatoirConverter ){
        this.blocOperatoirConverter = blocOperatoirConverter;
    }
    public boolean  isBlocOperatoir(){
        return this.blocOperatoir;
    }
    public void  setBlocOperatoir(boolean blocOperatoir){
        this.blocOperatoir = blocOperatoir;
    }
}
