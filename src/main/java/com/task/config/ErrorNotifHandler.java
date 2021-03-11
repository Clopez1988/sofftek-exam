package com.task.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.task.exception.BussinesException;
import com.task.http.error.GeneralErrorRs;

@RestControllerAdvice
public class ErrorNotifHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({BussinesException.class})
	public ResponseEntity<GeneralErrorRs> bussinesError (BussinesException e){
		
		GeneralErrorRs error = new GeneralErrorRs();
		
		error.setMessage(e.getMessage());
		error.setStatus(e.getStatus());
		
		return new ResponseEntity<GeneralErrorRs>(error, HttpStatus.valueOf(error.getStatus()));
	}
	
}
