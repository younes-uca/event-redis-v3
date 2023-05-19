package ma.sir.event.service.impl.admin;

import ma.sir.event.bean.core.BlocOperatoir;
import ma.sir.event.bean.history.BlocOperatoirHistory;
import ma.sir.event.dao.criteria.core.BlocOperatoirCriteria;
import ma.sir.event.dao.criteria.history.BlocOperatoirHistoryCriteria;
import ma.sir.event.dao.facade.core.BlocOperatoirDao;
import ma.sir.event.dao.facade.history.BlocOperatoirHistoryDao;
import ma.sir.event.dao.specification.core.BlocOperatoirSpecification;
import ma.sir.event.service.facade.admin.BlocOperatoirAdminService;
import ma.sir.event.zynerator.service.AbstractServiceImpl;
import ma.sir.event.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class BlocOperatoirAdminServiceImpl extends AbstractServiceImpl<BlocOperatoir,BlocOperatoirHistory, BlocOperatoirCriteria, BlocOperatoirHistoryCriteria, BlocOperatoirDao,
BlocOperatoirHistoryDao> implements BlocOperatoirAdminService {


    public BlocOperatoir findByReferenceEntity(BlocOperatoir t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(BlocOperatoir.class,BlocOperatoirHistory.class, BlocOperatoirHistoryCriteria.class, BlocOperatoirSpecification.class);
    }

    public BlocOperatoirAdminServiceImpl(BlocOperatoirDao dao, BlocOperatoirHistoryDao historyDao) {
        super(dao, historyDao);
    }

}