import { Component, OnInit } from '@angular/core';
import {TodoService} from '../service/todo.service';
import { Task } from '../task';


@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  public taskName: string;
  public taskDescription: string;
  public isTaskPresent: boolean;
  public tasks: any;
  public isTaskDone: boolean;
  
  constructor(private service:TodoService) { 
    this.tasks = [];
  }

  ngOnInit(): void {

    this.getAllTask();
  }

  getAllTask(): void{
    this.tasks = this.service.getAllTasks().subscribe(response =>{
      console.log(response);
      this.tasks= response;
      this.isTaskPresent = true;
    });
  }
  
  Submit(){
    console.log('workin' + this.taskName + this.taskDescription);
    let task = {
      "taskId" : "task" + new Date().getTime(),
      "taskName" : this.taskName,
      "taskDescription" : this.taskDescription,
      "istaskDone" : false
    }; 

    this.service.addTask(task).subscribe(response => {
          console.log(response);
          if(response == 'success'){
            this.taskName= '';
            this.taskDescription = '';
            this.isTaskDone = false;
            this.isTaskPresent = true;
            console.log(this.isTaskPresent);
            this.tasks.push(task);
          }
      },error => {
        console.log(error.message);
  
      }
      );

  }

  updateIsdone(task: Task){
    task.taskStatus = ! task.taskStatus;
    this.isTaskDone = task.taskStatus;
    console.log('updated the status to '+ task.taskStatus);
    this.service.updateTaskStatus(task).subscribe();
  }

  deleteTask(task): void {
    this.tasks = this.tasks.filter(t => t !== task);
    this.service.deleteTask(task.taskId).subscribe();
  }

}
