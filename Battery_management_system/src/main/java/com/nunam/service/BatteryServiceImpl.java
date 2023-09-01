package com.nunam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nunam.exception.BatteryException;
import com.nunam.model.Battery;
import com.nunam.model.BatteryData;
import com.nunam.model.BatteryInfo;
import com.nunam.repository.BatteryDataRepository;
import com.nunam.repository.BatteryRepository;

@Service
public class BatteryServiceImpl implements BatteryService{

	@Autowired
	private BatteryDataRepository batteryDataRepository;
	
	@Autowired
	private BatteryRepository batteryRepository;
	
	@Override
	public Battery createNewBattery(Battery battery) {
		
		// Saves a new Battery instance to the database.
		return batteryRepository.save(battery);
	}
	
	
	@Override
	public BatteryInfo getBatteryLatestDetails(Integer batteryId) throws BatteryException {
		// Retrieves the latest BatteryData and constructs BatteryInfo.
		
		// Create a BatteryInfo object to hold the latest details.
		BatteryInfo currentBattery = new BatteryInfo();
		
		
		// Retrieve the latest battery data from the database.
		BatteryData batteryData = batteryDataRepository.findLatestDataByBatteryId(batteryId);
		
		// extracting battery from the battery data object
		Battery battery = batteryData.getBattery();
		
		// Populate the BatteryInfo object with retrieved data.
		currentBattery.setBattery_id(battery.getBatteryId());
		currentBattery.setModel(battery.getBattery_model());
		currentBattery.setMfg(battery.getMfg());
		currentBattery.setCurrent(batteryData.getCurrent());
		currentBattery.setVoltage(batteryData.getVoltage());
		currentBattery.setTemperature(batteryData.getTemperature());
		
		return currentBattery;
	}


	@Override
	public Battery getBatteryById(Integer batteryId) throws BatteryException {
		// Retrieves a Battery instance by its ID.
		
		// Retrieve the Battery from the repository by ID.
		Battery battery = batteryRepository.findById(batteryId).orElseThrow(()-> new BatteryException("Battery not found"));
		return battery;
	}


	@Override
	public void sendBatteryDataToDB(Integer batteryId) throws BatteryException {
		// Saves BatteryData to the database.
		
		// Retrieve the Battery instance from the repository by ID.
		Battery battery = batteryRepository.findById(batteryId).orElseThrow(()-> new BatteryException("Battery not found"));
		
		// Create a new BatteryData instance and associate it with the Battery.
		BatteryData currentData = new BatteryData();
		currentData.setBattery(battery);
		
		// Save the BatteryData to the database.
		batteryDataRepository.save(currentData);
		
		
	}

	

}
