package ma.sir.event.bean.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ma.sir.event.zynerator.audit.AuditBusinessObject;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "bloc_operatoir_meta_data")
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@SequenceGenerator(name = "bloc_operatoir_meta_data_seq", sequenceName = "bloc_operatoir_meta_data_seq", allocationSize = 1, initialValue = 1)
public class BlocOperatoirMetaData extends AuditBusinessObject implements Serializable {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime lastUpdate;

    public BlocOperatoirMetaData() {
        super();
    }

    public BlocOperatoirMetaData(Long id) {
        this.id = id;
    }

    public BlocOperatoirMetaData(Long id, String reference) {
        this.id = id;
        this.reference = reference;
    }

    public BlocOperatoirMetaData(String reference) {
        this.lastUpdate = LocalDateTime.now();
    }


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bloc_operatoir_meta_data_seq")
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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
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
        BlocOperatoirMetaData blocOperatoir = (BlocOperatoirMetaData) o;
        return id != null && id.equals(blocOperatoir.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

