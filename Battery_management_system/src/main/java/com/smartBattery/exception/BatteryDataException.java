package com.smartBattery.exception;

/**
 * Custom exception class to represent exceptions related to battery data operations.
 */
public class BatteryDataException extends RuntimeException{
	
	/**
     * Constructs a new `BatteryDataException` instance with no specified detail message.
     */
	public BatteryDataException() {}
	
	/**
     * Constructs a new `BatteryDataException` instance with the specified detail message.
     *
     * @param message The detail message explaining the cause of the exception.
     */
	public BatteryDataException(String message) {
		super(message);
	}
	
}
