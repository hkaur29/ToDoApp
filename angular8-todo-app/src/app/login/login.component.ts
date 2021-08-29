import { Component, OnInit } from '@angular/core';
import {AuthService} from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string ;
  password : string;
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;
  constructor(private router: Router,
    private loginservice : AuthService) { }

  ngOnInit(): void {
  }

  handleLogin() {
    (this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['home'])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true
        this.errorMessage = 'User does not exist. Please enter correct Username and Password';

      }
    )
    );

  }
}
