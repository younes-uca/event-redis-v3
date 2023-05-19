import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EvenementService} from 'src/app/controller/service/Evenement.service';
import {EvenementDto} from 'src/app/controller/model/Evenement.model';
import {EvenementCriteria} from 'src/app/controller/criteria/EvenementCriteria.model';

import {EvenementStateDto} from 'src/app/controller/model/EvenementState.model';
import {EvenementStateService} from 'src/app/controller/service/EvenementState.service';
import {SalleDto} from 'src/app/controller/model/Salle.model';
import {SalleService} from 'src/app/controller/service/Salle.service';
@Component({
  selector: 'app-evenement-view-admin',
  templateUrl: './evenement-view-admin.component.html'
})
export class EvenementViewAdminComponent extends AbstractViewController<EvenementDto, EvenementCriteria, EvenementService> implements OnInit {


    constructor(private evenementService: EvenementService, private evenementStateService: EvenementStateService, private salleService: SalleService){
        super(evenementService);
    }

    ngOnInit(): void {
        this.salle = new SalleDto();
        this.salleService.findAll().subscribe((data) => this.salles = data);
        this.evenementState = new EvenementStateDto();
        this.evenementStateService.findAll().subscribe((data) => this.evenementStates = data);
    }


    get salle(): SalleDto {
       return this.salleService.item;
    }
    set salle(value: SalleDto) {
        this.salleService.item = value;
    }
    get salles():Array<SalleDto> {
       return this.salleService.items;
    }
    set salles(value: Array<SalleDto>) {
        this.salleService.items = value;
    }
    get evenementState(): EvenementStateDto {
       return this.evenementStateService.item;
    }
    set evenementState(value: EvenementStateDto) {
        this.evenementStateService.item = value;
    }
    get evenementStates():Array<EvenementStateDto> {
       return this.evenementStateService.items;
    }
    set evenementStates(value: Array<EvenementStateDto>) {
        this.evenementStateService.items = value;
    }


}
