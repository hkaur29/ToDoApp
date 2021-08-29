import { Component, OnInit } from '@angular/core'; 
import { AuthService } from 'src/app/login/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService : AuthService,
              private router : Router) { }

  ngOnInit(): void {
    this.authService.logOut();
    this.router.navigate(['login'])
  }

}
