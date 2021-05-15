-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ac
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `ac_tb_message_board`
--

DROP TABLE IF EXISTS `ac_tb_message_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ac_tb_message_board` (
  `SEQNO` int NOT NULL,
  `MESSAGE_TITLE` varchar(50) NOT NULL,
  `MESSAGE_TYPE` varchar(45) NOT NULL,
  `MESSAGE_CONTENT` varchar(200) NOT NULL,
  `MEDIA_FILE1` blob,
  `MEDIA_FILE2` blob,
  `MEDIA_FILE3` blob,
  `MEDIA_URL1` varchar(500) DEFAULT NULL,
  `MEDIA_URL2` varchar(500) DEFAULT NULL,
  `MEDIA_URL3` varchar(500) DEFAULT NULL,
  `CRT_ID` varchar(45) NOT NULL,
  `CRT_DT` datetime NOT NULL,
  `UPD_ID` varchar(45) NOT NULL,
  `UPD_DT` datetime NOT NULL,
  PRIMARY KEY (`SEQNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ac_tb_message_board`
--

LOCK TABLES `ac_tb_message_board` WRITE;
/*!40000 ALTER TABLE `ac_tb_message_board` DISABLE KEYS */;
INSERT INTO `ac_tb_message_board` VALUES (1,'test1','01','hello world',NULL,NULL,NULL,NULL,NULL,NULL,'sys','2020-03-07 11:38:13','sys','2020-03-07 11:38:13'),(2,'test2','02','hello world2',_binary '?',_binary '?',_binary '?',NULL,NULL,NULL,'sys','2020-03-07 11:38:13','sys','2020-03-07 11:38:13'),(3,'test3','03','hello world3',_binary '?',_binary '?',_binary '?',NULL,NULL,NULL,'sys','2020-03-07 11:38:13','sys','2020-03-07 11:38:13'),(4,'test4','04','hello world4',_binary '?',_binary '?',_binary '?',NULL,NULL,NULL,'sys','2020-03-07 11:38:13','sys','2020-03-07 11:38:13'),(5,'test5','05','hello world5',_binary '?',_binary '?',_binary '?',NULL,NULL,NULL,'sys','2020-03-07 11:38:13','sys','2020-03-07 11:38:13'),(6,'test6','06','6',_binary '?',_binary '?',_binary '?',NULL,NULL,NULL,'sys','2020-03-07 11:38:13','sys','2020-03-07 11:38:13');
/*!40000 ALTER TABLE `ac_tb_message_board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-12 14:35:35
