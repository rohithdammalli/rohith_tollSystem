CREATE DATABASE  IF NOT EXISTS `tollsystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tollsystem`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: tollsystem
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping events for database 'tollsystem'
--

--
-- Dumping routines for database 'tollsystem'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_gettollamount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_gettollamount`(IN vehicleNumber varchar(100),IN hr int(11),IN min int(11),IN secnd int(11))
BEGIN

DECLARE sameHour char(50) ;
DECLARE vehiclTransactnId int(11);

select rule4 ,rule5 into @minamt,@mxamt from tolladmin where admincode in('FeeRange');
select concat(hr,':',min,':',secnd) into @curtime;

select vehicletransactionsid,cost into @vehicltransactnid,@curCost from 
vehicletransactions where currentday=1 and 
vehicleid in (select ts.vehicleid from  tollvehicledetails ts where ts.vehiclenumber =vehicleNumber)
order by 1 desc limit 1;

select ts.vehicleid into @vhclId from  tollvehicledetails ts where ts.vehiclenumber =vehicleNumber;

select ifnull(sum(cost),0) into @totalCost from 
vehicletransactions where currentday=1 and vehicleid 
in (select ts.vehicleid from  tollvehicledetails ts where ts.vehiclenumber =vehicleNumber);


/* Make previous day as 0 so only current day is taken for calculations
*/
if(select count(*) from vehicletransactions vs where vs.currentday=1 and vs.vehicleid 
in (select ts.vehicleid from  tollvehicledetails ts where ts.vehiclenumber =vehicleNumber )
and  (vs.lasttransaction<subdate(now(),Interval 1 day))) >0 then 

update vehicletransactions
set currentday=0
where vehicleid = @vhclId and lasttransaction < subdate(now(),INTERVAL 1 day);


end if;

/*Check if vehicle request recieved at Rush hour than take highest amount range on checking 60 sek max value*/

if(select count(*) from tolladmin where admincode ='RushHour' and rule3>=hr and rule4<=hr>0) then
	
    
    if(select @totalCost + (select rule1 from tolladmin where admincode ='FeeRange')>=60) then

select format(60- @totalCost,2) as tollFee;

else 

select   rule1 as tollFee from tolladmin where admincode ='FeeRange' ;

end if;
    
    /*Check if vehicle request recieved within the same hour than take highest amount*/

elseif(select count(*) from vehicletransactions
where currentday =1  and DATE_FORMAT(SUBTIME(@curtime, DATE_FORMAT(lasttransaction,'%H:%i:%S')),'%H')<=1
and vehicletransactionsid =@vehicltransactnid >0) then

if(select format(@totalCost + GREATEST(@curCost,floor(RAND()*(@mxamt-@minamt))+@minamt),2)<=60) then

select format(GREATEST(@curCost,floor(RAND()*(@mxamt-@minamt))+@minamt),2) as tollFee,
'sameHour' as sameHour,@vehicltransactnid as vehiclTransactnId  ;

else 

select  format(60- @totalCost,2) as tollFee;

end if;

else
/*
Check for max transaction if not generate and send the cost
*/
if(select format(@totalCost + floor(RAND()*(@mxamt-@minamt))+@minamt,2) >=60) then

select format(60- @totalCost,2) as tollFee;

else 

select  format(floor(RAND()*(@mxamt-@minamt))+@minamt,2) as tollFee;

end if;




end if;




END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_initialdata` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_initialdata`()
BEGIN

select rule4 as minAmount,rule5 as maxAmount,admincode  as adminCode from tolladmin where admincode in('FeeRange','MaxFeeDay');

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_isfreevehicle` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_isfreevehicle`(IN vehicleType varchar(500),IN dayOfMonth int (4),IN  mnth varchar(100))
BEGIN

select count(*) from tolladmin where rule1 = vehicleType or (upper(rule1)=mnth and rule4=dayOfMonth);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-25 23:20:56
