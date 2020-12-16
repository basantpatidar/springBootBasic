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
		
		
		@ExceptionHandler(UserExistException.class)
		public ResponseEntity<String> HandleUserExistException(UserExistException uef) {
			System.out.println("UserExistException");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(uef.getMessage());
		}
		
		@ExceptionHandler(value= {NullPointerException.class})
		public ResponseEntity<String> HandleUserExistException(NullPointerException npe) {
			System.out.println("NullPointerException");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(npe.getMessage());
		}
		
		@ExceptionHandler(value= {Exception.class})
		public ResponseEntity<String> HandleGenericException(Exception npe) {
			System.out.println("Exception");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(npe.getMessage());
}
		
}
