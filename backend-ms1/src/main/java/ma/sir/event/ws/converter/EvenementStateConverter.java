package  ma.sir.event.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.event.zynerator.util.StringUtil;
import ma.sir.event.zynerator.converter.AbstractConverter;
import ma.sir.event.zynerator.util.DateUtil;
import ma.sir.event.bean.history.EvenementStateHistory;
import ma.sir.event.bean.core.EvenementState;
import ma.sir.event.ws.dto.EvenementStateDto;

@Component
public class EvenementStateConverter extends AbstractConverter<EvenementState, EvenementStateDto, EvenementStateHistory> {


    public  EvenementStateConverter(){
        super(EvenementState.class, EvenementStateDto.class, EvenementStateHistory.class);
    }

    @Override
    public EvenementState toItem(EvenementStateDto dto) {
        if (dto == null) {
            return null;
        } else {
        EvenementState item = new EvenementState();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public EvenementStateDto toDto(EvenementState item) {
        if (item == null) {
            return null;
        } else {
            EvenementStateDto dto = new EvenementStateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
