package com.nunam.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunam.model.BatteryData;
import com.nunam.service.BatteryDataService;

/**
 * Controller class that handles HTTP requests related to battery data operations.
 */

@RestController
@RequestMapping("/nunam")
public class BatteryDataController {
	
	@Autowired
	private BatteryDataService batteryDataService;
	
	/**
     * Handles an HTTP GET request to retrieve all battery data entries of a specific battery.
     *
     * @param batteryId The identifier of the battery to retrieve data for.
     * @return ResponseEntity with the list of BatteryData instances and HttpStatus OK.
     */
	@GetMapping("/battery/info/{batteryId}")
	public ResponseEntity<List<BatteryData>> allInfoHandler(@PathVariable Integer batteryId){
		
		List<BatteryData> dataList = batteryDataService.getAllInfoOfABatteryById(batteryId);
		
		return new ResponseEntity<>(dataList, HttpStatus.OK);
		
	}
	
	
	/**
     * Handles an HTTP GET request to retrieve the latest voltage record of a specific battery.
     *
     * @param batteryId The identifier of the battery to retrieve voltage for.
     * @return ResponseEntity with the latest voltage value and HttpStatus OK.
     */
	@GetMapping("/battery/voltage/{batteryId}")
	public ResponseEntity<Double> getVoltageHandler(@PathVariable Integer batteryId){
		
		
		Double voltage = batteryDataService.getLatestVoltageRecord(batteryId);
		
		return new ResponseEntity<>(voltage, HttpStatus.OK);
	}
	
	/**
     * Handles an HTTP GET request to retrieve the latest current record of a specific battery.
     *
     * @param batteryId The identifier of the battery to retrieve current for.
     * @return ResponseEntity with the latest current value and HttpStatus OK.
     */
	@GetMapping("/battery/current/{batteryId}")
	public ResponseEntity<Double> getCurrenteHandler(@PathVariable Integer batteryId){
		
		
		Double current = batteryDataService.getLatestCurrentRecord(batteryId);
		
		return new ResponseEntity<>(current, HttpStatus.OK);
	}
	
	/**
     * Handles an HTTP GET request to retrieve the latest temperature record of a specific battery.
     *
     * @param batteryId The identifier of the battery to retrieve temperature for.
     * @return ResponseEntity with the latest temperature value and HttpStatus OK.
     */
	@GetMapping("/battery/temperature/{batteryId}")
	public ResponseEntity<Double> getTemperatureHandler(@PathVariable Integer batteryId){
		
		
		Double temp = batteryDataService.getLatestTemperatureRecord(batteryId);
		
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	/**
     * Handles an HTTP GET request to retrieve battery data entries within a specific time range.
     *
     * @param batteryId The identifier of the battery to retrieve data for.
     * @param startTime The start time of the time range.
     * @param endTime The end time of the time range.
     * @return ResponseEntity with the list of BatteryData instances and HttpStatus OK.
     */
	@GetMapping("/battery/track/{batteryId}/{startTime}/{endTime}")
	public ResponseEntity<List<BatteryData>> trackRecordHandler(@PathVariable Integer batteryId, @PathVariable LocalDateTime startTime, @PathVariable LocalDateTime endTime){
		
		List<BatteryData> dataList = batteryDataService.trackRecordWithIdAndTimeStamp(batteryId, startTime, endTime);
		
		return new ResponseEntity<>(dataList, HttpStatus.OK);
		
	}
	
	
}
