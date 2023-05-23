package ma.sir.event.service.facade.admin;

import java.time.LocalDateTime;
import java.util.List;
import ma.sir.event.bean.core.Evenement;
import ma.sir.event.bean.core.EvenementRedis;
import ma.sir.event.dao.criteria.core.EvenementCriteria;
import ma.sir.event.dao.criteria.history.EvenementHistoryCriteria;
import ma.sir.event.service.impl.admin.BlocOperatoireInformation;
import ma.sir.event.zynerator.service.IService;

public interface EvenementAdminService extends  IService<Evenement,EvenementCriteria, EvenementHistoryCriteria>  {

    List<Evenement> findBySalleId(Long id);

    BlocOperatoireInformation findBySalleBlocOperatoirReference(String reference, LocalDateTime lastUpdate);

    int deleteBySalleId(Long id);
    List<Evenement> findByEvenementStateId(Long id);
    int deleteByEvenementStateId(Long id);

    Evenement findByReference(String reference);


}
