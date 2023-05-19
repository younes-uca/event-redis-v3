package ma.sir.event.bean.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ma.sir.event.zynerator.audit.AuditBusinessObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "bloc_operatoir")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@SequenceGenerator(name = "bloc_operatoir_seq", sequenceName = "bloc_operatoir_seq", allocationSize = 1, initialValue = 1)
public class BlocOperatoir extends AuditBusinessObject implements Serializable {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String code;


    public BlocOperatoir() {
        super();
    }

    public BlocOperatoir(Long id) {
        this.id = id;
    }

    public BlocOperatoir(Long id, String reference) {
        this.id = id;
        this.reference = reference;
    }


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bloc_operatoir_seq")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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
        BlocOperatoir blocOperatoir = (BlocOperatoir) o;
        return id != null && id.equals(blocOperatoir.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

