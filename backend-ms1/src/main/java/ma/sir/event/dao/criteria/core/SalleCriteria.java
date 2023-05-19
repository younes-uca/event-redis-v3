package  ma.sir.event.dao.criteria.core;


import ma.sir.event.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SalleCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String code;
    private String codeLike;

    private BlocOperatoirCriteria blocOperatoir ;
    private List<BlocOperatoirCriteria> blocOperatoirs ;


    public SalleCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }


    public BlocOperatoirCriteria getBlocOperatoir(){
        return this.blocOperatoir;
    }

    public void setBlocOperatoir(BlocOperatoirCriteria blocOperatoir){
        this.blocOperatoir = blocOperatoir;
    }
    public List<BlocOperatoirCriteria> getBlocOperatoirs(){
        return this.blocOperatoirs;
    }

    public void setBlocOperatoirs(List<BlocOperatoirCriteria> blocOperatoirs){
        this.blocOperatoirs = blocOperatoirs;
    }
}
