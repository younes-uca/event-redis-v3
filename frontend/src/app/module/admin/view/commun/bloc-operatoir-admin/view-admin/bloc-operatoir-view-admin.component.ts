import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BlocOperatoirService} from 'src/app/controller/service/BlocOperatoir.service';
import {BlocOperatoirDto} from 'src/app/controller/model/BlocOperatoir.model';
import {BlocOperatoirCriteria} from 'src/app/controller/criteria/BlocOperatoirCriteria.model';

@Component({
  selector: 'app-bloc-operatoir-view-admin',
  templateUrl: './bloc-operatoir-view-admin.component.html'
})
export class BlocOperatoirViewAdminComponent extends AbstractViewController<BlocOperatoirDto, BlocOperatoirCriteria, BlocOperatoirService> implements OnInit {


    constructor(private blocOperatoirService: BlocOperatoirService){
        super(blocOperatoirService);
    }

    ngOnInit(): void {
    }




}
