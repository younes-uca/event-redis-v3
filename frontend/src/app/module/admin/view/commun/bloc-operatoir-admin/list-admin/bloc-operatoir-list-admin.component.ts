import {Component, OnInit} from '@angular/core';
import {BlocOperatoirService} from 'src/app/controller/service/BlocOperatoir.service';
import {BlocOperatoirDto} from 'src/app/controller/model/BlocOperatoir.model';
import {BlocOperatoirCriteria} from 'src/app/controller/criteria/BlocOperatoirCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-bloc-operatoir-list-admin',
  templateUrl: './bloc-operatoir-list-admin.component.html'
})
export class BlocOperatoirListAdminComponent extends AbstractListController<BlocOperatoirDto, BlocOperatoirCriteria, BlocOperatoirService>  implements OnInit {

    fileName = 'BlocOperatoir';

  
    constructor(blocOperatoirService: BlocOperatoirService) {
        super(blocOperatoirService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadBlocOperatoirs(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('BlocOperatoir', 'list');
        isPermistted ? this.service.findAll().subscribe(blocOperatoirs => this.items = blocOperatoirs,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: BlocOperatoirDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}
