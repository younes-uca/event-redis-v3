package ma.sir.event.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.event.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "bloc_operatoir")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bloc_operatoir_seq",sequenceName="bloc_operatoir_seq",allocationSize=1, initialValue = 1)
public class BlocOperatoirHistory extends HistBusinessObject  {


    public BlocOperatoirHistory() {
    super();
    }

    public BlocOperatoirHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bloc_operatoir_seq")
    public Long getId() {
    return id;
    }
}

