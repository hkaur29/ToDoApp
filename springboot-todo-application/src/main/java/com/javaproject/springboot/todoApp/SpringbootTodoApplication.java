package com.javaproject.springboot.todoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.javaproject.springboot")
@EntityScan("com.javaproject.springboot.domain")
@EnableJpaRepositories("com.javaproject.springboot.repository")
public class SpringbootTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTodoApplication.class, args);
	}

}
