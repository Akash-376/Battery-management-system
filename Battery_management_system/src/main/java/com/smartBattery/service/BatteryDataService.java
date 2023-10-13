package com.smartBattery.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.smartBattery.exception.BatteryDataException;
import com.smartBattery.exception.BatteryException;
import com.smartBattery.model.BatteryData;
import com.smartBattery.model.BatteryInfo;

public interface BatteryDataService {
	
	/**
     * Retrieves all BatteryData records for a specific Battery.
     *
     * @param batteryId The ID of the Battery.
     * @return A list of BatteryData records associated with the Battery.
     * @throws BatteryException If the Battery is not found.
     */
	List<BatteryData> getAllInfoOfABatteryById(Integer batteryId) throws BatteryException;
	
	/**
     * Retrieves the latest voltage record for a specific Battery.
     *
     * @param batteryId The ID of the Battery.
     * @return The latest recorded voltage for the Battery.
     * @throws BatteryException If the Battery is not found.
     * @throws BatteryDataException If there is an issue retrieving voltage data.
     */
	double getLatestVoltageRecord (Integer batteryId) throws BatteryException, BatteryDataException;
	
	/**
     * Retrieves the latest current record for a specific Battery.
     *
     * @param batteryId The ID of the Battery.
     * @return The latest recorded current for the Battery.
     * @throws BatteryException If the Battery is not found.
     * @throws BatteryDataException If there is an issue retrieving current data.
     */
	double getLatestCurrentRecord (Integer batteryId) throws BatteryException, BatteryDataException;
	
	/**
     * Retrieves the latest temperature record for a specific Battery.
     *
     * @param batteryId The ID of the Battery.
     * @return The latest recorded temperature for the Battery.
     * @throws BatteryException If the Battery is not found.
     * @throws BatteryDataException If there is an issue retrieving temperature data.
     */
	double getLatestTemperatureRecord (Integer batteryId) throws BatteryException, BatteryDataException;
	
	/**
     * Retrieves BatteryData records for a specific Battery within a specified time range.
     *
     * @param batteryId The ID of the Battery.
     * @param startTime The start time of the desired time range.
     * @param endTime   The end time of the desired time range.
     * @return A list of BatteryData records within the specified time range.
     * @throws BatteryException If the Battery is not found.
     * @throws BatteryDataException If there is an issue retrieving data within the time range.
     */
	List<BatteryData> trackRecordWithIdAndTimeStamp(Integer batteryId, LocalDateTime startTime, LocalDateTime endTime) throws BatteryException, BatteryDataException;
	
	
}
