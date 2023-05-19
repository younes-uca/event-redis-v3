package ma.sir.event.bean.core;

import java.io.Serializable;
import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ma.sir.event.zynerator.audit.AuditBusinessObject;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Loader;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "evenement")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "itemCache")
@SequenceGenerator(name="evenement_seq",sequenceName="evenement_seq",allocationSize=1, initialValue = 1)
public class Evenement   extends AuditBusinessObject implements Serializable {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime evenementStart ;
    private LocalDateTime evenementEnd ;
    @Column(length = 500)
    private String description;

    private Salle salle ;
    
    private EvenementState evenementState ;
    


    public Evenement(){
        super();
    }

    public Evenement(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="evenement_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getEvenementStart(){
        return this.evenementStart;
    }
    public void setEvenementStart(LocalDateTime evenementStart){
        this.evenementStart = evenementStart;
    }
    public LocalDateTime getEvenementEnd(){
        return this.evenementEnd;
    }
    public void setEvenementEnd(LocalDateTime evenementEnd){
        this.evenementEnd = evenementEnd;
    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    public Salle getSalle(){
        return this.salle;
    }
    public void setSalle(Salle salle){
        this.salle = salle;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public EvenementState getEvenementState(){
        return this.evenementState;
    }
    public void setEvenementState(EvenementState evenementState){
        this.evenementState = evenementState;
    }

    @Transient
    @JsonIgnore
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evenement evenement = (Evenement) o;
        return id != null && id.equals(evenement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

