-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: diosesis
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asistente`
--

DROP TABLE IF EXISTS `asistente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistente` (
  `asistenteID` int(11) NOT NULL AUTO_INCREMENT,
  `asistenteUUID` varchar(50) NOT NULL,
  `identidad` int(11) NOT NULL,
  `carnet` int(11) DEFAULT NULL,
  `primerNom` varchar(20) NOT NULL,
  `segundoNom` varchar(20) DEFAULT NULL,
  `primerApe` varchar(20) NOT NULL,
  `segundoApe` varchar(20) NOT NULL,
  `ocupacion` varchar(100) NOT NULL,
  `celular` int(11) DEFAULT NULL,
  `sexo` varchar(10) NOT NULL,
  `fechaNac` date NOT NULL,
  `foto` blob,
  `cargos` varchar(250) NOT NULL,
  `observaciones` varchar(500) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `createBy` varchar(50) NOT NULL,
  `createDT` datetime NOT NULL,
  `updateBy` varchar(50) DEFAULT NULL,
  `updateDT` datetime DEFAULT NULL,
  `fk_lumisialCod` int(11) DEFAULT NULL,
  `fk_estadoCivilCod` varchar(50) NOT NULL,
  PRIMARY KEY (`asistenteID`),
  KEY `indentidad` (`identidad`),
  KEY `primerNom` (`primerNom`,`primerApe`),
  KEY `fk_lumisialCod` (`fk_lumisialCod`),
  KEY `fk_estadoCivilCod` (`fk_estadoCivilCod`,`identidad`),
  KEY `fk_estadoCivilCod_2` (`fk_estadoCivilCod`),
  CONSTRAINT `asistente_ibfk_1` FOREIGN KEY (`fk_estadoCivilCod`) REFERENCES `estadoCivil` (`estadoCivilCod`),
  CONSTRAINT `fk_lumisialCod_lumisial_lumisialCod` FOREIGN KEY (`fk_lumisialCod`) REFERENCES `lumisial` (`lumisialCod`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistente`
--

LOCK TABLES `asistente` WRITE;
/*!40000 ALTER TABLE `asistente` DISABLE KEYS */;
INSERT INTO `asistente` VALUES (2,'9c6326c9-b01f-4f1b-a7f9-4eb6c6886882',1,0,'j','j','j','j','',0,'M','2015-10-16','null','CATORCENO,CORO',' ','\0','jhon','2015-10-14 19:46:57','jhon','2015-10-14 19:46:57',1,'cas'),(3,'27e9e724-6b52-4b43-978e-99815b90730a',1144058730,0,'JHON','EDISON','GOMEZ','SANCHEZ','PROGRAMADOR',0,'M','2015-10-17','null','JUNTA ADMINISTRATIVA,CATORCENO,JUNTA ADMINISTRATIVA DEPARTAMENTAL,CORO',' ','','jhon','2015-10-14 19:55:26','jhon','2015-10-14 19:55:26',1,'solt'),(5,'50906059-461e-4e71-a194-818b3a07624e',3,0,'PRUEBA2','','PRUEBA2','','',0,'F','2015-10-17','null','CATORCENO,CORO',' ','\0','jhon','2015-10-16 22:24:40','jhon','2015-10-16 22:24:40',2,'solt'),(6,'ef984e47-6cdb-4c79-85fd-7e8b4653a21c',4,0,'PRUEBA4','','PRUEBA4','','',0,'F','2015-10-15','null','JUNTA ADMINISTRATIVA DEPARTAMENTAL',' ','\0','jhon','2015-10-16 22:27:03','jhon','2015-10-16 22:27:03',2,'solt'),(7,'2e9f6fc3-a64f-4b73-8829-69829e9cde5b',5,0,'PRUEBA5','','PRUEBA5','','',0,'M','2015-10-17','null','CATEQUISTA',' ','\0','jhon','2015-10-16 22:28:33','jhon','2015-10-16 22:28:33',1,'solt'),(8,'cde9a032-c166-44a3-bb15-f9bcac734887',6,0,'ass','','asas','','asas',121,'F','2015-10-07','null','CORO',' ','','jhon','2015-10-16 23:53:35','jhon','2015-10-16 23:53:35',1,'union');
/*!40000 ALTER TABLE `asistente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `ciudadID` int(11) NOT NULL AUTO_INCREMENT,
  `ciudadUUID` varchar(50) NOT NULL,
  `ciudadCod` int(11) NOT NULL,
  `ciudadNom` varchar(100) NOT NULL,
  `active` bit(1) NOT NULL,
  `createBy` varchar(50) NOT NULL,
  `createDT` datetime NOT NULL,
  `updateBy` varchar(50) DEFAULT NULL,
  `updateDT` datetime DEFAULT NULL,
  `fk_diocesisCod` int(11) NOT NULL,
  PRIMARY KEY (`ciudadID`),
  KEY `ciudadCod` (`ciudadCod`),
  KEY `ciudadNom` (`ciudadNom`),
  KEY `fk_diocesisCod` (`fk_diocesisCod`,`ciudadNom`),
  CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`fk_diocesisCod`) REFERENCES `diosesis` (`diosesisCod`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (2,'4b18d442-99f8-49a0-ad07-f6e5565380ef',1,'CALI','','jhon','2015-10-04 14:38:24','jhon','2015-10-04 14:38:24',1),(3,'4678d6ad-9761-4723-8213-b97875f25f6a',3,'test','','jhon','2016-02-23 23:09:58','jhon','2016-02-23 23:09:58',1);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diosesis`
--

DROP TABLE IF EXISTS `diosesis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diosesis` (
  `diosesisID` int(11) NOT NULL AUTO_INCREMENT,
  `diosesisUUID` varchar(50) NOT NULL,
  `diosesisCod` int(11) NOT NULL,
  `diosesisNom` varchar(100) NOT NULL,
  `active` bit(1) NOT NULL,
  `createBy` varchar(50) NOT NULL,
  `createDT` datetime NOT NULL,
  `updateBy` varchar(50) DEFAULT NULL,
  `updateDT` datetime DEFAULT NULL,
  `fk_PaisCod` int(11) NOT NULL,
  PRIMARY KEY (`diosesisID`),
  KEY `diosesisCod` (`diosesisCod`),
  KEY `diosesisNom` (`diosesisNom`),
  KEY `fk_paisCod_pais_paisCod` (`fk_PaisCod`),
  CONSTRAINT `diosesis_ibfk_1` FOREIGN KEY (`fk_PaisCod`) REFERENCES `pais` (`paisCod`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diosesis`
--

LOCK TABLES `diosesis` WRITE;
/*!40000 ALTER TABLE `diosesis` DISABLE KEYS */;
INSERT INTO `diosesis` VALUES (1,'88b6ac80-488e-48b0-8269-14af68f1a679',1,'VALLE SUR','','jhon','2015-09-24 21:59:20','jhon','2015-09-24 21:59:20',14),(3,'556479f3-0587-4670-8d94-a4365228db8c',3,'VALLE NORTE','','jhon','2015-09-24 22:13:27','jhon','2015-09-24 22:13:27',14),(4,'c93e9c25-7652-4151-ba53-e5dedb3a9d14',4,'CAUCA','','jhon','2015-09-24 22:16:49','jhon','2015-09-24 22:16:49',14),(5,'47a1b68f-a52c-4759-a853-3d9939ce9ad9',13,'test','','jhon','2016-02-23 21:47:25','jhon','2016-02-23 21:47:25',23);
/*!40000 ALTER TABLE `diosesis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoCivil`
--

DROP TABLE IF EXISTS `estadoCivil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoCivil` (
  `estadoCivilID` int(11) NOT NULL AUTO_INCREMENT,
  `estadoCivilCod` varchar(50) NOT NULL,
  `estadoCivilDesc` varchar(50) NOT NULL,
  `active` bit(1) NOT NULL,
  `createBy` varchar(50) NOT NULL,
  `createDT` datetime NOT NULL,
  `updateBy` varchar(50) DEFAULT NULL,
  `updateDT` datetime DEFAULT NULL,
  PRIMARY KEY (`estadoCivilID`),
  KEY `estadoCivilCod` (`estadoCivilCod`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoCivil`
--

LOCK TABLES `estadoCivil` WRITE;
/*!40000 ALTER TABLE `estadoCivil` DISABLE KEYS */;
INSERT INTO `estadoCivil` VALUES (1,'solt','SOLTERO','','jhon','2015-10-14 00:00:00','jhon','2015-10-14 00:00:00'),(2,'cas','CASADO','','jhon','2015-10-14 00:00:00','jhon','2015-10-14 00:00:00'),(3,'union','UNION LIBRE','','jhon','2015-10-14 00:00:00','jhon','2015-10-14 00:00:00'),(4,'viud','VIUDO','','jhon','2015-10-14 00:00:00','jhon','2015-10-14 00:00:00');
/*!40000 ALTER TABLE `estadoCivil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lumisial`
--

DROP TABLE IF EXISTS `lumisial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lumisial` (
  `lumisialID` int(11) NOT NULL AUTO_INCREMENT,
  `lumisialUUID` varchar(50) NOT NULL,
  `lumisialCod` int(11) NOT NULL,
  `lumisialNom` varchar(100) NOT NULL,
  `lumisialDir` varchar(50) DEFAULT NULL,
  `lumisialTel` int(11) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `createBy` varchar(50) NOT NULL,
  `createDT` datetime NOT NULL,
  `updateBy` varchar(50) DEFAULT NULL,
  `updateDT` datetime DEFAULT NULL,
  `fk_ciudadCod` int(11) NOT NULL,
  PRIMARY KEY (`lumisialID`),
  KEY `lumisialCod` (`lumisialCod`),
  KEY `lumisialNom` (`lumisialNom`),
  KEY `fk_ciudadCod_ciudad_ciudadCod` (`fk_ciudadCod`),
  CONSTRAINT `lumisial_ibfk_1` FOREIGN KEY (`fk_ciudadCod`) REFERENCES `ciudad` (`ciudadCod`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lumisial`
--

LOCK TABLES `lumisial` WRITE;
/*!40000 ALTER TABLE `lumisial` DISABLE KEYS */;
INSERT INTO `lumisial` VALUES (1,'0e22656c-65af-48e6-b2ca-dc24703ac832',1,'LUZ ALBA','CALLE 30',65323223,'','jhon','2015-10-07 15:15:04','jhon','2015-10-07 15:15:04',1),(2,'c0047911-e7ab-48e1-85b3-456527616564',2,'ZANONI','SASAS121',12121212,'','jhon','2015-10-07 15:39:39','jhon','2015-10-07 15:39:39',1),(3,'523a2960-b4aa-4a35-992e-b25e4fc69a44',3,'PRUEBA','CACAC223',12121,'','jhon','2015-10-07 15:43:40','jhon','2015-10-07 15:43:40',1);
/*!40000 ALTER TABLE `lumisial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `PaisID` int(11) NOT NULL AUTO_INCREMENT,
  `paisUUID` varchar(50) NOT NULL,
  `paisCod` int(11) NOT NULL,
  `paisNom` varchar(100) NOT NULL,
  `active` bit(1) NOT NULL,
  `createBy` varchar(50) NOT NULL,
  `createDT` datetime NOT NULL,
  `updateBy` varchar(50) DEFAULT NULL,
  `updateDT` datetime DEFAULT NULL,
  PRIMARY KEY (`PaisID`),
  KEY `paisCod` (`paisCod`),
  KEY `paisNom` (`paisNom`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'dd086ea8-4aad-44a2-ac88-cb0e1d10d57e',14,'COLOMBIA','','jhon','2015-09-10 16:50:01','jhon','2015-09-10 16:50:01'),(2,'ba8d8a35-1562-4ad2-8ebe-56f41197809f',15,'BOLIVIA','','jhon','2015-09-11 08:55:17','jhon','2015-09-11 08:55:17'),(3,'c2ab0a66-2e1d-4713-a615-cb65159ffdd8',13,'VENEZUELA','','jhon','2015-09-14 11:44:40','jhon','2015-09-14 11:44:40'),(4,'e0fbf6e3-df83-4c2d-bd9e-a120baedef9b',18,'ECUADOR','','jhon','2015-09-14 11:48:43','jhon','2015-09-14 11:48:43'),(6,'350f6b5a-c508-4095-98de-efe22aa844dd',21,'PERU','','jhon','2015-09-14 11:55:38','jhon','2015-09-14 11:55:38'),(7,'085b55ac-aec9-489b-a443-707e8910cf97',23,'ARGENTINA','','jhon','2015-09-14 12:00:25','jhon','2015-09-14 12:00:25');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuarioID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `createBy` varchar(50) NOT NULL,
  `createDT` datetime NOT NULL,
  `updateBy` varchar(50) DEFAULT NULL,
  `updateDT` datetime DEFAULT NULL,
  PRIMARY KEY (`usuarioID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-02 11:37:40
