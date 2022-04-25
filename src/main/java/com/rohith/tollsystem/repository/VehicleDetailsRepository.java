package com.rohith.tollsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohith.tollsystem.entity.VehicleDetailsEntity;

@Repository
public interface VehicleDetailsRepository extends JpaRepository<VehicleDetailsEntity, Integer>{

	 
	
	
	VehicleDetailsEntity findByVehicleNumber(String vehicleNumber);

}
