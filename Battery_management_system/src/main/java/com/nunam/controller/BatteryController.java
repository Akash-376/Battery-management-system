package com.nunam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunam.model.Battery;
import com.nunam.model.BatteryInfo;
import com.nunam.service.BatteryDataService;
import com.nunam.service.BatteryService;

/**
 * Controller class that handles HTTP requests related to battery operations.
 */

@RestController
@RequestMapping("/nunam") // Set the base URL here
public class BatteryController {
	
	@Autowired
	private BatteryService batteryService;
	
	@Autowired
	private BatteryDataService batteryDataService;
	 
	
	/**
     * Handles an HTTP POST request to create a new battery instance.
     *
     * @param battery The battery instance to be created.
     * @return ResponseEntity with the saved Battery instance and HttpStatus OK.
     */
	@PostMapping("/battery")
	public ResponseEntity<Battery> createBatteryHandler (@RequestBody Battery battery){
		Battery savedBattery = batteryService.createNewBattery(battery);
		
		return new ResponseEntity<>(savedBattery, HttpStatus.OK);
	}
	
	
	/**
     * Handles an HTTP GET request to retrieve detailed information about a specific battery.
     *
     * @param batteryId The identifier of the battery to retrieve information for.
     * @return ResponseEntity with the BatteryInfo instance containing battery details and HttpStatus OK.
     */
	@GetMapping("/battery/{batteryId}")
	public ResponseEntity<BatteryInfo> getBatteryInfoHandler(@PathVariable Integer batteryId){
		
		BatteryInfo batteryInfo = batteryService.getBatteryLatestDetails(batteryId);
		
		return new ResponseEntity<>(batteryInfo, HttpStatus.OK);
		
	}
	
	
	/**
     * Handles an HTTP POST request to start sending data from a battery.
     *
     * @param batteryId The identifier of the battery to start sending data from.
     * @return ResponseEntity with a success message and HttpStatus OK.
     */
	@PostMapping("/battery/startsendingdata/{batteryId}")
	public ResponseEntity<String> startSendingDataHandler(@PathVariable Integer batteryId){
		
		Battery currentBatteryInstance = batteryService.getBatteryById(batteryId);
		
		currentBatteryInstance.startSendingData();
		
		return new ResponseEntity<>("Data sending is in progress...", HttpStatus.OK);
	}
	
	
	/**
     * Handles an HTTP POST request to send battery data to the database.
     *
     * @param batteryId The identifier of the battery whose data needs to be sent to the database.
     * @return ResponseEntity with HttpStatus OK.
     */
	@PostMapping("/battery/senddata/{batteryId}")
	public ResponseEntity<Void> sendBatteryDataToDBHandler(@PathVariable Integer batteryId){
		
		batteryService.sendBatteryDataToDB(batteryId);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
}
