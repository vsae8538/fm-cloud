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
-- Table structure for table `ac_tb_user`
--

DROP TABLE IF EXISTS `ac_tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ac_tb_user` (
  `SEQNO` int NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(200) NOT NULL,
  `CRT_ID` varchar(45) NOT NULL,
  `UPD_ID` varchar(45) NOT NULL,
  `CRT_DATE` datetime NOT NULL,
  `UPD_DATE` datetime NOT NULL,
  `ROLE_SEQNO` int DEFAULT NULL,
  `AGE` int DEFAULT NULL,
  `SEX` varchar(2) DEFAULT NULL,
  `PROPERTY` int DEFAULT NULL,
  `SALARY` int DEFAULT NULL,
  `DEBT` int DEFAULT NULL,
  `JOBS` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SEQNO`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ac_tb_user`
--

LOCK TABLES `ac_tb_user` WRITE;
/*!40000 ALTER TABLE `ac_tb_user` DISABLE KEYS */;
INSERT INTO `ac_tb_user` VALUES (1,'test','test123','test','admin','2019-11-17 12:34:05','2020-02-05 21:42:30',1,20,'男',4500,1500,10,'程序員'),(2,'admin','$2a$10$oIUDRuHTgd6qEU5aDwHlEe3/TIVqJlZh8b8Fn5zthhu0PxEUd/TtW','admin','admin','2019-11-29 18:35:37','2020-03-07 14:23:05',1,22,'女',1661,166,166,'網路工程師'),(3,'李哥','admin123','admin','admin','2019-12-20 11:19:00','2019-12-20 11:19:00',2,24,'男',900,900,900,'醫生'),(4,'小張','admin123','admin','admin','2019-12-20 11:19:00','2019-12-20 11:19:00',2,25,'女',123,321,123,'會計師'),(5,'測試','admin123','admin','admin','2019-12-20 11:19:00','2019-12-20 11:19:00',2,25,'女',321,213,123,'公務員'),(6,'te1231','admin123','test','test','2019-12-20 11:19:00','2019-12-20 11:19:00',1,45,'男',23123,21321,123,'議員'),(7,'fq','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',2,21,'男',23123,879,234,'牙醫'),(8,'qwe','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',1,27,'女',23123,786,432,'電子工程師'),(9,'wew','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',2,29,'男',1245,7564,546,'工讀生'),(10,'ewe','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',2,21,'男',123,4563,345,'農夫'),(11,'dvd','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',1,23,'男',213,457,234,'銷售員'),(12,'dvccx','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',2,23,'男',343,6573,23,'健身教練'),(13,'zxc','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',1,42,'男',342,2342,341,'業務人員'),(14,'zxc','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',2,52,'女',434,6523,123,'總統'),(15,'sad','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',1,34,'女',23123,123,433,'公務員'),(16,'asd','admin123','admin','test','2019-12-20 11:19:00','2019-12-20 11:19:00',2,36,'女',23123,423,13,'美術設計師'),(17,'x','$2a$10$8W1Bfn0oZjlO6wKp3Pu.3e9fZRNrCzcMt3DgT82urzR3Ufom7oyMK','App','App','2020-01-10 11:33:02','2020-01-10 11:33:02',1,12,'男',123,123,124,'x'),(18,'x123','$2a$10$U/IBDoLlRavwAa0TLqNckO1dEfN958LSk4c27W3kdmk2og1JcsnUe','App','App','2020-01-10 11:37:52','2020-01-10 11:37:52',1,20,'男',4500,123,124,'程序員'),(19,'api','$2a$10$cBmdhuOUeu8YyP5Umg5eruowceIOpMDYOcNthIpHufUo1JXe7kSdC','API','API','2020-03-30 19:23:36','2020-03-30 19:23:36',2,18,'男',123,231,123,'中文人士'),(20,'api','$2a$10$RD.zTmBQEFbmkQ8VBx7hvuG.q.hwQu.Gicr5Jzl5kWIdX6ZX0h/hm','API','API','2020-03-30 20:15:37','2020-03-30 20:15:37',2,18,'男',123,231,123,'中文人士'),(21,'api','$2a$10$JxIuR/rTqJqgP5L/lWjMoOHIL2AjgoqX4xu1AFngatboYvcK3EnFi','API','API','2020-03-30 20:22:42','2020-03-30 20:22:42',2,18,'男',123,231,123,'中文人士'),(23,'api','$2a$10$ShMjBJnAbUFmnt24iR3Ggu66K0hyJEDw47mmon2w6PIYMDhTJKwdi','API','API','2020-03-30 20:33:05','2020-03-30 20:33:05',2,18,'男',123,231,123,'中文人士'),(24,'api','$2a$10$reh99RciPVvXFblWgaFSI.qFfmnvwVZ6Du3YwSloegEyCVTtSig5G','API','API','2020-03-30 20:39:51','2020-03-30 20:39:51',2,18,'男',123,231,123,'中文人士'),(25,'api','$2a$10$dJxVZT7yCaOTnVuLnyI32.KFBHZz3YknefEEB/2pZujNPtOZlk4oW','API','API','2020-03-30 20:47:11','2020-03-30 20:47:11',2,18,'男',123,231,123,'中文人士');
/*!40000 ALTER TABLE `ac_tb_user` ENABLE KEYS */;
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
