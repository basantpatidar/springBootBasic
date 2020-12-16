package com.spring.boot.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7462673422498220764L;

	public UserExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
