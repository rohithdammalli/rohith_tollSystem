package com.rohith.tollsytem.model;

public class TollAdminModel {
	
	
	private Integer minAmount;
	
	private Integer maxAmount;
	
	private Integer maxDayAmount;
	
	private Boolean isTollFree;
	
	private Integer vehicleCharged;
	
	private Boolean isRushHour;
	
	private Integer tollAdminId;

	private String adminCode;

	private String columnDescription;
	
	private Integer createdBy;
	
	private Integer modifiedBy;
	
	private Integer isActive;
	
	private Integer isDeleted;
	
	private String rule1;
	
	private String rule2;
	
	private String rule3;
	
	private Integer rule4;
	
	private Integer rule5;
	
	private Integer processId;

	public Integer getTollAdminId() {
		return tollAdminId;
	}

	public void setTollAdminId(Integer tollAdminId) {
		this.tollAdminId = tollAdminId;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getColumnDescription() {
		return columnDescription;
	}

	public void setColumnDescription(String columnDescription) {
		this.columnDescription = columnDescription;
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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getRule1() {
		return rule1;
	}

	public void setRule1(String rule1) {
		this.rule1 = rule1;
	}

	public String getRule2() {
		return rule2;
	}

	public void setRule2(String rule2) {
		this.rule2 = rule2;
	}

	public String getRule3() {
		return rule3;
	}

	public void setRule3(String rule3) {
		this.rule3 = rule3;
	}

	public Integer getRule4() {
		return rule4;
	}

	public void setRule4(Integer rule4) {
		this.rule4 = rule4;
	}

	public Integer getRule5() {
		return rule5;
	}

	public void setRule5(Integer rule5) {
		this.rule5 = rule5;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public Integer getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Integer minAmount) {
		this.minAmount = minAmount;
	}

	public Integer getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Integer maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Integer getMaxDayAmount() {
		return maxDayAmount;
	}

	public void setMaxDayAmount(Integer maxDayAmount) {
		this.maxDayAmount = maxDayAmount;
	}

	public Boolean getIsTollFree() {
		return isTollFree;
	}

	public void setIsTollFree(Boolean isTollFree) {
		this.isTollFree = isTollFree;
	}

	public Integer getVehicleCharged() {
		return vehicleCharged;
	}

	public void setVehicleCharged(Integer vehicleCharged) {
		this.vehicleCharged = vehicleCharged;
	}

	public Boolean getIsRushHour() {
		return isRushHour;
	}

	public void setIsRushHour(Boolean isRushHour) {
		this.isRushHour = isRushHour;
	}

	
}
