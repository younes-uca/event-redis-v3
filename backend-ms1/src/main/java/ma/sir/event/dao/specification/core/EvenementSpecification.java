package  ma.sir.event.dao.specification.core;

import ma.sir.event.zynerator.specification.AbstractSpecification;
import ma.sir.event.dao.criteria.core.EvenementCriteria;
import ma.sir.event.bean.core.Evenement;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EvenementSpecification extends  AbstractSpecification<EvenementCriteria, Evenement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("evenementStart", criteria.getEvenementStart(), criteria.getEvenementStartFrom(), criteria.getEvenementStartTo());
        addPredicate("evenementEnd", criteria.getEvenementEnd(), criteria.getEvenementEndFrom(), criteria.getEvenementEndTo());
        addPredicateFk("salle","id", criteria.getSalle()==null?null:criteria.getSalle().getId());
        addPredicateFk("salle","id", criteria.getSalles());
        addPredicateFk("salle","code", criteria.getSalle()==null?null:criteria.getSalle().getCode());
        addPredicateFk("evenementState","id", criteria.getEvenementState()==null?null:criteria.getEvenementState().getId());
        addPredicateFk("evenementState","id", criteria.getEvenementStates());
        addPredicateFk("evenementState","code", criteria.getEvenementState()==null?null:criteria.getEvenementState().getCode());
    }

    public EvenementSpecification(EvenementCriteria criteria) {
        super(criteria);
    }

    public EvenementSpecification(EvenementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
