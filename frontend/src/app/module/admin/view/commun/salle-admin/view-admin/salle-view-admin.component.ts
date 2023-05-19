import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SalleService} from 'src/app/controller/service/Salle.service';
import {SalleDto} from 'src/app/controller/model/Salle.model';
import {SalleCriteria} from 'src/app/controller/criteria/SalleCriteria.model';

import {BlocOperatoirDto} from 'src/app/controller/model/BlocOperatoir.model';
import {BlocOperatoirService} from 'src/app/controller/service/BlocOperatoir.service';
@Component({
  selector: 'app-salle-view-admin',
  templateUrl: './salle-view-admin.component.html'
})
export class SalleViewAdminComponent extends AbstractViewController<SalleDto, SalleCriteria, SalleService> implements OnInit {


    constructor(private salleService: SalleService, private blocOperatoirService: BlocOperatoirService){
        super(salleService);
    }

    ngOnInit(): void {
        this.blocOperatoir = new BlocOperatoirDto();
        this.blocOperatoirService.findAll().subscribe((data) => this.blocOperatoirs = data);
    }


    get blocOperatoir(): BlocOperatoirDto {
       return this.blocOperatoirService.item;
    }
    set blocOperatoir(value: BlocOperatoirDto) {
        this.blocOperatoirService.item = value;
    }
    get blocOperatoirs():Array<BlocOperatoirDto> {
       return this.blocOperatoirService.items;
    }
    set blocOperatoirs(value: Array<BlocOperatoirDto>) {
        this.blocOperatoirService.items = value;
    }


}
