import {Component, OnInit} from '@angular/core';
import {EvenementService} from 'src/app/controller/service/Evenement.service';
import {EvenementDto} from 'src/app/controller/model/Evenement.model';
import {EvenementCriteria} from 'src/app/controller/criteria/EvenementCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import {environment} from 'src/environments/environment';

import {SalleService} from 'src/app/controller/service/Salle.service';
import {EvenementStateService} from 'src/app/controller/service/EvenementState.service';

import {EvenementStateDto} from 'src/app/controller/model/EvenementState.model';
import {SalleDto} from 'src/app/controller/model/Salle.model';
import {WebsocketService} from "../../../../../../controller/service/websocket.service";
import {BlocOperatoirDto} from "../../../../../../controller/model/BlocOperatoir.model";
import {BlocOperatoirService} from "../../../../../../controller/service/BlocOperatoir.service";
import {WebSocketService} from "../../../../../../controller/service/web-socket.service";
import {Socket} from "ngx-socket-io";


@Component({
    selector: 'app-evenement-list-admin',
    templateUrl: './evenement-list-admin.component.html'
})
export class EvenementListAdminComponent extends AbstractListController<EvenementDto, EvenementCriteria, EvenementService> implements OnInit {

    fileName = 'Evenement';
    evenements: any[] = [];
    salles: Array<SalleDto>;
    evenementStates: Array<EvenementStateDto>;
    blocOperatoires: Array<BlocOperatoirDto>;
    selectedBloc: BlocOperatoirDto;
    bloc: any;

    constructor(evenementService: EvenementService, private blocOperatoirService: BlocOperatoirService, private webSocketService: WebsocketService, private salleService: SalleService, private evenementStateService: EvenementStateService
        , private webSocketS: WebSocketService) {
        super(evenementService);

    }

    socket: Socket;

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadSalle();
        this.loadEvenementState();
        this.loadBlocOperatoire();
        setInterval(() => {
            this.openWebS();
        }, 20000);
    }

    public async loadEvenements() {
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Evenement', 'list');
        isPermistted ? this.service.findAll().subscribe(evenements => this.items = evenements, error => console.log(error))
            : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }

    public async loadBlocOperatoire() {
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Evenement', 'list');
        isPermistted ? this.blocOperatoirService.findAllOptimized().subscribe(blocOperatoires => this.blocOperatoires = blocOperatoires, error => console.log(error))
            : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'evenementStart', header: 'Evenement start'},
            {field: 'evenementEnd', header: 'Evenement end'},
            {field: 'salle?.reference', header: 'Salle'},
            {field: 'evenementState?.reference', header: 'Evenement state'},
        ];
    }


    public async loadSalle() {
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Evenement', 'list');
        isPermistted ? this.salleService.findAllOptimized().subscribe(salles => this.salles = salles, error => console.log(error))
            : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

    public async loadEvenementState() {
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Evenement', 'list');
        isPermistted ? this.evenementStateService.findAllOptimized().subscribe(evenementStates => this.evenementStates = evenementStates, error => console.log(error))
            : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

    public initDuplicate(res: EvenementDto) {
    }

    public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Reference': e.reference,
                'Evenement start': this.datePipe.transform(e.evenementStart, 'dd/MM/yyyy hh:mm'),
                'Evenement end': this.datePipe.transform(e.evenementEnd, 'dd/MM/yyyy hh:mm'),
                'Salle': e.salle?.reference,
                'Description': e.description,
                'Evenement state': e.evenementState?.reference,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport,
            'Evenement start Min': this.criteria.evenementStartFrom ? this.datePipe.transform(this.criteria.evenementStartFrom, this.dateFormat) : environment.emptyForExport,
            'Evenement start Max': this.criteria.evenementStartTo ? this.datePipe.transform(this.criteria.evenementStartTo, this.dateFormat) : environment.emptyForExport,
            'Evenement end Min': this.criteria.evenementEndFrom ? this.datePipe.transform(this.criteria.evenementEndFrom, this.dateFormat) : environment.emptyForExport,
            'Evenement end Max': this.criteria.evenementEndTo ? this.datePipe.transform(this.criteria.evenementEndTo, this.dateFormat) : environment.emptyForExport,
            //'Salle': this.criteria.salle?.reference ? this.criteria.salle?.reference : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport,
            //'Evenement state': this.criteria.evenementState?.reference ? this.criteria.evenementState?.reference : environment.emptyForExport ,
        }];
    }

    private subscribeToEventStream(referenceBloc: string) {
        const eventSource = new EventSource(`http://localhost:8036/api/admin/evenement/redis/event/stream/${referenceBloc}`);

        eventSource.addEventListener('open', function () {
            console.log('Connection opened.');
        });

        eventSource.addEventListener('message', (event: MessageEvent) => {
            const eventObject = JSON.parse(event.data);
            console.log(eventObject);
            this.evenements.push(eventObject);
            this.items = [...this.evenements];

        });


    }


    public onBlocSelected() {
        // this.subscribeToEventStream(this.selectedBloc.reference);
    }

    getSelectedBloc(): string {
        return this.selectedBloc.reference
    }


    public openWebS(): void {
        /*await this.webSocketS.openWebSocket(this.selectedBloc.reference);
        console.log(this.selectedBloc.reference);
        await this.webSocketS.earchObjectsByReference(this.selectedBloc.reference);
        console.log('awaiting before getting the events');
        this.items = await this.webSocketS.getEvents() ;
        console.log(this.items)// Add 'await' keyword
        console.log("finn open "+this.selectedBloc.reference)*/
        if (this.selectedBloc != null && this.selectedBloc.reference != null) {
            console.log('about to featch data for block ' + this.selectedBloc.reference);
            let lastUpdate = localStorage.getItem(this.selectedBloc.reference);
            this.service.findBySalleBlockOperatoirReference(this.selectedBloc.reference, lastUpdate).subscribe(data => {
                if (data != null) {
                    localStorage.setItem(this.selectedBloc.reference, data.lastUpdate);
                    this.items = data.evenementRediss;
                    console.log('featched data for block ' + data);
                } else {
                    console.log('No change have been performed');
                }

            });
        }

    }


}
