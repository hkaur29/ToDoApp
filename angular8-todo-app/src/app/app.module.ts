import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'; 
import { HashLocationStrategy, LocationStrategy } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import {AuthInterceptorService} from './login/auth-interceptor.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatListModule } from '@angular/material/list';
import  {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import { TaskListComponent } from './task-list/task-list.component';

import {TodoService} from './service/todo.service';
import { TaskDetailsComponent } from './task-details/task-details/task-details.component';
import { LogoutComponent } from './logout/logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TaskListComponent,
    TaskDetailsComponent,
    LogoutComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatListModule,
    MatCardModule,
    MatInputModule
  ],
  providers: [TodoService,{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true },
						  {provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent]
})
export class AppModule { }
