import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EvenementStateDto} from '../model/EvenementState.model';
import {EvenementStateCriteria} from '../criteria/EvenementStateCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class EvenementStateService extends AbstractService<EvenementStateDto, EvenementStateCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/evenementState/');
    }

    public constrcutDto(): EvenementStateDto {
        return new EvenementStateDto();
    }

    public constrcutCriteria(): EvenementStateCriteria {
        return new EvenementStateCriteria();
    }


}
