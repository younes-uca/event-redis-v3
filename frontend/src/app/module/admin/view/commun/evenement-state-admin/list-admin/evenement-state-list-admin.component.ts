import {Component, OnInit} from '@angular/core';
import {EvenementStateService} from 'src/app/controller/service/EvenementState.service';
import {EvenementStateDto} from 'src/app/controller/model/EvenementState.model';
import {EvenementStateCriteria} from 'src/app/controller/criteria/EvenementStateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-evenement-state-list-admin',
  templateUrl: './evenement-state-list-admin.component.html'
})
export class EvenementStateListAdminComponent extends AbstractListController<EvenementStateDto, EvenementStateCriteria, EvenementStateService>  implements OnInit {

    fileName = 'EvenementState';

  
    constructor(evenementStateService: EvenementStateService) {
        super(evenementStateService);
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEvenementStates(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EvenementState', 'list');
        isPermistted ? this.service.findAll().subscribe(evenementStates => this.items = evenementStates,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: EvenementStateDto) {
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
