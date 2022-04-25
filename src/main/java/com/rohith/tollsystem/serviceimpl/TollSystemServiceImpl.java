package com.rohith.tollsystem.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohith.tollsystem.entity.VehicleDetailsEntity;
import com.rohith.tollsystem.entity.VehicleTransactionsEntity;
import com.rohith.tollsystem.mapping.TollAmountMapping;
import com.rohith.tollsystem.repository.TollAdminRepository;
import com.rohith.tollsystem.repository.VehcileTransactionsRepository;
import com.rohith.tollsystem.repository.VehicleDetailsRepository;
import com.rohith.tollsystem.service.TollSystemService;
import com.rohith.tollsytem.app.logger.LoggerUtil;
import com.rohith.tollsytem.model.ResponseStatus;
import com.rohith.tollsytem.model.VehicleDetailsModel;

@Service
public class TollSystemServiceImpl implements TollSystemService{
	
	private static final LoggerUtil LOG = new LoggerUtil(TollSystemServiceImpl.class);

	
	@Autowired
	TollAdminRepository tollAdminRepository;
	
	@Autowired
	VehicleDetailsRepository vehicleDetailsRepository;
	
	@Autowired
	VehcileTransactionsRepository vehcileTransactionsRepository;

	@Override
	public ResponseStatus collectTollFees(VehicleDetailsModel vehicleDetailsModel) {
		
		ResponseStatus resp = new ResponseStatus();

		
	LocalDateTime dateTime = LocalDateTime.now();
	BigDecimal tollFee = new BigDecimal(0);
	
	LOG.info("Input recieved of vehicle type and Vehicle Number is " +vehicleDetailsModel.getVehicleType() + " and  "
			+ vehicleDetailsModel.getVehicleNumber());
	
	try {
	if(tollAdminRepository.isFreeVehicle(vehicleDetailsModel.getVehicleType(),dateTime.getDayOfMonth(),
			dateTime.getMonth().toString())>0)
	{
		
		resp.setStatusCode(200);
		resp.setStatusMessage("Toll fee is free for this Vehicle Type "+ vehicleDetailsModel.getVehicleType() );
		
		return resp;
		
	}
	else
	{
	
		TollAmountMapping tollAmountMapping = tollAdminRepository.getTollAmount(vehicleDetailsModel.getVehicleNumber(),dateTime.getHour(),
				dateTime.getMinute(),dateTime.getSecond());
		tollFee=tollAmountMapping.getTollFee();
	
		
		if(null!=vehicleDetailsModel.getVehicleNumber())
		{
			VehicleDetailsEntity vehicleDetailsEntity = new VehicleDetailsEntity();

		 vehicleDetailsEntity =	vehicleDetailsRepository.findByVehicleNumber(vehicleDetailsModel.getVehicleNumber());

		 
			if(null== vehicleDetailsEntity && null==tollAmountMapping.getSameHour() )
			{
				
				VehicleDetailsEntity vehicleEntity = new VehicleDetailsEntity();
				vehicleEntity.setVehicleNumber(vehicleDetailsModel.getVehicleNumber());
				vehicleEntity.setVehicleType(vehicleDetailsModel.getVehicleType());
				vehicleEntity.setTotalCost(tollAmountMapping.getTollFee());
				vehicleDetailsEntity = vehicleDetailsRepository.saveAndFlush(vehicleEntity);
				
			}
			
			else
			{

				
						if(null!=tollAmountMapping.getTollFee() && tollAmountMapping.getTollFee().intValue()>0)
				vehicleDetailsEntity.setTotalCost(tollFee.add((null!= vehicleDetailsEntity && null!=vehicleDetailsEntity.getTotalCost())?vehicleDetailsEntity.getTotalCost():new BigDecimal(0)));
				vehicleDetailsEntity.setLasttransaction(LocalDateTime.now());
				vehicleDetailsEntity = vehicleDetailsRepository.saveAndFlush(vehicleDetailsEntity);
			}
			
			LOG.info("Vehicle fees and vehicle Id is  "+ tollFee +"" + vehicleDetailsEntity.getVehicleId() );

		VehicleTransactionsEntity vehicleTransactionsEntity = new VehicleTransactionsEntity();
		vehicleTransactionsEntity.setCostPerTransaction(tollAmountMapping.getTollFee());
		vehicleTransactionsEntity.setVehicleId(vehicleDetailsEntity.getVehicleId());
		vehicleTransactionsEntity.setCurrentDay(1);
		if(null!=tollAmountMapping.getVehiclTransactnId())
		{
			vehicleTransactionsEntity.setVehicleTransactionsId(tollAmountMapping.getVehiclTransactnId());
		}
		vehicleTransactionsEntity.setLastTransaction(LocalDateTime.now());
		vehcileTransactionsRepository.save(vehicleTransactionsEntity);
		
		}
		

	
	
	
	}
	
	resp.setStatusCode(200);
	resp.setStatusMessage("Fees dedcuted is "+ tollFee.toString());
	
	}
	catch(Exception e)
	{
		LOG.error("Toll Amount collection Failure", e);
		
	}
	
	return resp;
	}

}
