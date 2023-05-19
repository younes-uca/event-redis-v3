package ma.sir.event.zynerator.service;

import ma.sir.event.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.event.zynerator.criteria.BaseCriteria;
import ma.sir.event.zynerator.history.HistBusinessObject;
import ma.sir.event.zynerator.history.HistCriteria;
import ma.sir.event.zynerator.repository.AbstractHistoryRepository;
import ma.sir.event.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}