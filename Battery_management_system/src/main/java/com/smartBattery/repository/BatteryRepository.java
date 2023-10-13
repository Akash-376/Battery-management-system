package com.smartBattery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartBattery.model.Battery;

public interface BatteryRepository extends JpaRepository<Battery, Integer>{
	
	
}
