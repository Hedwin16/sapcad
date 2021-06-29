-- MySQL dump 10.13  Distrib 5.7.31, for Win32 (AMD64)
--
-- Host: localhost    Database: bd_sapcad
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Table structure for table `administradores`
--

DROP TABLE IF EXISTS `administradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administradores` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(100) NOT NULL,
  `clave` varchar(100) NOT NULL,
  `tipo` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administradores`
--

LOCK TABLES `administradores` WRITE;
/*!40000 ALTER TABLE `administradores` DISABLE KEYS */;
INSERT INTO `administradores` VALUES (1,'root','1234',4,NULL),(2,'Admin','1234',1,NULL);
/*!40000 ALTER TABLE `administradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamentos` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'Recursos Humanos'),(2,'Presidencia'),(3,'Dirección de Cronista');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `ci_empleado` int(11) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  `id_nomina` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (3,'Hedwin','Diaz',27169687,1,'Admin',2),(5,'Kevin','Aular',26885950,1,'Admin',2);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados_horas`
--

DROP TABLE IF EXISTS `empleados_horas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados_horas` (
  `id_hora` int(11) NOT NULL AUTO_INCREMENT,
  `ci_empleado` int(11) NOT NULL,
  PRIMARY KEY (`id_hora`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados_horas`
--

LOCK TABLES `empleados_horas` WRITE;
/*!40000 ALTER TABLE `empleados_horas` DISABLE KEYS */;
INSERT INTO `empleados_horas` VALUES (1,27169687),(2,27169687),(3,27169687),(4,27169687),(5,27169687),(6,27169687),(7,27169687),(8,27169687),(9,27169687),(10,27169687),(11,27169687),(12,27169687),(13,27169687),(14,27169687),(15,27169687),(16,27169687),(17,271696877),(18,27169687),(19,27169687),(20,27169687),(21,27169687),(22,27169687),(23,26885950);
/*!40000 ALTER TABLE `empleados_horas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horas`
--

DROP TABLE IF EXISTS `horas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horas` (
  `id_hora` int(11) NOT NULL AUTO_INCREMENT,
  `hora_entrada` time NOT NULL,
  `hora_salida` time DEFAULT NULL,
  `fecha` date NOT NULL,
  `t_horas` time DEFAULT NULL,
  PRIMARY KEY (`id_hora`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horas`
--

LOCK TABLES `horas` WRITE;
/*!40000 ALTER TABLE `horas` DISABLE KEYS */;
INSERT INTO `horas` VALUES (1,'09:52:03','09:52:26','2021-06-12','00:00:23'),(2,'10:02:25','10:02:53','2021-06-12','00:00:28'),(3,'16:47:41','16:47:45','2021-06-14','00:00:04'),(4,'16:50:27','16:50:32','2021-06-14','00:00:05'),(5,'16:50:55','16:53:33','2021-06-14','00:02:38'),(6,'16:53:55','16:56:23','2021-06-14','00:02:28'),(7,'16:57:06','16:59:16','2021-06-14','00:02:10'),(8,'17:09:39','12:41:11','2021-06-14','04:28:28'),(9,'12:41:34','12:42:07','2021-06-16','00:00:33'),(10,'12:42:19','12:42:42','2021-06-16','00:00:23'),(11,'12:46:03','12:46:29','2021-06-16','00:00:26'),(12,'12:46:42','17:21:32','2021-06-16','04:34:50'),(13,'17:29:06','17:29:32','2021-06-19','00:00:26'),(14,'16:46:56','16:47:16','2021-06-23','00:00:20'),(15,'16:54:21','16:55:36','2021-06-23','00:01:15'),(16,'10:05:07','08:34:04','2021-06-25','01:31:03'),(17,'08:33:15','08:33:47','2021-06-26','00:00:32'),(18,'08:38:40','08:40:58','2021-06-26','00:02:18'),(19,'10:16:59','10:25:39','2021-06-26','00:08:40'),(20,'09:28:02','09:31:18','2021-06-27','00:03:16'),(21,'21:49:26','21:50:50','2021-06-27','00:01:24'),(22,'09:42:08','09:43:27','2021-06-28','00:01:19'),(23,'12:52:21','12:53:33','2021-06-28','00:01:12');
/*!40000 ALTER TABLE `horas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_nomina`
--

DROP TABLE IF EXISTS `tipo_nomina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_nomina` (
  `id_nomina` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`id_nomina`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_nomina`
--

LOCK TABLES `tipo_nomina` WRITE;
/*!40000 ALTER TABLE `tipo_nomina` DISABLE KEYS */;
INSERT INTO `tipo_nomina` VALUES (1,'Obrero'),(2,'Empleado'),(3,'Comisión de Servicios');
/*!40000 ALTER TABLE `tipo_nomina` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-28 20:17:15
