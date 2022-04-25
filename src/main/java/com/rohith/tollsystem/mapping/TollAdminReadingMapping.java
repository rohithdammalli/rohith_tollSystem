package com.rohith.tollsystem.mapping;

public interface TollAdminReadingMapping {
	
	Integer getMinAmount();
	Integer getMaxAmount();
	Integer getMaxDayAmount();
	Boolean getIsTollFree();
	Integer getVehicleCharged();
	Boolean getIsRushHour();
	String getAdminCode();

}
