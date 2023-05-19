package  ma.sir.event.dao.specification.history;

import ma.sir.event.zynerator.specification.AbstractHistorySpecification;
import ma.sir.event.dao.criteria.history.BlocOperatoirHistoryCriteria;
import ma.sir.event.bean.history.BlocOperatoirHistory;


public class BlocOperatoirHistorySpecification extends AbstractHistorySpecification<BlocOperatoirHistoryCriteria, BlocOperatoirHistory> {

    public BlocOperatoirHistorySpecification(BlocOperatoirHistoryCriteria criteria) {
        super(criteria);
    }

    public BlocOperatoirHistorySpecification(BlocOperatoirHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
