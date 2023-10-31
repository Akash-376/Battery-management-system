package com.smartBattery.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Battery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer batteryId;
	
	private String battery_model;
	// manufacturing date of a particular battery
	private LocalDate mfg;
	
	private boolean isSendingData = false;
	
	@OneToMany(mappedBy = "battery")
    private List<BatteryData> dataEntries;
	
	public Battery() {
		this.mfg = LocalDate.now();
        this.dataEntries = new ArrayList<>();
    }
	
	// constructor
	public Battery(String battery_model) {
		this.battery_model = battery_model;
		this.mfg = LocalDate.now();
		this.dataEntries = new ArrayList<>();
	}
	
	
	// method to send data from battery to the Server
	public void startSendingData() {
		
		// creating http client to send request to the data sending endpoint
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		// class provided by Jackson library to serialize Java objects into JSON and Deserialize JSON data into Java objects. 
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule()); // Register the JavaTimeModule
		
		
		if(!isSendingData) {
			isSendingData = true;
			
			// lambda expression to implement run method of Thread class
			// Logic for sending data similar to your original sendBatteryData method
			Thread dataSenderThread = new Thread(() -> {
				
				while(isSendingData) {
					
					try {
						BatteryData batteryData = new BatteryData();
						
						// using jackson library to serialize object into JSON string
						String payLoad = objectMapper.writeValueAsString(batteryData);
						
						// post request for this endpoint (to continuously sending data from battery to server)
						HttpPost request = new HttpPost("http://localhost:8080/smart_battery/senddata/"+this.batteryId);
						
						StringEntity params = new StringEntity(payLoad, "UTF-8");
						request.addHeader("content-type", "application/json");
						request.setEntity(params);
						httpClient.execute(request);
						
						Thread.sleep(60000); // suspending the thread for 1 minute
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			});
			
			dataSenderThread.start(); // starting this as a new thread
		}
		
		
	}
	

	
}
