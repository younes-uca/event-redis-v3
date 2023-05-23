import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {RoleService} from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {EvenementDto} from '../model/Evenement.model';
import {EvenementCriteria} from '../criteria/EvenementCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';
import {Observable} from "rxjs";
import {BlocOperatoirInformationDto} from "../model/BlocOperatoirInformation.model";

@Injectable({
  providedIn: 'root'
})
export class EvenementService extends AbstractService<EvenementDto, EvenementCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/evenement/');
    }

    public findBySalleBlockOperatoirReference(reference: string, lastUpdate: string): Observable<BlocOperatoirInformationDto>{
        return this.http.get<BlocOperatoirInformationDto>(this.API + 'bloc-operatoir/reference/' + reference+'/lastUpdate/' +lastUpdate)
    }

    public constrcutDto(): EvenementDto {
        return new EvenementDto();
    }

    public constrcutCriteria(): EvenementCriteria {
        return new EvenementCriteria();
    }
}
