import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';
import {EvenementDto} from "./Evenement.model";


export class BlocOperatoirInformationDto  extends BaseDto{

    public id: number;
    public reference: string;
    public lastUpdate: string;
    public evenementRediss: Array<EvenementDto>;

}
