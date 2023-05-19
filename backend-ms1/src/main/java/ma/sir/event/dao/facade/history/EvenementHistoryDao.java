package ma.sir.event.dao.facade.history;

import ma.sir.event.zynerator.repository.AbstractHistoryRepository;
import ma.sir.event.bean.history.EvenementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementHistoryDao extends AbstractHistoryRepository<EvenementHistory,Long> {

}
