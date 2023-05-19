package ma.sir.event.ws.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.event.zynerator.audit.Log;
import ma.sir.event.zynerator.dto.AuditBaseDto;
import org.springframework.data.redis.core.RedisHash;


@JsonInclude(JsonInclude.Include.NON_NULL)
@RedisHash("Evenement")
public class EvenementRedisDto extends AuditBaseDto {

    private String reference  ;
    private String evenementStart ;
    private String evenementEnd ;
    private String description  ;

    private SalleDto salle ;
    private EvenementStateDto evenementState ;



    public EvenementRedisDto(){
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getEvenementStart(){
        return this.evenementStart;
    }
    public void setEvenementStart(String evenementStart){
        this.evenementStart = evenementStart;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getEvenementEnd(){
        return this.evenementEnd;
    }
    public void setEvenementEnd(String evenementEnd){
        this.evenementEnd = evenementEnd;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public SalleDto getSalle(){
        return this.salle;
    }

    public void setSalle(SalleDto salle){
        this.salle = salle;
    }
    public EvenementStateDto getEvenementState(){
        return this.evenementState;
    }

    public void setEvenementState(EvenementStateDto evenementState){
        this.evenementState = evenementState;
    }




}
