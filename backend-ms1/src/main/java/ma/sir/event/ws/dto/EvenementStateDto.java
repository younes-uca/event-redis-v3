package  ma.sir.event.ws.dto;

import ma.sir.event.zynerator.audit.Log;
import ma.sir.event.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvenementStateDto  extends AuditBaseDto {

    private String reference  ;
    private String code  ;




    public EvenementStateDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }






}
