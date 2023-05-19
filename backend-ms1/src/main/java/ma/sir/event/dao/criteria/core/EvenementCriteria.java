package  ma.sir.event.dao.criteria.core;


import ma.sir.event.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class EvenementCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime evenementStart;
    private LocalDateTime evenementStartFrom;
    private LocalDateTime evenementStartTo;
    private LocalDateTime evenementEnd;
    private LocalDateTime evenementEndFrom;
    private LocalDateTime evenementEndTo;
    private String description;
    private String descriptionLike;

    private SalleCriteria salle ;
    private List<SalleCriteria> salles ;
    private EvenementStateCriteria evenementState ;
    private List<EvenementStateCriteria> evenementStates ;


    public EvenementCriteria(){}

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

    public LocalDateTime getEvenementStart(){
        return this.evenementStart;
    }
    public void setEvenementStart(LocalDateTime evenementStart){
        this.evenementStart = evenementStart;
    }
    public LocalDateTime getEvenementStartFrom(){
        return this.evenementStartFrom;
    }
    public void setEvenementStartFrom(LocalDateTime evenementStartFrom){
        this.evenementStartFrom = evenementStartFrom;
    }
    public LocalDateTime getEvenementStartTo(){
        return this.evenementStartTo;
    }
    public void setEvenementStartTo(LocalDateTime evenementStartTo){
        this.evenementStartTo = evenementStartTo;
    }
    public LocalDateTime getEvenementEnd(){
        return this.evenementEnd;
    }
    public void setEvenementEnd(LocalDateTime evenementEnd){
        this.evenementEnd = evenementEnd;
    }
    public LocalDateTime getEvenementEndFrom(){
        return this.evenementEndFrom;
    }
    public void setEvenementEndFrom(LocalDateTime evenementEndFrom){
        this.evenementEndFrom = evenementEndFrom;
    }
    public LocalDateTime getEvenementEndTo(){
        return this.evenementEndTo;
    }
    public void setEvenementEndTo(LocalDateTime evenementEndTo){
        this.evenementEndTo = evenementEndTo;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public SalleCriteria getSalle(){
        return this.salle;
    }

    public void setSalle(SalleCriteria salle){
        this.salle = salle;
    }
    public List<SalleCriteria> getSalles(){
        return this.salles;
    }

    public void setSalles(List<SalleCriteria> salles){
        this.salles = salles;
    }
    public EvenementStateCriteria getEvenementState(){
        return this.evenementState;
    }

    public void setEvenementState(EvenementStateCriteria evenementState){
        this.evenementState = evenementState;
    }
    public List<EvenementStateCriteria> getEvenementStates(){
        return this.evenementStates;
    }

    public void setEvenementStates(List<EvenementStateCriteria> evenementStates){
        this.evenementStates = evenementStates;
    }
}
