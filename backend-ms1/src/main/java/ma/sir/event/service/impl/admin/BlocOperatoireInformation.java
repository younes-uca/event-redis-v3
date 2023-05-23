package ma.sir.event.service.impl.admin;

import ma.sir.event.bean.core.EvenementRedis;

import java.util.List;

public class BlocOperatoireInformation {
    private String reference;
    private String lastUpdate;
    private List<EvenementRedis> evenementRediss;

    public BlocOperatoireInformation(String reference, String lastUpdate, List<EvenementRedis> evenementRediss) {
        this.evenementRediss = evenementRediss;
        this.reference = reference;
        this.lastUpdate = lastUpdate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<EvenementRedis> getEvenementRediss() {
        return evenementRediss;
    }

    public void setEvenementRediss(List<EvenementRedis> evenementRediss) {
        this.evenementRediss = evenementRediss;
    }
}
