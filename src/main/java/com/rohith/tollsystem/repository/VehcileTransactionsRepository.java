package com.rohith.tollsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohith.tollsystem.entity.VehicleTransactionsEntity;

@Repository
public interface VehcileTransactionsRepository extends JpaRepository<VehicleTransactionsEntity, Integer>{

}
