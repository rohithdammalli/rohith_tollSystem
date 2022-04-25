package com.rohith.tollsytem.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class VehicleTransactionModel {

	private Integer vehicleTransactionsId;

	private Integer vehicleId;

	private BigDecimal costPerTransaction;
	
	private Integer createdBy;
	
	private Integer currentDay;
	
	private Integer modifiedBy;
	
	private LocalDateTime lastTransaction;
	
	private Integer isDeleted;

	public Integer getVehicleTransactionsId() {
		return vehicleTransactionsId;
	}

	public void setVehicleTransactionsId(Integer vehicleTransactionsId) {
		this.vehicleTransactionsId = vehicleTransactionsId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public BigDecimal getCostPerTransaction() {
		return costPerTransaction;
	}

	public void setCostPerTransaction(BigDecimal costPerTransaction) {
		this.costPerTransaction = costPerTransaction;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(Integer currentDay) {
		this.currentDay = currentDay;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getLastTransaction() {
		return lastTransaction;
	}

	public void setLastTransaction(LocalDateTime lastTransaction) {
		this.lastTransaction = lastTransaction;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
}
