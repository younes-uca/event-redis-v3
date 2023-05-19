package ma.sir.event.service.impl.admin;

import ma.sir.event.bean.core.Salle;
import ma.sir.event.bean.history.SalleHistory;
import ma.sir.event.dao.criteria.core.SalleCriteria;
import ma.sir.event.dao.criteria.history.SalleHistoryCriteria;
import ma.sir.event.dao.facade.core.SalleDao;
import ma.sir.event.dao.facade.history.SalleHistoryDao;
import ma.sir.event.dao.specification.core.SalleSpecification;
import ma.sir.event.service.facade.admin.SalleAdminService;
import ma.sir.event.zynerator.service.AbstractServiceImpl;
import ma.sir.event.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.event.service.facade.admin.BlocOperatoirAdminService ;


import java.util.List;
@Service
public class SalleAdminServiceImpl extends AbstractServiceImpl<Salle,SalleHistory, SalleCriteria, SalleHistoryCriteria, SalleDao,
SalleHistoryDao> implements SalleAdminService {


    public Salle findByReferenceEntity(Salle t){
        return  dao.findByCode(t.getCode());
    }

    public List<Salle> findByBlocOperatoirId(Long id){
        return dao.findByBlocOperatoirId(id);
    }
    public int deleteByBlocOperatoirId(Long id){

        return dao.deleteByBlocOperatoirId(id);
    }

    public void configure() {
        super.configure(Salle.class,SalleHistory.class, SalleHistoryCriteria.class, SalleSpecification.class);
    }

    @Autowired
    private BlocOperatoirAdminService blocOperatoirService ;
    public SalleAdminServiceImpl(SalleDao dao, SalleHistoryDao historyDao) {
        super(dao, historyDao);
    }

}