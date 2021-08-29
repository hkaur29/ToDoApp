import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  baseUrl: string = "http://localhost:8080/springboot-todo-application";

  constructor(private http: HttpClient) { }

  public addTask(task) : Observable<any>{
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(task);
    console.log(body)
    return this.http.post(this.baseUrl+ '/createtask',body,{'headers':headers,responseType: 'text'});
  }

  public getAllTasks() : Observable<any>{
    const headers = { 'content-type': 'application/json'}  
    return this.http.get(this.baseUrl+'/tasks',{'headers':headers});
  }

  /** GET task by id. Will 404 if id not found */
  getTask(id: string): Observable<any> {
    const url = `${this.baseUrl}/tasks/${id}`;
    return this.http.get(url);
  }

   /** PUT: update the task on the server */
   updateTask(task): Observable<any> {
    return this.http.put(this.baseUrl+'/updateTasks', task);
    
  }

  /** PUT: update the TASK status on the server */
  updateTaskStatus(task): Observable<any> {
    console.log(task.taskStatus)
    return this.http.patch(this.baseUrl+'/updateTaskStatus',task);

  }

  /** DELETE: delete the TASK from the server */
  public deleteTask(id: number): Observable<any> {
    const url = `${this.baseUrl}/tasks/${id}`;
    console.log(url);
    return this.http.delete(url);
  }
  
}
