package com.javaproject.springboot.exceptionhandler;

public class TaskNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5922293713685111180L;
	
	private String message;
	
	public TaskNotFoundException() {}
	
	public TaskNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
