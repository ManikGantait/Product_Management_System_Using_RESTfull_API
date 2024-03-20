package com.spring.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.exception.ProductIdNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>>  productIdNotFoundException(ProductIdNotFoundException exception)
	{
		ErrorStructure<String> errorStructure=new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage(exception.getMessage());
		errorStructure.setData("Product with the given id is not exist in database");
		return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
		
	}

}
