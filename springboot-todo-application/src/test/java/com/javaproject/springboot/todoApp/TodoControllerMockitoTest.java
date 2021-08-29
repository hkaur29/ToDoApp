package com.javaproject.springboot.todoApp;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.assertj.core.api.Assertions.assertThat;

import com.javaproject.springboot.controller.TodoListController;
import com.javaproject.springboot.domain.Task;
import com.javaproject.springboot.service.TaskService;

@ExtendWith(MockitoExtension.class)
public class TodoControllerMockitoTest {

	@Mock
	private TaskService taskService;

	@InjectMocks
	private TodoListController todoListController;

	@BeforeEach
	void setMockOutput() {
		Task task = new Task();
		task.setTaskId("task01");
		task.setTaskName("Assignment");
		task.setTaskDescription("Complete Assignment by Thursday");
		when(taskService.getTaskById("task01")).thenReturn(task);
	}

	@Test
	public void testTaskById() {
		Task response = todoListController.getAllTasks("task01");
		assertThat(response.getTaskName()).isEqualTo("Assignment");
	}

}
