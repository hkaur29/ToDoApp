package com.javaproject.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaproject.springboot.domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, String>{

	
}
