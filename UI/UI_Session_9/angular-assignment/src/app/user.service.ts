import { Injectable } from '@angular/core';
import { User } from "./user";
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private _url: string = "/assets/data.json";

  // private handleError(errorResponse: HttpErrorResponse) {
  //   if (errorResponse.error instanceof ErrorEvent) {
  //     console.log("Client Side Error:", errorResponse.error.message);
  //   } else {
  //     console.log("Server Side Error:", errorResponse.error.message);
  //   }
  //   return new ErrorObservable("This is a problem with service");
  // }
  
  getItems(): Observable<User[]> {
    return this.http.get<User[]>(this._url);
  }
  addUser(user: User): Observable<User> {
    if (user.id === null) {
      return this.http.post<User>(this._url, user, {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      });

    }
  }


  // // Update a comment
  // updateUser(body: Object): Observable<Comment[]> {
  //   let bodyString = JSON.stringify(body); // Stringify payload
  //   let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
  //   let options = new RequestOptions({ headers: headers }); // Create a request option

  //   return this.http.put(`${this.url}/${body['name']}`, body, options) // ...using put request
  //     .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
  //     .catch((error: any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  // }

  // addUser(body: Object): Observable<Comment[]> {
  //   let bodyString = JSON.stringify(body); // Stringify payload
  //   let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
  //   let options = new RequestOptions({ headers: headers }); // Create a request option

  //   return this.http.post(this.url, body, options) // ...using post request
  //     .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
  //     .catch((error: any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  // }

  // // Update a comment
  // updateUser(body: Object): Observable<Comment[]> {
  //   let bodyString = JSON.stringify(body); // Stringify payload
  //   let headers = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
  //   let options = new RequestOptions({ headers: headers }); // Create a request option

  //   return this.http.put(`${this.url}/${body['name']}`, body, options) // ...using put request
  //     .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
  //     .catch((error: any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  // }

  // removeComment(name: string): Observable<Comment[]> {
  //   return this.http.delete(`${this.url}/${name}`) // ...using put request
  //     .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
  //     .catch((error: any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  // }
}
