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
-- Table structure for table `tollvehicledetails`
--

DROP TABLE IF EXISTS `tollvehicledetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tollvehicledetails` (
  `vehicleid` int NOT NULL AUTO_INCREMENT,
  `createdOn` datetime DEFAULT NULL,
  `modifiedOn` datetime DEFAULT NULL,
  `createdby` int DEFAULT NULL,
  `modifiedby` int DEFAULT NULL,
  `isdeleted` int DEFAULT NULL,
  `vehiclenumber` varchar(100) DEFAULT NULL,
  `vehicletype` varchar(100) DEFAULT NULL,
  `totalcost` decimal(19,2) DEFAULT NULL,
  `lasttransaction` datetime DEFAULT NULL,
  PRIMARY KEY (`vehicleid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tollvehicledetails`
--

LOCK TABLES `tollvehicledetails` WRITE;
/*!40000 ALTER TABLE `tollvehicledetails` DISABLE KEYS */;
INSERT INTO `tollvehicledetails` (`vehicleid`, `createdOn`, `modifiedOn`, `createdby`, `modifiedby`, `isdeleted`, `vehiclenumber`, `vehicletype`, `totalcost`, `lasttransaction`) VALUES (1,NULL,'2022-04-21 14:06:55',NULL,NULL,NULL,'DK-AW 20824','Car',-471.00,NULL),(2,'2022-04-21 15:25:38','2022-04-21 15:25:38',NULL,NULL,NULL,'DK-BB 0421','Car',-127.00,NULL),(3,'2022-04-21 15:29:03','2022-04-21 17:01:40',NULL,NULL,NULL,'DK-BB 04211','Car',60.00,NULL),(4,'2022-04-21 17:10:59','2022-04-21 17:13:28',NULL,NULL,NULL,'DK-BB 04212','Car',60.00,NULL),(5,'2022-04-21 17:14:39','2022-04-21 17:15:56',NULL,NULL,NULL,'DK-BB 04213','Car',14.00,'2022-04-21 17:15:56'),(6,'2022-04-21 17:21:34','2022-04-21 17:22:04',NULL,NULL,NULL,'DK-BB 04214','Car',9.00,'2022-04-21 17:22:04'),(7,'2022-04-21 17:23:40','2022-04-21 17:51:34',NULL,NULL,NULL,'DK-BB 04215','Car',124.00,'2022-04-21 17:51:34'),(8,'2022-04-24 22:18:28','2022-04-24 22:20:45',NULL,NULL,NULL,'DK-BB 04216','Car',18.00,'2022-04-24 22:20:45');
/*!40000 ALTER TABLE `tollvehicledetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-25 23:20:56
