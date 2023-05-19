import {BlocOperatoirCriteria} from './BlocOperatoirCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SalleCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public code: string;
    public codeLike: string;
  public blocOperatoir: BlocOperatoirCriteria ;
  public blocOperatoirs: Array<BlocOperatoirCriteria> ;

}
