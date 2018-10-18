import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Data } from "../fruits";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../order';
import { map } from 'rxjs/operators';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
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
  private _cartUrl: string = "http://localhost:3000/order"

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

  saveCartItem(cartItemArray: Order[]) {
    debugger
    return this.http.post<Order[]>(this._cartUrl, cartItemArray, httpOptions)
  }

  getCartItem(): Observable<Order[]> {
    debugger
    return this.http.get<Order[]>(this._cartUrl)
      .pipe(map(response => response));
  }
  deleteCartItem(): Observable<Order[]> {
    debugger
    return this.http.delete<Order[]>(`${this._cartUrl}/1`);
  }

}
