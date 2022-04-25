package com.rohith.tollsystem.service;

import com.rohith.tollsytem.model.ResponseStatus;
import com.rohith.tollsytem.model.VehicleDetailsModel;

public interface TollSystemService {

	
	public ResponseStatus collectTollFees(VehicleDetailsModel vehicleDetailsModel);
}
