package  ma.sir.event.dao.specification.core;

import ma.sir.event.zynerator.specification.AbstractSpecification;
import ma.sir.event.dao.criteria.core.SalleCriteria;
import ma.sir.event.bean.core.Salle;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SalleSpecification extends  AbstractSpecification<SalleCriteria, Salle>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("blocOperatoir","id", criteria.getBlocOperatoir()==null?null:criteria.getBlocOperatoir().getId());
        addPredicateFk("blocOperatoir","id", criteria.getBlocOperatoirs());
        addPredicateFk("blocOperatoir","code", criteria.getBlocOperatoir()==null?null:criteria.getBlocOperatoir().getCode());
    }

    public SalleSpecification(SalleCriteria criteria) {
        super(criteria);
    }

    public SalleSpecification(SalleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
