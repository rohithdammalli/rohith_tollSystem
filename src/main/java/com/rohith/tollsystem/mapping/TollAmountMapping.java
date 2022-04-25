package com.rohith.tollsystem.mapping;

import java.math.BigDecimal;

public interface TollAmountMapping {
	
	BigDecimal getTollFee();
	String getSameHour();
	Integer getVehiclTransactnId();

}
