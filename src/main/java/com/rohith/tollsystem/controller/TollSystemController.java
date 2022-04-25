package com.rohith.tollsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohith.tollsystem.service.TollSystemService;
import com.rohith.tollsytem.model.ResponseStatus;
import com.rohith.tollsytem.model.VehicleDetailsModel;

@RestController
@RequestMapping("/tollSystem")
public class TollSystemController {

	
	@Autowired
	TollSystemService tollSystemService;
	
	@PostMapping("/collectToll")
	public ResponseEntity<ResponseStatus>  takeToll(@RequestBody VehicleDetailsModel vehicleDetailsModel)
	{
		
		
		return new ResponseEntity<ResponseStatus>(tollSystemService.collectTollFees(vehicleDetailsModel), HttpStatus.ACCEPTED);
	}
	
	
} 
