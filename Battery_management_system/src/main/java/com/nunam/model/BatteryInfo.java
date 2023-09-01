package com.nunam.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents detailed information about a particular battery. This class is used for providing battery data,
 * but it is not mapped to the database.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatteryInfo {
	
	private Integer battery_id;
	private String model;
	private LocalDate mfg;
	private double current;
	private double voltage;
	private double temperature;
	
	
}
