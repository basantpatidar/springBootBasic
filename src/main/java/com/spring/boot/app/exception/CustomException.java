package com.spring.boot.app.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler{

		@ExceptionHandler(value= {UserNotFoundException.class, SQLException.class})
		public ResponseEntity<String> HandleUserNotFoundException(UserNotFoundException unf) {
			System.out.println("UserNotFoundException");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(unf.getMessage());
		}
}
