import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class EvenementStateCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public code: string;
    public codeLike: string;

}
