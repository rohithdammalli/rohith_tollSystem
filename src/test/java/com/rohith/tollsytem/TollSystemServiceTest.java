package com.rohith.tollsytem;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rohith.tollsystem.repository.TollAdminRepository;
import com.rohith.tollsystem.repository.VehcileTransactionsRepository;
import com.rohith.tollsystem.repository.VehicleDetailsRepository;
import com.rohith.tollsystem.service.TollSystemService;
import com.rohith.tollsytem.model.ResponseStatus;
import com.rohith.tollsytem.model.VehicleDetailsModel;

@RunWith(MockitoJUnitRunner.class)
@Tag("UnitTest")
//@SpringBootTest(classes= {TollSystemService.class})
public class TollSystemServiceTest {
	
	@Autowired
	TollSystemService tollSystemService;
	
	@MockBean
	TollAdminRepository tollAdminRepository;
	
	@MockBean
	VehicleDetailsRepository vehicleDetailsRepository;
	
	@MockBean
	VehcileTransactionsRepository vehcileTransactionsRepository;
	
	
	@Test
	public void collectFreeVehicle() {
		VehicleDetailsModel vehicleDetailsModel = new VehicleDetailsModel();
		vehicleDetailsModel.setVehicleType("Foreign");
		vehicleDetailsModel.setVehicleNumber("DK-BB 04215");
		Integer freeVehicle =0;
		Mockito.when(tollAdminRepository.isFreeVehicle(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString())).thenReturn(freeVehicle);
		
		ResponseStatus resp = tollSystemService.collectTollFees(vehicleDetailsModel);
		Mockito.verify(tollAdminRepository,Mockito.times(1)).isFreeVehicle(Mockito.any(), Mockito.any(), Mockito.any());
		
		
	}

}
