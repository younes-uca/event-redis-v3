import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {BlocOperatoirService} from 'src/app/controller/service/BlocOperatoir.service';
import {BlocOperatoirDto} from 'src/app/controller/model/BlocOperatoir.model';
import {BlocOperatoirCriteria} from 'src/app/controller/criteria/BlocOperatoirCriteria.model';



@Component({
  selector: 'app-bloc-operatoir-edit-admin',
  templateUrl: './bloc-operatoir-edit-admin.component.html'
})
export class BlocOperatoirEditAdminComponent extends AbstractEditController<BlocOperatoirDto, BlocOperatoirCriteria, BlocOperatoirService>   implements OnInit {


    private _validBlocOperatoirReference = true;
    private _validBlocOperatoirCode = true;




    constructor( private blocOperatoirService: BlocOperatoirService ) {
        super(blocOperatoirService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validBlocOperatoirReference = value;
        this.validBlocOperatoirCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateBlocOperatoirReference();
        this.validateBlocOperatoirCode();
    }
    public validateBlocOperatoirReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validBlocOperatoirReference = false;
        } else {
            this.validBlocOperatoirReference = true;
        }
    }
    public validateBlocOperatoirCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validBlocOperatoirCode = false;
        } else {
            this.validBlocOperatoirCode = true;
        }
    }






    get validBlocOperatoirReference(): boolean {
        return this._validBlocOperatoirReference;
    }
    set validBlocOperatoirReference(value: boolean) {
        this._validBlocOperatoirReference = value;
    }
    get validBlocOperatoirCode(): boolean {
        return this._validBlocOperatoirCode;
    }
    set validBlocOperatoirCode(value: boolean) {
        this._validBlocOperatoirCode = value;
    }

}
