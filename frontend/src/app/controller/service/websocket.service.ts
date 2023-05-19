import { Injectable } from '@angular/core';
import { Socket } from 'ngx-socket-io';
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  /*constructor(private socket: Socket) { }

  connect(salleId: number): Observable<any> {
    const url = `ws://localhost:8036/api/admin/evenement/salle/${salleId}`;
    this.socket = new Socket({ url: url });

    this.socket.connect();
    return this.socket.fromEvent('evenements');
  }

  disconnect() {
    this.socket.disconnect();
  }

  onEvent(event: string) {
    return this.socket.fromEvent(event);
  }*/
  private socket: WebSocket;
  private subject: Subject<any>;

  constructor() { }

  public connect(url: string): Subject<any> {
    if (!this.subject) {
      this.subject = this.create(url);
    }
    return this.subject;
  }

  private create(url: string): Subject<any> {
    this.socket = new WebSocket(url);

    const subject = new Subject<any>();

    this.socket.onopen = event => {
      console.log('WebSocket connected');
    };

    this.socket.onmessage = event => {
      subject.next(event.data);
    };

    this.socket.onclose = event => {
      console.log('WebSocket disconnected');
      this.subject = null;
    };

    return subject;
  }

  public send(data: any): void {
    this.socket.send(JSON.stringify(data));
  }

  onMessage() {

  }
}
