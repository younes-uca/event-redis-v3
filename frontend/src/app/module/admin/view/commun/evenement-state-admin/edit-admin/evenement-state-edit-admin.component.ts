import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EvenementStateService} from 'src/app/controller/service/EvenementState.service';
import {EvenementStateDto} from 'src/app/controller/model/EvenementState.model';
import {EvenementStateCriteria} from 'src/app/controller/criteria/EvenementStateCriteria.model';



@Component({
  selector: 'app-evenement-state-edit-admin',
  templateUrl: './evenement-state-edit-admin.component.html'
})
export class EvenementStateEditAdminComponent extends AbstractEditController<EvenementStateDto, EvenementStateCriteria, EvenementStateService>   implements OnInit {


    private _validEvenementStateReference = true;
    private _validEvenementStateCode = true;




    constructor( private evenementStateService: EvenementStateService ) {
        super(evenementStateService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validEvenementStateReference = value;
        this.validEvenementStateCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEvenementStateReference();
        this.validateEvenementStateCode();
    }
    public validateEvenementStateReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validEvenementStateReference = false;
        } else {
            this.validEvenementStateReference = true;
        }
    }
    public validateEvenementStateCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validEvenementStateCode = false;
        } else {
            this.validEvenementStateCode = true;
        }
    }






    get validEvenementStateReference(): boolean {
        return this._validEvenementStateReference;
    }
    set validEvenementStateReference(value: boolean) {
        this._validEvenementStateReference = value;
    }
    get validEvenementStateCode(): boolean {
        return this._validEvenementStateCode;
    }
    set validEvenementStateCode(value: boolean) {
        this._validEvenementStateCode = value;
    }

}
