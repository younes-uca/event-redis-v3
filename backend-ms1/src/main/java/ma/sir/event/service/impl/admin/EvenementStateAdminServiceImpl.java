package ma.sir.event.service.impl.admin;

import ma.sir.event.bean.core.EvenementState;
import ma.sir.event.bean.history.EvenementStateHistory;
import ma.sir.event.dao.criteria.core.EvenementStateCriteria;
import ma.sir.event.dao.criteria.history.EvenementStateHistoryCriteria;
import ma.sir.event.dao.facade.core.EvenementStateDao;
import ma.sir.event.dao.facade.history.EvenementStateHistoryDao;
import ma.sir.event.dao.specification.core.EvenementStateSpecification;
import ma.sir.event.service.facade.admin.EvenementStateAdminService;
import ma.sir.event.zynerator.service.AbstractServiceImpl;
import ma.sir.event.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class EvenementStateAdminServiceImpl extends AbstractServiceImpl<EvenementState,EvenementStateHistory, EvenementStateCriteria, EvenementStateHistoryCriteria, EvenementStateDao,
EvenementStateHistoryDao> implements EvenementStateAdminService {


    public EvenementState findByReferenceEntity(EvenementState t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(EvenementState.class,EvenementStateHistory.class, EvenementStateHistoryCriteria.class, EvenementStateSpecification.class);
    }

    public EvenementStateAdminServiceImpl(EvenementStateDao dao, EvenementStateHistoryDao historyDao) {
        super(dao, historyDao);
    }

}