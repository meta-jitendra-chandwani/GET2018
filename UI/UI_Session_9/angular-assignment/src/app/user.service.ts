import { Injectable } from '@angular/core';
import { User } from "./user";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private _url: string = "http://localhost:3000/user";

  getItems(): Observable<User[]> {
    return this.http.get<User[]>(this._url);
  }
  items: any;

  // getData() {
  //   const _urlWithId: string = this._url + "/" + id;
  //   this.http.get(_urlWithId)
  //     .map(res => res.json()).subscribe(data => {
  //       this.items = data;
  //       console.log(this.items);
  //       for (var i = 0; i < this.items.list.length; i++) {
  //         this.min = this.items.list[i].main;
  //         console.log(this.min);
  //       }
  //     });
  // }

  // getItemsThroughId(id: number): Observable<User> {
  //   debugger
  //   const _urlWithId: string = this._url + "/" + id;
  //   return this.http.get<User>(_urlWithId);
  // }

  addUser(user: User): Observable<User> {
    debugger
    return this.http.post<User>(this._url, user, httpOptions);
  }
  /** PUT: update the movie on the server */
  updateUser(user: User): Observable<any> {
    debugger;
    return this.http.put(`${this._url}/${user.id}`, user, httpOptions);
  }
}