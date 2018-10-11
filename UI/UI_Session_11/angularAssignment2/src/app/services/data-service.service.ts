import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Data } from "../fruits";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  constructor(private http: HttpClient) { }

  private _url: string = "http://localhost:3000";
  private _urlAll: string = "http://localhost:3001/all";

  getFruitsItems(): Observable<Data[]> {
    return this.http.get<Data[]>(`${this._url}/Fruits`);
  }

  getAllItems(): Observable<Data[]> {
    return this.http.get<Data[]>(this._urlAll);
  }
  getVegetablesItems(): Observable<Data[]> {
    return this.http.get<Data[]>(`${this._url}/Vegetables`);

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
