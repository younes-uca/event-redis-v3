package  ma.sir.event.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.event.zynerator.util.StringUtil;
import ma.sir.event.zynerator.converter.AbstractConverter;
import ma.sir.event.zynerator.util.DateUtil;
import ma.sir.event.bean.history.BlocOperatoirHistory;
import ma.sir.event.bean.core.BlocOperatoir;
import ma.sir.event.ws.dto.BlocOperatoirDto;

@Component
public class BlocOperatoirConverter extends AbstractConverter<BlocOperatoir, BlocOperatoirDto, BlocOperatoirHistory> {


    public  BlocOperatoirConverter(){
        super(BlocOperatoir.class, BlocOperatoirDto.class, BlocOperatoirHistory.class);
    }

    @Override
    public BlocOperatoir toItem(BlocOperatoirDto dto) {
        if (dto == null) {
            return null;
        } else {
        BlocOperatoir item = new BlocOperatoir();
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
    public BlocOperatoirDto toDto(BlocOperatoir item) {
        if (item == null) {
            return null;
        } else {
            BlocOperatoirDto dto = new BlocOperatoirDto();
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
