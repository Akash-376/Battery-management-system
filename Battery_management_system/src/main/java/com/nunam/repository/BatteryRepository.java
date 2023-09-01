package com.nunam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nunam.model.Battery;

public interface BatteryRepository extends JpaRepository<Battery, Integer>{
	
	
}
