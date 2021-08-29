package com.javaproject.springboot.exceptionhandler;

public class TaskAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6216284246090325413L;
	private String message;
	
	public TaskAlreadyExistsException(String message){
		super(message);
		this.message = message;
	}
}
