package com.nunam.exception;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A model class to represent error details in a standardized format.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {
	
	/**
     * The timestamp when the error occurred.
     */
	private LocalDateTime timeStamp;
	
	/**
     * The error message providing information about the error.
     */
	private String message;
	
	/**
     * Additional details describing the error.
     */
	private String details;
	
}
