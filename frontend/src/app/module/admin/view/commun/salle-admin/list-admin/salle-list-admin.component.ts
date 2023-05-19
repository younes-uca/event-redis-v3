import {Component, OnInit} from '@angular/core';
import {SalleService} from 'src/app/controller/service/Salle.service';
import {SalleDto} from 'src/app/controller/model/Salle.model';
import {SalleCriteria} from 'src/app/controller/criteria/SalleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { BlocOperatoirService } from 'src/app/controller/service/BlocOperatoir.service';

import {BlocOperatoirDto} from 'src/app/controller/model/BlocOperatoir.model';


@Component({
  selector: 'app-salle-list-admin',
  templateUrl: './salle-list-admin.component.html'
})
export class SalleListAdminComponent extends AbstractListController<SalleDto, SalleCriteria, SalleService>  implements OnInit {

    fileName = 'Salle';

    blocOperatoirs :Array<BlocOperatoirDto>;
  
    constructor(salleService: SalleService, private blocOperatoirService: BlocOperatoirService) {
        super(salleService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadBlocOperatoir();
    }

    public async loadSalles(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Salle', 'list');
        isPermistted ? this.service.findAll().subscribe(salles => this.items = salles,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'code', header: 'Code'},
            {field: 'blocOperatoir?.reference', header: 'Bloc operatoir'},
        ];
    }


    public async loadBlocOperatoir(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Salle', 'list');
        isPermistted ? this.blocOperatoirService.findAllOptimized().subscribe(blocOperatoirs => this.blocOperatoirs = blocOperatoirs,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: SalleDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Code': e.code ,
                'Bloc operatoir': e.blocOperatoir?.reference ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        //'Bloc operatoir': this.criteria.blocOperatoir?.reference ? this.criteria.blocOperatoir?.reference : environment.emptyForExport ,
        }];
      }
}
