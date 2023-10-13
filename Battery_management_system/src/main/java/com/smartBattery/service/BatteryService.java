package com.smartBattery.service;

import com.smartBattery.exception.BatteryException;
import com.smartBattery.model.Battery;
import com.smartBattery.model.BatteryInfo;

public interface BatteryService {
	/**
     * Creates a new Battery instance.
     *
     * @param battery The Battery instance to create.
     * @return The created Battery instance.
     */
	public Battery createNewBattery(Battery battery);
	
	/**
     * Retrieves a Battery instance by its unique ID.
     *
     * @param batteryId The ID of the Battery to retrieve.
     * @return The retrieved Battery instance.
     * @throws BatteryException If the Battery is not found.
     */
	public Battery getBatteryById(Integer batteryId) throws BatteryException;
	
	/**
     * Retrieves the latest data sent from a Battery.
     *
     * @param batteryId The ID of the Battery.
     * @return Information about the latest Battery data.
     * @throws BatteryException If there is an issue retrieving data.
     */
	public BatteryInfo getBatteryLatestDetails(Integer batteryId) throws BatteryException;
	
	/**
     * Sends Battery data to a server or database.
     *
     * @param batteryId The ID of the Battery.
     * @throws BatteryException If there is an issue sending data.
     */
	public void sendBatteryDataToDB (Integer batteryId) throws BatteryException;
	
	
}
