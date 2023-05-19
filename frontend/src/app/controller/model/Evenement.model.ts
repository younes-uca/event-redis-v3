import {EvenementStateDto} from './EvenementState.model';
import {SalleDto} from './Salle.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class EvenementDto  extends BaseDto{

    public id: number;
    public reference: string;
   public evenementStart: Date;
   public evenementEnd: Date;
    public description: string;
    public evenementStartMax: string ;
    public evenementStartMin: string ;
    public evenementEndMax: string ;
    public evenementEndMin: string ;
    public salle: SalleDto ;
    public evenementState: EvenementStateDto ;

}
