import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, timer } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CouchdbService {
  private baseUrl = 'http://127.0.0.1:5984';
  private database = 'events';
  private interval = 30000;

  constructor(private http: HttpClient) { }

  public startFetchingData(): Observable<any> {
    return timer(0, this.interval).pipe(
        switchMap(() => this.fetchData())
    );
  }

  private fetchData(): Observable<any> {
    const url = `${this.baseUrl}/${this.database}/_all_docs`;
    return this.http.get(url);
  }
}
