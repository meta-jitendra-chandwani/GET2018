import { Injectable } from '@angular/core';
import { User } from "./user";
import { Observable } from 'rxjs';
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

  addUser(user: User): Observable<User> {
    debugger
    return this.http.post<User>(this._url, user, httpOptions);
  }

  updateUser(user: User): Observable<any> {
    debugger;
    return this.http.put(`${this._url}/${user.id}`, user, httpOptions);
  }
}