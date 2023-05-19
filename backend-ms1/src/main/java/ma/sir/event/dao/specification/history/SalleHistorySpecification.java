package  ma.sir.event.dao.specification.history;

import ma.sir.event.zynerator.specification.AbstractHistorySpecification;
import ma.sir.event.dao.criteria.history.SalleHistoryCriteria;
import ma.sir.event.bean.history.SalleHistory;


public class SalleHistorySpecification extends AbstractHistorySpecification<SalleHistoryCriteria, SalleHistory> {

    public SalleHistorySpecification(SalleHistoryCriteria criteria) {
        super(criteria);
    }

    public SalleHistorySpecification(SalleHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
