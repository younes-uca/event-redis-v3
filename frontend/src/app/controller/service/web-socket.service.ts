import {Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';


import {Socket} from 'socket.io-client';
import {Observable} from 'rxjs';
import {User} from "../../zynerator/security/User.model";
import {AuthService} from "../../zynerator/security/Auth.service";
import {EvenementDto} from "../model/Evenement.model";
import {AbstractListController} from "../../zynerator/controller/AbstractListController";
import {EvenementCriteria} from "../criteria/EvenementCriteria.model";
import {EvenementService} from "./Evenement.service";
import {
    EvenementListAdminComponent
} from "../../module/admin/view/event/evenement-admin/list-admin/evenement-list-admin.component";
// CommonJS
// @ts-ignore
const io = require('socket.io-client');


@Injectable({
    providedIn: 'root'
})
export class WebSocketService {
    socket: Socket;
    keyOfSession: string;

    private _studentsEnLigne: Map<number, User> = new Map<number, User>();
    private baseUrl = environment.baseUrl;
    private synchronizationUrl = 'synchronization';
    index = 0;

    private _connectedUsers: any[] = [];
    actionType: Array<string> = new Array<string>();

    idprof: number;
    public isInSession = false;
    public sessionHasStarted = false;
    private _tabViewActiveIndex = 0;
    private numerOft12Qst = -1;
    private _activeIndexForTabView: number;
    private _lessonStarted: boolean;
    private _minute = 59;
    private _seconde = 59;

    constructor(private authService:AuthService,
                private http: HttpClient,
                private event:EvenementListAdminComponent

    ) {
    }




    get minute(): number {
        return this._minute;
    }

    set minute(value: number) {
        this._minute = value;
    }

    get seconde(): number {
        return this._seconde;
    }

    set seconde(value: number) {
        this._seconde = value;
    }

    get lessonStarted(): boolean {
        return this._lessonStarted;
    }

    set lessonStarted(value: boolean) {
        this._lessonStarted = value;
    }

    get activeIndexForTabView(): number {
        return this._activeIndexForTabView;
    }

    set activeIndexForTabView(value: number) {
        this._activeIndexForTabView = value;
    }



    get tabViewActiveIndex(): number {
        return this._tabViewActiveIndex;
    }

    set tabViewActiveIndex(value: number) {
        this._tabViewActiveIndex = value;
    }



    get studentsEnLigne(): Map<number, User> {
        return this._studentsEnLigne;
    }

    set studentsEnLigne(value: Map<number, User>) {
        this._studentsEnLigne = value;
    }





    public openWebSocket(key:string) {
        this.openSession(key);
        this.onConnect();
        this.onConnection();
        this.onDisconnect();
        this.onConnectError();
        this.onMessage();
    }


    private onMessage() {
        this.socket.on('message', (event) => {console.log("onMessage")
        });
    }


    openSession(key:string) {
        // const id = this.authService.authenticatedUser.id;
        // console.log(id)
        // const myToken = localStorage.getItem('token');
        console.log('----------------------------------OPEN SESSION ----------------------------------------');
        console.log(this.socket?.connected);
        console.log('-----------------------------------------------------------------------------------------');
        this.socket = io(environment.socketUrl+ '?key=' + key , {
            autoConnect: true,
            transports: ['websocket'],
            pingInterval: 25000, // send a ping message every 25 seconds
            pingTimeout: 60000, // consider the connection lost if no message received after 60 seconds
            // auth: (cb) => {
            //     cb({token: myToken});
            // }
        });
    }
    getEvents(): Promise<EvenementDto[]> {
        console.log("geteventsmeth");
        return new Promise<EvenementDto[]>((resolve, reject) => {
            this.socket.on('matched_objects', (matchedObjects: EvenementDto[]) => {
                console.log('Received list of objects:', matchedObjects);
                resolve(matchedObjects);
                if (matchedObjects != null && !Array.isArray(matchedObjects) ) {
                    this.event.items.push(matchedObjects);

                }
            });
        });
    }


    earchObjectsByReference(reference: string){
            this.socket.emit('search_objects', reference);
        }


    private onDisconnect() {
        this.socket.on('disconnect', (reason, description) => {
            console.log(reason);
        });
    }

    private onConnectError() {
        this.socket.on('connect_error', (error) => {
            console.log(this.socket.connected);
            console.log(error);
        });
    }

    private onConnect() {
        this.socket.on('connect', () => {
            console.log("onConnect")
        });
    }

    private onConnection() {
        this.socket.on('connection', (socket) => {
            console.log(socket);

        });
    }

    public disconnect() {
        this.socket.disconnect();
    }
}
