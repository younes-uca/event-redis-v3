package  ma.sir.event.ws.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ma.sir.event.zynerator.audit.Log;
import ma.sir.event.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)

public class SalleDto  extends AuditBaseDto {

    private String reference  ;
    private String code  ;

    private BlocOperatoirDto blocOperatoir ;



    public SalleDto(){
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


    public BlocOperatoirDto getBlocOperatoir(){
        return this.blocOperatoir;
    }

    public void setBlocOperatoir(BlocOperatoirDto blocOperatoir){
        this.blocOperatoir = blocOperatoir;
    }




}
