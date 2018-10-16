import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Order } from '../order';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AddToCartServiceService {

  constructor(private http: HttpClient) { }
  private _addToCart:string="http://localhost:3000/order";
  addToCart(product:Order){
    debugger
    return this.http.post<any>(this._addToCart, product, httpOptions);
  }
}
