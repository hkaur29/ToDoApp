import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

export class User {
  constructor(public status: string) {}
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isSignUpFailed = false;
  errorMessage = '';
  constructor(private httpClient: HttpClient) {}
  // giving username and password for authentication to the api,once authentication gets successful, 
  //we can store the JWT token in session to be passed on in each consequent request.
    authenticate(username, password) {
      return this.httpClient
        .post<any>("http://localhost:8080/springboot-todo-application/authenticate", { username, password })
        .pipe(
          map(userData => {
            sessionStorage.setItem("username", username);
            let tokenStr = "Bearer " + userData.token;
            sessionStorage.setItem("token", tokenStr);
            return userData;
          },
          err => {
            this.errorMessage = err.error.message;
            this.isSignUpFailed = true;
          }
          )
        );
    }
  
    isUserLoggedIn() {
      let user = sessionStorage.getItem("username");
      console.log(!(user === null));
      return !(user === null);
    }
  
    logOut() {
      sessionStorage.removeItem("username");
    }

}
