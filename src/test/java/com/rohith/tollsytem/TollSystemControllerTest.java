package com.rohith.tollsytem;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rohith.tollsystem.controller.TollSystemController;
import com.rohith.tollsystem.service.TollSystemService;
import com.rohith.tollsytem.model.VehicleDetailsModel;

@Tag("UnitTest")
//@SpringBootTest(classes= {TollSystemController.class})
public class TollSystemControllerTest {
	
	
	@Autowired
	TollSystemController tollSystemController;
	
	@MockBean
	TollSystemService tollSystemService;
	
	
	@Test
	public void collectToll() {
		
		VehicleDetailsModel vehicleDetailsModel = new VehicleDetailsModel();
			Mockito.doNothing().when(tollSystemService).collectTollFees(Mockito.any());
			Mockito.verify(tollSystemService,Mockito.times(1)).collectTollFees(Mockito.any());
		
	}
	
	
	
	

}
