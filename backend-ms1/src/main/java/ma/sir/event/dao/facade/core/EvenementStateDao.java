package ma.sir.event.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.event.zynerator.repository.AbstractRepository;
import ma.sir.event.bean.core.EvenementState;
import org.springframework.stereotype.Repository;
import ma.sir.event.bean.core.EvenementState;
import java.util.List;


@Repository
public interface EvenementStateDao extends AbstractRepository<EvenementState,Long>  {
    EvenementState findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EvenementState(item.id,item.reference) FROM EvenementState item")
    List<EvenementState> findAllOptimized();
}
