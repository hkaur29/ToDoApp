import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskListComponent } from './task-list/task-list.component';
import { LoginComponent } from './login/login.component';
import { TaskDetailsComponent } from './task-details/task-details/task-details.component';
import { LogoutComponent } from './logout/logout/logout.component';

const routes: Routes = [
  {path: "login",component: LoginComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path: "home",component: TaskListComponent},
  {path: 'detail/:id', component: TaskDetailsComponent},
  {path: 'logout',component: LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
