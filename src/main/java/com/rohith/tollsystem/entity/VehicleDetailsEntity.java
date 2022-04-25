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
@Table(name="tollvehicledetails")
public class VehicleDetailsEntity  extends DateAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicleid")
	private Integer vehicleId;

	@Column(name="vehiclenumber")
	private String vehicleNumber;

	@Column(name="vehicletype")
	private String vehicleType;
	
	@Column(name="createdby")
	private Integer createdBy;
	
	@Column(name="modifiedby")
	private Integer modifiedBy;
	
	@Column(name="totalcost")
	private BigDecimal totalCost;
	
	@Column(name="lasttransaction")
	private LocalDateTime lasttransaction;
	
	@Column(name="isdeleted")
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



	public LocalDateTime getLasttransaction() {
		return lasttransaction;
	}

	public void setLasttransaction(LocalDateTime lasttransaction) {
		this.lasttransaction = lasttransaction;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}
