package ma.sir.event.dao.facade.core;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import ma.sir.event.zynerator.repository.AbstractRepository;
import ma.sir.event.bean.core.Salle;
import org.springframework.stereotype.Repository;
import ma.sir.event.bean.core.Salle;
import java.util.List;


@Repository
public interface SalleDao extends AbstractRepository<Salle,Long>  {
    @Cacheable("salle")
    Salle findByCode(String code);
    int deleteByCode(String code);

    List<Salle> findByBlocOperatoirId(Long id);
    int deleteByBlocOperatoirId(Long id);

    @Query("SELECT NEW Salle(item.id,item.reference) FROM Salle item")
    List<Salle> findAllOptimized();
}
