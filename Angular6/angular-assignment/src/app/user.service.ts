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

  private _url: string = "http://localhost:3000/user";

  constructor(private http: HttpClient) { }

  getUser(): Observable<User[]> {
    return this.http.get<User[]>(this._url);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this._url}/${id}`);
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