package com.nunam.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	/**
     * Handles the exception when a BatteryException is thrown.
     *
     * @param e     The BatteryException that was thrown
     * @param req   The WebRequest associated with the request
     * @return      ResponseEntity containing error details and HTTP status
     */
	@ExceptionHandler(BatteryException.class)
	public ResponseEntity<MyErrorDetails> batteryNotFound(BatteryException e, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}
	
	
	/**
     * Handles the exception when a BatteryDataException is thrown.
     *
     * @param e     The BatteryDataException that was thrown
     * @param req   The WebRequest associated with the request
     * @return      ResponseEntity containing error details and HTTP status
     */
	@ExceptionHandler(BatteryDataException.class)
	public ResponseEntity<MyErrorDetails> batteryDataNotFound(BatteryDataException e, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	/**
     * Handles the exception when any other exception is thrown.
     *
     * @param e     The Exception that was thrown
     * @param req   The WebRequest associated with the request
     * @return      ResponseEntity containing error details and HTTP status
     */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception e, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
