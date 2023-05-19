package ma.sir.event.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.event.zynerator.repository.AbstractRepository;
import ma.sir.event.bean.core.BlocOperatoir;
import org.springframework.stereotype.Repository;
import ma.sir.event.bean.core.BlocOperatoir;
import java.util.List;


@Repository
public interface BlocOperatoirDao extends AbstractRepository<BlocOperatoir,Long>  {
    BlocOperatoir findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW BlocOperatoir(item.id,item.reference) FROM BlocOperatoir item")
    List<BlocOperatoir> findAllOptimized();
}
