package ma.sir.event.dao.facade.history;

import ma.sir.event.zynerator.repository.AbstractHistoryRepository;
import ma.sir.event.bean.history.SalleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleHistoryDao extends AbstractHistoryRepository<SalleHistory,Long> {

}
