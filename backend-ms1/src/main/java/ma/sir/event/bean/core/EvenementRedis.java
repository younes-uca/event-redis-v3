package ma.sir.event.bean.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ma.sir.event.ws.dto.EvenementStateDto;
import ma.sir.event.ws.dto.SalleDto;
import ma.sir.event.zynerator.audit.AuditBusinessObject;
import ma.sir.event.zynerator.bean.BusinessObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@RedisHash("Evenement")
@JsonFormat
public class EvenementRedis extends AuditBusinessObject implements Serializable {
    @Id
    private Long id;

    @Column(length = 500)
    private String reference;
    private String evenementStart ;
    private String evenementEnd ;
    @Column(length = 500)
    private String description;

    private SalleDto salle ;

    private EvenementStateDto evenementState ;

    private String label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getEvenementStart() {
        return evenementStart;
    }

    public void setEvenementStart(String evenementStart) {
        this.evenementStart = evenementStart;
    }

    public String getEvenementEnd() {
        return evenementEnd;
    }

    public void setEvenementEnd(String evenementEnd) {
        this.evenementEnd = evenementEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SalleDto getSalle() {
        return salle;
    }

    public void setSalle(SalleDto salle) {
        this.salle = salle;
    }

    public EvenementStateDto getEvenementState() {
        return evenementState;
    }

    public void setEvenementState(EvenementStateDto evenementState) {
        this.evenementState = evenementState;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
