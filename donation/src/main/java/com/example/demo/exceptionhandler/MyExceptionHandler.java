package com.example.demo.exceptionhandler;

import java.time.LocalDateTime;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ErrorHandler  handleAllExceptions(Exception ex,WebRequest req) {
		
		return new ErrorHandler(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));
	}

}
