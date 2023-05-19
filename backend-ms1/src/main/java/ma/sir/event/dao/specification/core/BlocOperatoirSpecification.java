package  ma.sir.event.dao.specification.core;

import ma.sir.event.zynerator.specification.AbstractSpecification;
import ma.sir.event.dao.criteria.core.BlocOperatoirCriteria;
import ma.sir.event.bean.core.BlocOperatoir;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BlocOperatoirSpecification extends  AbstractSpecification<BlocOperatoirCriteria, BlocOperatoir>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public BlocOperatoirSpecification(BlocOperatoirCriteria criteria) {
        super(criteria);
    }

    public BlocOperatoirSpecification(BlocOperatoirCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
