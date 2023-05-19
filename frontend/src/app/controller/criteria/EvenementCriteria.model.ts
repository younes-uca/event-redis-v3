import {EvenementStateCriteria} from './EvenementStateCriteria.model';
import {SalleCriteria} from './SalleCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class EvenementCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public evenementStart: Date;
    public evenementStartFrom: Date;
    public evenementStartTo: Date;
    public evenementEnd: Date;
    public evenementEndFrom: Date;
    public evenementEndTo: Date;
    public description: string;
    public descriptionLike: string;
  public salle: SalleCriteria ;
  public salles: Array<SalleCriteria> ;
  public evenementState: EvenementStateCriteria ;
  public evenementStates: Array<EvenementStateCriteria> ;

}
