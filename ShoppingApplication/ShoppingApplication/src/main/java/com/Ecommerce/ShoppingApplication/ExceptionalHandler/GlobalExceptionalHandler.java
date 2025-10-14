package com.Ecommerce.ShoppingApplication.ExceptionalHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Ecommerce.ShoppingApplication.Dto.ErrorResponse;



@RestControllerAdvice
public class GlobalExceptionalHandler extends Exception{
	
	
	 @ExceptionHandler(ExistingCartFound.class)
	    public ResponseEntity<ErrorResponse> ExistingCartFound(ExistingCartFound ex) {
		 ErrorResponse error =new ErrorResponse(ex.getMessage(),HttpStatus.ALREADY_REPORTED.value());
	        return new ResponseEntity<>(error, HttpStatus.ALREADY_REPORTED);
	 }
	 @ExceptionHandler(CartNotFoundException.class)
	    public ResponseEntity<ErrorResponse> CartNotFoundException(CartNotFoundException ex) {
		 ErrorResponse error =new ErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleOtherExceptions(Exception ex) {
		 ErrorResponse error =new ErrorResponse(ex.getMessage(),500);
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    
	 }
}
