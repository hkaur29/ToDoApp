package com.javaproject.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.relation.InvalidRelationIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.springboot.domain.Task;
import com.javaproject.springboot.exceptionhandler.TaskAlreadyExistsException;
import com.javaproject.springboot.exceptionhandler.TaskNotFoundException;
import com.javaproject.springboot.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<Task>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}

	@Override
	public Task getTaskById(String id) throws TaskNotFoundException {
		
		Optional<Task> task = taskRepository.findById(id);
		if(task.isPresent())
		return task.get();
		else
			throw new TaskNotFoundException();
	}
	
	@Override
	public void addTask(Task task) {
		if (taskRepository.existsById(task.getTaskId())) {
            throw new TaskAlreadyExistsException("This task is already present");
        }
		task.setLastModified(new Date().toString());
		taskRepository.save(task);
		
	}

	@Override
	public void updateTask(Task task) {
		if(null!=task) {
		task.setLastModified(new Date().toString());
		taskRepository.save(task);
		}
		
	}

	@Override
	public void deleteTask(String id) {
		taskRepository.deleteById(id);
		
	}

	

	
}
