package ma.sir.event.bean.core;

import java.io.Serializable;
import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ma.sir.event.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "salle")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@SequenceGenerator(name="salle_seq",sequenceName="salle_seq",allocationSize=1, initialValue = 1)
public class Salle   extends AuditBusinessObject  implements Serializable {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String code;

    private BlocOperatoir blocOperatoir ;
    


    public Salle(){
        super();
    }

    public Salle(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="salle_seq")
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    public BlocOperatoir getBlocOperatoir(){
        return this.blocOperatoir;
    }
    public void setBlocOperatoir(BlocOperatoir blocOperatoir){
        this.blocOperatoir = blocOperatoir;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return id != null && id.equals(salle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

