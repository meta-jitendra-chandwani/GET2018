import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fruits } from "../fruits";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Category } from '../Category';
@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  constructor(private http: HttpClient) { }

  private _url: string = "http://localhost:3000/Fruits";

  getItems(): Observable<Fruits[]> {
    debugger
    return this.http.get<Fruits[]>(this._url);
  }

  // addUser(user: Fruits): Observable<Fruits> {
  //   debugger
  //   return this.http.post<Fruits>(this._url, user, httpOptions);
  // }

  // updateUser(user: Fruits): Observable<any> {
  //   debugger;
  //   return this.http.put(`${this._url}/${user.id}`, user, httpOptions);
  // }
}
