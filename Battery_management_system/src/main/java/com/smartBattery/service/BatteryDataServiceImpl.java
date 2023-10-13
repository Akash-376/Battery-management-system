package com.smartBattery.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smartBattery.exception.BatteryDataException;
import com.smartBattery.exception.BatteryException;
import com.smartBattery.model.Battery;
import com.smartBattery.model.BatteryData;
import com.smartBattery.model.BatteryInfo;
import com.smartBattery.repository.BatteryDataRepository;
import com.smartBattery.repository.BatteryRepository;


/**
 * Implementation of the BatteryDataService interface.
 */
@Service
public class BatteryDataServiceImpl implements BatteryDataService{
	
	@Autowired
	private BatteryRepository batteryRepository;
	
	@Autowired
	private BatteryDataRepository batteryDataRepository;
	
	@Override
	public List<BatteryData> getAllInfoOfABatteryById(Integer batteryId) throws BatteryException {
		// Retrieves all BatteryData entries for a specific battery.
		
		// Retrieve the Battery instance from the repository by ID.
		Battery currentBattery = batteryRepository.findById(batteryId).orElseThrow(()-> new BatteryException("battery not found"));
		
		// Retrieve all BatteryData entries for the specified battery, ordered by timestamp in descending order.
		List<BatteryData> batteryData = batteryDataRepository.findByBatteryOrderByTimeStampDesc(currentBattery);
		
		// If no data is found, throw an exception.
		if(batteryData.isEmpty()) throw new BatteryDataException("Data not found");
		
		// If data is there
		return batteryData;
	}

	@Override
	public double getLatestVoltageRecord(Integer batteryId) throws BatteryException, BatteryDataException {
		// Retrieves the latest recorded voltage for a specific battery.
		
		// Retrieve the latest voltage from the repository for the specified battery.
		Double volt = batteryDataRepository.findLatestVoltageByBatteryId(batteryId).orElseThrow(()-> new BatteryException("Battery not found"));
		
		
		return volt;
	}

	@Override
	public double getLatestCurrentRecord(Integer batteryId) throws BatteryException, BatteryDataException {
		// Retrieves the latest recorded current for a specific battery.
		
		 // Retrieve the latest current from the repository for the specified battery.
		Double curr = batteryDataRepository.findLatestCurrentByBatteryId(batteryId).orElseThrow(()-> new BatteryException("Battery not found"));
		
		return curr;
	}

	@Override
	public double getLatestTemperatureRecord(Integer batteryId) throws BatteryException, BatteryDataException {
		// Retrieves the latest recorded temperature for a specific battery.
		
		// Retrieve the latest temperature from the repository for the specified battery.
		Double temp = batteryDataRepository.findLatestTemperatureByBatteryId(batteryId).orElseThrow(()-> new BatteryException("Battery not found"));
		
		return temp;
	}

	@Override
	public List<BatteryData> trackRecordWithIdAndTimeStamp(Integer batteryId, LocalDateTime startTime, LocalDateTime endTime) throws BatteryException, BatteryDataException {
		// Retrieves BatteryData entries within a specified time range for a specific battery.
		
		// Retrieve BatteryData entries for the specified battery and time range.
		List<BatteryData> dataList = batteryDataRepository.findRecordByBatteryIdAndTimeStampBetween(batteryId, startTime, endTime);
		
		// If no data is found, throw an exception.
		if(dataList.isEmpty()) throw new BatteryException("Battery not found");
		
		
		return dataList;
	}

}


















