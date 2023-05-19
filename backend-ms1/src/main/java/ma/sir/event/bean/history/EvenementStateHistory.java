package ma.sir.event.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.event.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "evenement_state")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="evenement_state_seq",sequenceName="evenement_state_seq",allocationSize=1, initialValue = 1)
public class EvenementStateHistory extends HistBusinessObject  {


    public EvenementStateHistory() {
    super();
    }

    public EvenementStateHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="evenement_state_seq")
    public Long getId() {
    return id;
    }
}

