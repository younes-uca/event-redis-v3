package  ma.sir.event.dao.specification.history;

import ma.sir.event.zynerator.specification.AbstractHistorySpecification;
import ma.sir.event.dao.criteria.history.EvenementStateHistoryCriteria;
import ma.sir.event.bean.history.EvenementStateHistory;


public class EvenementStateHistorySpecification extends AbstractHistorySpecification<EvenementStateHistoryCriteria, EvenementStateHistory> {

    public EvenementStateHistorySpecification(EvenementStateHistoryCriteria criteria) {
        super(criteria);
    }

    public EvenementStateHistorySpecification(EvenementStateHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
