package com.springbootlearning;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

	 @ExceptionHandler
	 public String handleInvalidField(InvalidFieldException exception)
	 { 
		 return exception.getErrorMessage(); 
		 }
}
