package com.rohith.tollsystem.audit;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the activitylog database table.
 * 
 */
@Entity
@Table(name = "activitylog")
public class ActivityLog extends DateAudit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activitylogid")
	private Integer activityLogId;

	@Column(name = "description")
	private String description;

	@Column(name = "id1")
	private Integer id1;

	@Column(name = "id2")
	private Integer id2;

	@Column(name = "id3")
	private Integer id3;

	@Column(name = "logtype")
	private String logType;

	@Column(name = "value1")
	private String value1;

	@Column(name = "value2")
	private String value2;

	@Column(name = "value3")
	private String value3;

	@Column(name = "isactive")
	private Byte isActive;

	@Column(name = "createdby")
	private Integer createdBy;

	@Column(name = "modifiedby")
	private Integer modifiedBy;

	@Column(name = "comments")
	private String comments;

	@Column(name = "filelocation")
	private String fileLocation;


	public ActivityLog() {
	}

	public Integer getActivityLogId() {
		return activityLogId;
	}

	public void setActivityLogId(Integer activityLogId) {
		this.activityLogId = activityLogId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId1() {
		return id1;
	}

	public void setId1(Integer id1) {
		this.id1 = id1;
	}

	public Integer getId2() {
		return id2;
	}

	public void setId2(Integer id2) {
		this.id2 = id2;
	}

	public Integer getId3() {
		return id3;
	}

	public void setId3(Integer id3) {
		this.id3 = id3;
	}



	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	/*
	 * public Date getOrderId() { return orderId; }
	 * 
	 * public void setOrderId(Date orderId) { this.orderId = orderId; }
	 */

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public Byte getIsActive() {
		return isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
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


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
}