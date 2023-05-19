package ma.sir.event.dao.facade.history;

import ma.sir.event.zynerator.repository.AbstractHistoryRepository;
import ma.sir.event.bean.history.EvenementStateHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementStateHistoryDao extends AbstractHistoryRepository<EvenementStateHistory,Long> {

}
