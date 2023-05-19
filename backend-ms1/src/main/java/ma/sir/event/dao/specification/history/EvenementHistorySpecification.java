package  ma.sir.event.dao.specification.history;

import ma.sir.event.zynerator.specification.AbstractHistorySpecification;
import ma.sir.event.dao.criteria.history.EvenementHistoryCriteria;
import ma.sir.event.bean.history.EvenementHistory;


public class EvenementHistorySpecification extends AbstractHistorySpecification<EvenementHistoryCriteria, EvenementHistory> {

    public EvenementHistorySpecification(EvenementHistoryCriteria criteria) {
        super(criteria);
    }

    public EvenementHistorySpecification(EvenementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
