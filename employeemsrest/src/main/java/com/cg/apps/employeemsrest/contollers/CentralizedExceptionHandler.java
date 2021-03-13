package com.cg.apps.employeemsrest.contollers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.apps.employeemsrest.exceptions.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidDepartmentException.class)
	public String handle(InvalidDepartmentException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidEmployeeNameExcpetion.class)
	public String handle(InvalidEmployeeNameExcpetion e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public String handle(InvalidEmployeeIdException e) {
		return e.getMessage();
	}
	
	

}
