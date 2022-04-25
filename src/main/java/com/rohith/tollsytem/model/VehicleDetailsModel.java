package com.rohith.tollsytem.model;

import java.math.BigDecimal;

public class VehicleDetailsModel {

	private Integer vehicleId;

	private String vehicleNumber;

	private String vehicleType;
	
	private Integer createdBy;
	
	private Integer modifiedBy;
	
	private BigDecimal totalCost;
	
	private BigDecimal lasttransaction;
	
	private Integer isDeleted;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public BigDecimal getLasttransaction() {
		return lasttransaction;
	}

	public void setLasttransaction(BigDecimal lasttransaction) {
		this.lasttransaction = lasttransaction;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}
