package com.rohith.tollsystem.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rohith.tollsystem.audit.DateAudit;

@Entity
@Table(name="vehicletransactions")
public class VehicleTransactionsEntity extends DateAudit{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicletransactionsid")
	private Integer vehicleTransactionsId;

	@Column(name="vehicleid")
	private Integer vehicleId;

	@Column(name="cost")
	private BigDecimal costPerTransaction;
	
	@Column(name="createdby")
	private Integer createdBy;
	
	@Column(name="currentday")
	private Integer currentDay;
	
	@Column(name="modifiedby")
	private Integer modifiedBy;
	
	@Column(name="lasttransaction")
	private LocalDateTime lastTransaction;
	
	@Column(name="isdeleted")
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
