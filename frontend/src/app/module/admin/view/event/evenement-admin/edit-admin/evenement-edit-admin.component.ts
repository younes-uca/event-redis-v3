import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EvenementService} from 'src/app/controller/service/Evenement.service';
import {EvenementDto} from 'src/app/controller/model/Evenement.model';
import {EvenementCriteria} from 'src/app/controller/criteria/EvenementCriteria.model';


import {EvenementStateDto} from 'src/app/controller/model/EvenementState.model';
import {EvenementStateService} from 'src/app/controller/service/EvenementState.service';
import {SalleDto} from 'src/app/controller/model/Salle.model';
import {SalleService} from 'src/app/controller/service/Salle.service';

@Component({
  selector: 'app-evenement-edit-admin',
  templateUrl: './evenement-edit-admin.component.html'
})
export class EvenementEditAdminComponent extends AbstractEditController<EvenementDto, EvenementCriteria, EvenementService>   implements OnInit {


    private _validEvenementReference = true;

    private _validSalleReference = true;
    private _validSalleCode = true;
    private _validEvenementStateReference = true;
    private _validEvenementStateCode = true;



    constructor( private evenementService: EvenementService , private evenementStateService: EvenementStateService, private salleService: SalleService) {
        super(evenementService);
    }

    ngOnInit(): void {
    this.salle = new SalleDto();
    this.salleService.findAll().subscribe((data) => this.salles = data);
    this.evenementState = new EvenementStateDto();
    this.evenementStateService.findAll().subscribe((data) => this.evenementStates = data);
}
    public prepareEdit() {
        this.item.evenementStart = this.evenementService.format(this.item.evenementStart);
        this.item.evenementEnd = this.evenementService.format(this.item.evenementEnd);
    }



    public setValidation(value : boolean){
        this.validEvenementReference = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEvenementReference();
    }
    public validateEvenementReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validEvenementReference = false;
        } else {
            this.validEvenementReference = true;
        }
    }




   get salle(): SalleDto {
       return this.salleService.item;
   }
  set salle(value: SalleDto) {
        this.salleService.item = value;
   }
   get salles(): Array<SalleDto> {
        return this.salleService.items;
   }
   set salles(value: Array<SalleDto>) {
        this.salleService.items = value;
   }
   get createSalleDialog(): boolean {
       return this.salleService.createDialog;
   }
  set createSalleDialog(value: boolean) {
       this.salleService.createDialog= value;
   }
   get evenementState(): EvenementStateDto {
       return this.evenementStateService.item;
   }
  set evenementState(value: EvenementStateDto) {
        this.evenementStateService.item = value;
   }
   get evenementStates(): Array<EvenementStateDto> {
        return this.evenementStateService.items;
   }
   set evenementStates(value: Array<EvenementStateDto>) {
        this.evenementStateService.items = value;
   }
   get createEvenementStateDialog(): boolean {
       return this.evenementStateService.createDialog;
   }
  set createEvenementStateDialog(value: boolean) {
       this.evenementStateService.createDialog= value;
   }


    get validEvenementReference(): boolean {
        return this._validEvenementReference;
    }
    set validEvenementReference(value: boolean) {
        this._validEvenementReference = value;
    }

    get validSalleReference(): boolean {
        return this._validSalleReference;
    }
    set validSalleReference(value: boolean) {
        this._validSalleReference = value;
    }
    get validSalleCode(): boolean {
        return this._validSalleCode;
    }
    set validSalleCode(value: boolean) {
        this._validSalleCode = value;
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
