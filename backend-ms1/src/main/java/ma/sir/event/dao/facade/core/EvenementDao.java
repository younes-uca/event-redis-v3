package ma.sir.event.dao.facade.core;

import ma.sir.event.bean.core.EvenementRedis;
import org.springframework.data.jpa.repository.Query;
import ma.sir.event.zynerator.repository.AbstractRepository;
import ma.sir.event.bean.core.Evenement;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EvenementDao extends AbstractRepository<Evenement,Long>  {
    Evenement findByReference(String reference);
    int deleteByReference(String reference);
    List<Evenement> findBySalleId(Long id);
    int deleteBySalleId(Long id);
    List<Evenement> findByEvenementStateId(Long id);
    int deleteByEvenementStateId(Long id);

    @Query("SELECT NEW Evenement(item.id,item.reference) FROM Evenement item")
    List<Evenement> findAllOptimized();

    List<Evenement> findBySalleBlocOperatoirReference(String reference);
}
