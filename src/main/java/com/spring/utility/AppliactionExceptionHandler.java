package com.spring.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppliactionExceptionHandler extends ResponseEntityExceptionHandler{
//	A class with an @ExceptionHandler method that handles all Spring MVC raised exceptions by returning a ResponseEntity with RFC 7807 formatted error details in the body.


	
	private ErrorStructure<Object> errorStructure;	
	
	public AppliactionExceptionHandler(ErrorStructure<Object> errorStructure) {
		super();
		this.errorStructure = errorStructure;
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<ObjectError> errors = ex.getAllErrors();
//		List<String> messages=new ArrayList<>();
		Map<String, String> messages=new HashMap<>();
		
		errors.forEach(error->{
			//FieldError is the child of ObejctError
//			FieldError fieldError=(FieldError)error;
//			String message=error.getDefaultMessage();
			
			//messages.put(fieldError.getField(), error.getDefaultMessage());	
			
			messages.put(((FieldError)error).getField(),error.getDefaultMessage());//in 1 line
		});
		return ResponseEntity.badRequest().body(
				errorStructure.setStatusCode(HttpStatus.BAD_REQUEST.value())
				.setMessage("Invalid Input")
				.setData(messages)
				);
	}
	
	

}
