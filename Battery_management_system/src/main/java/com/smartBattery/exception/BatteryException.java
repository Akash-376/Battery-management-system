package com.smartBattery.exception;

/**
 * Custom exception class to represent exceptions related to battery operations.
 */
public class BatteryException extends RuntimeException{
	
	/**
     * Constructs a new `BatteryException` instance with no specified detail message.
     */
	public BatteryException() {}
	
	/**
     * Constructs a new `BatteryException` instance with the specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
	public BatteryException(String message) {
		super(message);
	}
	
}
