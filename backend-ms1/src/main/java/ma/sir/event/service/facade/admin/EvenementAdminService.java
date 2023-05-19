package ma.sir.event.service.facade.admin;

import java.util.List;
import ma.sir.event.bean.core.Evenement;
import ma.sir.event.dao.criteria.core.EvenementCriteria;
import ma.sir.event.dao.criteria.history.EvenementHistoryCriteria;
import ma.sir.event.zynerator.service.IService;

public interface EvenementAdminService extends  IService<Evenement,EvenementCriteria, EvenementHistoryCriteria>  {

    List<Evenement> findBySalleId(Long id);
    int deleteBySalleId(Long id);
    List<Evenement> findByEvenementStateId(Long id);
    int deleteByEvenementStateId(Long id);

    Evenement findByReference(String reference);


}
