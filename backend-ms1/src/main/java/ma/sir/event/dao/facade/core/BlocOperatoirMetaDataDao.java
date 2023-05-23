package ma.sir.event.dao.facade.core;

import ma.sir.event.bean.core.BlocOperatoir;
import ma.sir.event.bean.core.BlocOperatoirMetaData;
import ma.sir.event.zynerator.repository.AbstractRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlocOperatoirMetaDataDao extends AbstractRepository<BlocOperatoirMetaData,Long>  {
    BlocOperatoirMetaData findByReference(String reference);
    int deleteByReference(String reference);

}
