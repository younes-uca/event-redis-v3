import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EvenementStateService} from 'src/app/controller/service/EvenementState.service';
import {EvenementStateDto} from 'src/app/controller/model/EvenementState.model';
import {EvenementStateCriteria} from 'src/app/controller/criteria/EvenementStateCriteria.model';

@Component({
  selector: 'app-evenement-state-view-admin',
  templateUrl: './evenement-state-view-admin.component.html'
})
export class EvenementStateViewAdminComponent extends AbstractViewController<EvenementStateDto, EvenementStateCriteria, EvenementStateService> implements OnInit {


    constructor(private evenementStateService: EvenementStateService){
        super(evenementStateService);
    }

    ngOnInit(): void {
    }




}
