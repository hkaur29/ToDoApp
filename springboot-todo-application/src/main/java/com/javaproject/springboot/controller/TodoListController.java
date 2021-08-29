package com.javaproject.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.springboot.domain.Task;
import com.javaproject.springboot.service.TaskService;

/**
 * @author harsharan Kaur 
 * Main controller class to create, get , update and delete tasks
 */

@RestController
public class TodoListController {

	@Autowired
	TaskService taskService;

	@RequestMapping("/tasks")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	@RequestMapping("/tasks/{id}")
	public Task getAllTasks(@PathVariable String id) {
		return taskService.getTaskById(id);
	}

	@PostMapping("/createtask")
	public String addTask(@RequestBody Task task) {
		taskService.addTask(task);
		return "success";
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/updateTaskStatus")
	public void updateTaskDone(@RequestBody Task task) {
		Task taskToUpdate = taskService.getTaskById(task.getTaskId());
		taskToUpdate.setTaskStatus(task.isTaskStatus());
		taskService.updateTask(taskToUpdate);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateTasks")
	public void updateTask(@RequestBody Task task) {
		taskService.updateTask(task);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
	public void updateTask(@PathVariable String id) {
		taskService.deleteTask(id);
	}
}
