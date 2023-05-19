package ma.sir.event.dao.facade.history;

import ma.sir.event.zynerator.repository.AbstractHistoryRepository;
import ma.sir.event.bean.history.BlocOperatoirHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocOperatoirHistoryDao extends AbstractHistoryRepository<BlocOperatoirHistory,Long> {

}
