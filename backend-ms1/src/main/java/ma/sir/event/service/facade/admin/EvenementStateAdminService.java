package ma.sir.event.service.facade.admin;

import java.util.List;
import ma.sir.event.bean.core.EvenementState;
import ma.sir.event.dao.criteria.core.EvenementStateCriteria;
import ma.sir.event.dao.criteria.history.EvenementStateHistoryCriteria;
import ma.sir.event.zynerator.service.IService;

public interface EvenementStateAdminService extends  IService<EvenementState,EvenementStateCriteria, EvenementStateHistoryCriteria>  {




}
