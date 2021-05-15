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
-- Table structure for table `ac_tb_function`
--

DROP TABLE IF EXISTS `ac_tb_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ac_tb_function` (
  `SEQNO` int NOT NULL AUTO_INCREMENT,
  `FUNC_NAME` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ROLE_SEQNO` int DEFAULT NULL,
  `CRT_ID` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `CRT_DATE` datetime NOT NULL,
  `UPD_ID` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `UPD_DATE` datetime NOT NULL,
  `PARENT_FUNC_SEQNO` int NOT NULL,
  `FILE_NAME_URI` varchar(45) NOT NULL,
  PRIMARY KEY (`SEQNO`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ac_tb_function`
--

LOCK TABLES `ac_tb_function` WRITE;
/*!40000 ALTER TABLE `ac_tb_function` DISABLE KEYS */;
INSERT INTO `ac_tb_function` VALUES (2,'使用者管理',1,'admin','2019-12-01 16:48:45','admin','2019-12-01 16:48:45',0,''),(3,'使用者資訊',1,'admin','2019-12-01 20:12:01','admin','2019-12-01 20:12:01',2,'user/manage'),(4,'修改密碼',1,'admin','2019-12-01 20:12:01','admin','2019-12-01 20:12:01',2,'user/change'),(6,'使用者管理',2,'admin','2019-12-01 20:14:40','admin','2019-12-01 20:14:40',0,''),(7,'使用者資訊',2,'admin','2019-12-01 20:14:40','admin','2019-12-01 20:14:40',2,'user/manage'),(8,'新增使用者',2,'admin','2020-01-05 18:17:00','admin','2020-01-05 18:17:00',2,'user/add'),(9,'新增角色',2,'admin','2020-01-05 18:17:00','admin','2020-01-05 18:17:00',12,'auth/addRole'),(10,'新增使用者',1,'admin','2020-01-05 18:17:00','admin','2020-01-05 18:17:00',2,'user/add'),(11,'新增角色',1,'admin','2020-01-05 18:17:00','admin','2020-01-05 18:17:00',12,'auth/addRole'),(12,'權限管理',1,'admin','2020-01-23 15:10:00','admin','2020-01-23 15:10:00',0,''),(13,'使用者資訊',3,'admin','2020-01-25 17:11:27','admin','2020-01-25 17:11:27',2,'user/manage'),(14,'修改密碼',3,'admin','2020-01-25 17:11:27','admin','2020-01-25 17:11:27',2,'user/change'),(15,'新增使用者',3,'admin','2020-01-25 17:11:27','admin','2020-01-25 17:11:27',2,'user/add'),(16,'新增角色',3,'admin','2020-01-25 17:11:27','admin','2020-01-25 17:11:27',12,'auth/addRole'),(20,'使用者資訊',4,'App','2020-01-25 17:20:30','App','2020-01-25 17:20:30',2,'user/manage'),(21,'修改密碼',4,'App','2020-01-25 17:20:30','App','2020-01-25 17:20:30',2,'user/change'),(22,'新增使用者',4,'App','2020-01-25 17:20:30','App','2020-01-25 17:20:30',2,'user/add'),(23,'新增角色',4,'App','2020-01-25 17:20:30','App','2020-01-25 17:20:30',12,'auth/addRole'),(27,'使用者資訊',5,'App','2020-01-25 17:22:40','App','2020-01-25 17:22:40',2,'user/manage'),(28,'修改密碼',5,'App','2020-01-25 17:22:40','App','2020-01-25 17:22:40',2,'user/change'),(29,'新增使用者',5,'App','2020-01-25 17:22:40','App','2020-01-25 17:22:40',2,'user/add'),(30,'新增角色',5,'App','2020-01-25 17:22:40','App','2020-01-25 17:22:40',12,'auth/addRole');
/*!40000 ALTER TABLE `ac_tb_function` ENABLE KEYS */;
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
