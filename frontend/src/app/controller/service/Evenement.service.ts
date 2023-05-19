import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EvenementDto} from '../model/Evenement.model';
import {EvenementCriteria} from '../criteria/EvenementCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {EvenementStateDto} from '../model/EvenementState.model';
import {SalleDto} from '../model/Salle.model';

@Injectable({
  providedIn: 'root'
})
export class EvenementService extends AbstractService<EvenementDto, EvenementCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/evenement/');
    }

    public constrcutDto(): EvenementDto {
        return new EvenementDto();
    }

    public constrcutCriteria(): EvenementCriteria {
        return new EvenementCriteria();
    }
}
