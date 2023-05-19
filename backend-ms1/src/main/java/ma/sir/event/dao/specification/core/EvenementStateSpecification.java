package  ma.sir.event.dao.specification.core;

import ma.sir.event.zynerator.specification.AbstractSpecification;
import ma.sir.event.dao.criteria.core.EvenementStateCriteria;
import ma.sir.event.bean.core.EvenementState;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EvenementStateSpecification extends  AbstractSpecification<EvenementStateCriteria, EvenementState>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public EvenementStateSpecification(EvenementStateCriteria criteria) {
        super(criteria);
    }

    public EvenementStateSpecification(EvenementStateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
