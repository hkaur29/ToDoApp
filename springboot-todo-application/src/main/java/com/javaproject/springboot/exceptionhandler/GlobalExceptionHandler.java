package com.javaproject.springboot.exceptionhandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	 	@Value(value = "${data.exception.message1}")
	    private String message1;
	    @Value(value = "${data.exception.message2}")
	    private String message2;
	    @Value(value = "${data.exception.message3}")
	    private String message3;
	    @Value(value = "${data.exception.message4}")
	    private String message4;
	    
	    @ExceptionHandler(value = TaskNotFoundException.class)
	    public ResponseEntity<String> taskNotFoundException(TaskNotFoundException taskNotFoundException) {
	        return new ResponseEntity<String>(message2, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(value = TaskAlreadyExistsException.class)
	    public ResponseEntity<String> taskAlreadyExistsException(TaskAlreadyExistsException taskAlreadyExistsException) {
	        return new ResponseEntity<String>(message2, HttpStatus.CONFLICT);
	    }
	    
	   @ExceptionHandler(value = Exception.class)
	    public ResponseEntity<String> databaseConnectionFailsException(Exception exception) {
	        return new ResponseEntity<String>(message3, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	   
	   @ExceptionHandler(value = UsernameNotFoundException.class)
	   public ResponseEntity<String> usernotFoundException(UsernameNotFoundException usernameNotFoundException){
		   return new ResponseEntity<String>(message4, HttpStatus.NOT_FOUND);
	   }
}
