import { Injectable } from '@angular/core';
import { openDB, DBSchema, IDBPDatabase, IDBPTransaction } from 'idb';
import { Observable, timer } from 'rxjs';
import { switchMap } from 'rxjs/operators';

interface MyDatabase extends DBSchema {
  events: {
    value: {
      id: number;
      name: string;
      // Add other properties as needed
    };
    key: number;
  };
}

@Injectable({
  providedIn: 'root'
})
export class IndexeddbService {
  private databaseName = 'my-database';
  private objectStoreName = 'events';
  private db: IDBPDatabase<MyDatabase>;
  private interval = 30000;

  constructor() {
    this.openDatabase();
  }

  private async openDatabase(): Promise<void> {
    const objectStoreName = this.objectStoreName; // Capture the reference to 'this.objectStoreName'

    this.db = await openDB<MyDatabase>(this.databaseName, 1, {
      upgrade(db) {
        if (!db.objectStoreNames.contains(this.objectStoreName)) { // Use the captured 'objectStoreName'
          db.createObjectStore(this.objectStoreName, { keyPath: 'id' });
        }
      },
    });
  }


  public startFetchingData(): Observable<any[]> {
    return timer(0, this.interval).pipe(
        switchMap(() => this.fetchObjectsFromIndexedDB())
    );
  }

  private async fetchObjectsFromIndexedDB(): Promise<any[]> {
    const transaction = this.db.transaction(["events"], "readonly") as IDBPTransaction<MyDatabase, ["events"], "readonly">;
    const objectStore = transaction.objectStore("events");
    const data = await objectStore.getAll();
    return data;
  }

}
