package com.icw.user.service.UserService.Exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
	{
	     ErrorDetail er=new ErrorDetail(LocalDate.now(), ex.getMessage(), request.getDescription(false));
	     
		return new ResponseEntity(er,HttpStatus.INTERNAL_SERVER_ERROR);	
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> usserNotFoundException(Exception ex, WebRequest request)
	{
	     ErrorDetail er=new ErrorDetail(LocalDate.now(), ex.getMessage(), request.getDescription(false));
	     
		return new ResponseEntity(er,HttpStatus.BAD_REQUEST);	
	}

}
