package com.rohith.tollsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rohith.tollsystem.entity.TollAdminEntity;
import com.rohith.tollsystem.mapping.TollAdminReadingMapping;
import com.rohith.tollsystem.mapping.TollAmountMapping;

@Repository
public interface TollAdminRepository extends JpaRepository<TollAdminEntity, Integer>{

	@Query(nativeQuery = true,value = "call usp_initialdata()")  
	List<TollAdminReadingMapping> fetchIntialData();

	
	@Query(nativeQuery = true,value = "call usp_isfreevehicle(:vehicleType,:dayOfMonth,:month)") 
	Integer isFreeVehicle(String vehicleType, Integer dayOfMonth, String month);

	@Query(nativeQuery = true,value = "call usp_gettollamount(:vehicleNumber,:hour,:minute,:second)") 
	TollAmountMapping getTollAmount(String vehicleNumber, Integer hour, Integer minute, Integer second);

}
