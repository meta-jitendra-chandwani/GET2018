import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Data } from "../fruits";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataServiceService {

  constructor(private http: HttpClient) { }

  private _urlAll: string = "http://localhost:3001/all";
  private _categoryFruits: string = "?category=fruits";
  private _categoryVegetables: string = "?category=vegetables";
  private _categoryBread: string = "?category=bread";
  private _categoryDairy: string = "?category=dairy";


  getDairyItems(): Observable<Data[]> {
    return this.http.get<Data[]>(`${this._urlAll}/${this._categoryDairy}`);
  }

  getFruitsItems(): Observable<Data[]> {
    return this.http.get<Data[]>(`${this._urlAll}/${this._categoryFruits}`);
  }

  getAllItems(): Observable<Data[]> {
    return this.http.get<Data[]>(this._urlAll);
  }
  getVegetablesItems(): Observable<Data[]> {
    return this.http.get<Data[]>(`${this._urlAll}/${this._categoryVegetables}`);

  }
  getBreadsItems(): Observable<Data[]> {
    return this.http.get<Data[]>(`${this._urlAll}/${this._categoryBread}`);
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
