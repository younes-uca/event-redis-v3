package ma.sir.event.service.impl.admin;

import com.corundumstudio.socketio.SocketIOServer;
import ma.sir.event.bean.core.Evenement;
import ma.sir.event.bean.core.Salle;
import ma.sir.event.bean.history.EvenementHistory;
import ma.sir.event.dao.criteria.core.EvenementCriteria;
import ma.sir.event.dao.criteria.history.EvenementHistoryCriteria;
import ma.sir.event.dao.facade.core.EvenementDao;
import ma.sir.event.dao.facade.history.EvenementHistoryDao;
import ma.sir.event.dao.specification.core.EvenementSpecification;
import ma.sir.event.service.facade.admin.EvenementAdminService;
import ma.sir.event.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.event.service.facade.admin.EvenementStateAdminService ;
import ma.sir.event.service.facade.admin.SalleAdminService ;

@Service
public class EvenementAdminServiceImpl extends AbstractServiceImpl<Evenement,EvenementHistory, EvenementCriteria, EvenementHistoryCriteria, EvenementDao,
EvenementHistoryDao> implements EvenementAdminService {

    private final SocketIOServer socketIOServer;

    @Override
    public Evenement create(Evenement evenement) {
//        socketIOServer.getBroadcastOperations().sendEvent("matched_objects", evenement);
        return super.create(evenement);
    }

    public Evenement findByReferenceEntity(Evenement t){
        return  dao.findByReference(t.getReference());
    }


   // @Cacheable(cacheNames = "itemCache", key = "#id", cacheManager = "redisCacheManager")
    public List<Evenement> findBySalleId(Long id){
        return dao.findBySalleId(id);
    }
    public int deleteBySalleId(Long id){
        return dao.deleteBySalleId(id);
    }
    public List<Evenement> findByEvenementStateId(Long id){
        return dao.findByEvenementStateId(id);
    }
    public int deleteByEvenementStateId(Long id){
        return dao.deleteByEvenementStateId(id);
    }

    @Override
    public Evenement findByReference(String reference) {
        return dao.findByReference(reference);
    }

    public void configure() {
        super.configure(Evenement.class,EvenementHistory.class, EvenementHistoryCriteria.class, EvenementSpecification.class);
    }

    @Autowired
    private EvenementStateAdminService evenementStateService ;
    @Autowired
    private SalleAdminService salleService ;
    public EvenementAdminServiceImpl(EvenementDao dao, EvenementHistoryDao historyDao, SocketIOServer socketIOServer) {
        super(dao, historyDao);
        this.socketIOServer = socketIOServer;
    }

}