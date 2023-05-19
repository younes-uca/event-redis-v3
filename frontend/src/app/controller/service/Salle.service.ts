import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {SalleDto} from '../model/Salle.model';
import {SalleCriteria} from '../criteria/SalleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {BlocOperatoirDto} from '../model/BlocOperatoir.model';

@Injectable({
  providedIn: 'root'
})
export class SalleService extends AbstractService<SalleDto, SalleCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/salle/');
    }

    public constrcutDto(): SalleDto {
        return new SalleDto();
    }

    public constrcutCriteria(): SalleCriteria {
        return new SalleCriteria();
    }
}
