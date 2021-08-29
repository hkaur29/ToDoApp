package com.javaproject.springboot.service;

import java.util.List;

import com.javaproject.springboot.domain.Task;
import com.javaproject.springboot.exceptionhandler.TaskAlreadyExistsException;
import com.javaproject.springboot.exceptionhandler.TaskNotFoundException;

public interface TaskService {

	List<Task> getAllTasks() throws TaskNotFoundException;

	void addTask(Task task) throws TaskAlreadyExistsException;

	void updateTask(Task task) throws TaskNotFoundException;

	void deleteTask(String id) throws TaskNotFoundException;

	Task getTaskById(String id) throws TaskNotFoundException;
}
