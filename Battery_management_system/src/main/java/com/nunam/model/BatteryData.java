package com.nunam.model;
import java.time.LocalDateTime;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Represents data associated with a battery, including current, voltage, temperature, and timestamp.
 */

@Entity
@Data
public class BatteryData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer data_id;
	
	private double current;
	private double voltage;
	private double temperature;
	
	private LocalDateTime timeStamp;
	
	
	/**
     * The associated battery for which this data entry belongs.
     */
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "battery_id")
	@JsonIgnore
    private Battery battery;
	
	/**
     * Default constructor for BatteryData.
     * Generates random data for current, voltage, temperature, and sets the timestamp to the current time.
     * In a real application, data would be obtained from battery sensors.
     */
	public BatteryData() {
		
		double curr = 10*Math.random();
		this.current = Math.round(curr*100)/100.0;
		
		double vol = 150 + (400-150)*Math.random();	
		this.voltage = Math.round(vol*100)/100.0;
		
		double temp = 30 + (80-30)*Math.random();
		this.temperature = Math.round(temp*100)/100.0;
		
		this.timeStamp = LocalDateTime.now();
	}
	
	
}























