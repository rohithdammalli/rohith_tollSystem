package com.rohith.tollsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rohith.tollsystem.audit.DateAudit;


@Entity
@Table(name="tolladmin")
public class TollAdminEntity extends DateAudit{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tolladminid")
	private Integer tollAdminId;

	@Column(name="admincode")
	private String adminCode;

	@Column(name="columndescription")
	private String columnDescription;
	
	@Column(name="createdby")
	private Integer createdBy;
	
	
	@Column(name="modifiedby")
	private Integer modifiedBy;
	

	@Column(name="isactive")
	private Integer isActive;
	
	@Column(name="isdeleted")
	private Integer isDeleted;
	
	@Column(name="rule1")
	private String rule1;
	
	@Column(name="rule2")
	private String rule2;
	
	@Column(name="rule3")
	private String rule3;
	
	
	@Column(name="rule4")
	private Integer rule4;
	

	@Column(name="rule5")
	private Integer rule5;
	
	@Column(name="processid")
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
	
	
	
	
	
}
