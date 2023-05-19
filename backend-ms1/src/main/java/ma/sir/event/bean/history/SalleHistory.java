package ma.sir.event.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.event.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "salle")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="salle_seq",sequenceName="salle_seq",allocationSize=1, initialValue = 1)
public class SalleHistory extends HistBusinessObject  {


    public SalleHistory() {
    super();
    }

    public SalleHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="salle_seq")
    public Long getId() {
    return id;
    }
}

