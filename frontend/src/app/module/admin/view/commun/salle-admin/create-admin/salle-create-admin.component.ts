import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SalleService} from 'src/app/controller/service/Salle.service';
import {SalleDto} from 'src/app/controller/model/Salle.model';
import {SalleCriteria} from 'src/app/controller/criteria/SalleCriteria.model';
import {BlocOperatoirDto} from 'src/app/controller/model/BlocOperatoir.model';
import {BlocOperatoirService} from 'src/app/controller/service/BlocOperatoir.service';
@Component({
  selector: 'app-salle-create-admin',
  templateUrl: './salle-create-admin.component.html'
})
export class SalleCreateAdminComponent extends AbstractCreateController<SalleDto, SalleCriteria, SalleService>  implements OnInit {



   private _validSalleReference = true;
   private _validSalleCode = true;
    private _validBlocOperatoirReference = true;
    private _validBlocOperatoirCode = true;

    constructor( private salleService: SalleService , private blocOperatoirService: BlocOperatoirService) {
        super(salleService);
    }

    ngOnInit(): void {
    this.blocOperatoir = new BlocOperatoirDto();
    this.blocOperatoirService.findAll().subscribe((data) => this.blocOperatoirs = data);
}





    public setValidation(value: boolean){
        this.validSalleReference = value;
        this.validSalleCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSalleReference();
        this.validateSalleCode();
    }

    public validateSalleReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validSalleReference = false;
        } else {
            this.validSalleReference = true;
        }
    }
    public validateSalleCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validSalleCode = false;
        } else {
            this.validSalleCode = true;
        }
    }


    public async openCreateBlocOperatoir(blocOperatoir: string) {
    const isPermistted = await this.roleService.isPermitted('BlocOperatoir', 'add');
    if(isPermistted) {
         this.blocOperatoir = new BlocOperatoirDto();
         this.createBlocOperatoirDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get blocOperatoir(): BlocOperatoirDto {
        return this.blocOperatoirService.item;
    }
    set blocOperatoir(value: BlocOperatoirDto) {
        this.blocOperatoirService.item = value;
    }
    get blocOperatoirs(): Array<BlocOperatoirDto> {
        return this.blocOperatoirService.items;
    }
    set blocOperatoirs(value: Array<BlocOperatoirDto>) {
        this.blocOperatoirService.items = value;
    }
    get createBlocOperatoirDialog(): boolean {
       return this.blocOperatoirService.createDialog;
    }
    set createBlocOperatoirDialog(value: boolean) {
        this.blocOperatoirService.createDialog= value;
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
