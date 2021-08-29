import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Task } from 'src/app/task';

import { TodoService } from 'src/app/service/todo.service';
@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  public task : Task ;
  constructor(private route: ActivatedRoute,
              private service:TodoService,
              private location:Location) { }

  ngOnInit(): void {

    this.getTask();
  }

  getTask(): void{
    const id = this.route.snapshot.paramMap.get('id');
    this.service.getTask(id).subscribe(task => this.task = task);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.task) {
      this.service.updateTask(this.task)
        .subscribe(() => this.goBack());
    }
  }
}
