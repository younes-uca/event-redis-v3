import {BlocOperatoirDto} from './BlocOperatoir.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SalleDto  extends BaseDto{

    public id: number;
    public reference: string;
    public code: string;
    public blocOperatoir: BlocOperatoirDto ;

}
