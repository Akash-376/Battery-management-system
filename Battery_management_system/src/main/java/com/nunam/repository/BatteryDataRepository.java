package com.nunam.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nunam.model.Battery;
import com.nunam.model.BatteryData;


public interface BatteryDataRepository extends JpaRepository<BatteryData, Integer>{
	
	@Query("SELECT bd FROM BatteryData bd WHERE bd.battery.batteryId = :batteryId ORDER BY bd.timeStamp DESC LIMIT 1")
	BatteryData findLatestDataByBatteryId(Integer batteryId);
	
	
	@Query("SELECT bd.voltage FROM BatteryData bd WHERE bd.battery.batteryId = :batteryId ORDER BY bd.timeStamp DESC LIMIT 1")
	Optional<Double> findLatestVoltageByBatteryId(Integer batteryId);
	
	
	@Query("SELECT bd.current FROM BatteryData bd WHERE bd.battery.batteryId = :batteryId ORDER BY bd.timeStamp DESC LIMIT 1")
	Optional<Double> findLatestCurrentByBatteryId(Integer batteryId);
	
	@Query("SELECT bd.temperature FROM BatteryData bd WHERE bd.battery.batteryId = :batteryId ORDER BY bd.timeStamp DESC LIMIT 1")
	Optional<Double> findLatestTemperatureByBatteryId(Integer batteryId);
	
	@Query("SELECT bd FROM BatteryData bd WHERE bd.battery.batteryId = :batteryId AND bd.timeStamp BETWEEN :startTime AND :endTime ORDER BY bd.timeStamp DESC")
    List<BatteryData> findRecordByBatteryIdAndTimeStampBetween(Integer batteryId, LocalDateTime startTime, LocalDateTime endTime);
	
	
	// to fetch data latest to older means latest data will come first in the list
	List<BatteryData> findByBatteryOrderByTimeStampDesc(Battery currentBattery);
}
