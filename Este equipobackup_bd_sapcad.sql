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
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administradores`
--

LOCK TABLES `administradores` WRITE;
/*!40000 ALTER TABLE `administradores` DISABLE KEYS */;
INSERT INTO `administradores` VALUES (1,'root','1234',4),(2,'Admin','1234',1);
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
  `salida_default` time NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'Recursos Humanos','00:00:00'),(2,'Presidencia','00:00:00'),(3,'Dirección de Cronista','00:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (3,'Hedwin','Diaz',27169687,1,'Admin',2);
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados_horas`
--

LOCK TABLES `empleados_horas` WRITE;
/*!40000 ALTER TABLE `empleados_horas` DISABLE KEYS */;
INSERT INTO `empleados_horas` VALUES (1,27169687),(2,27169687),(3,27169687),(4,27169687),(5,27169687),(6,27169687),(7,27169687),(8,27169687),(9,27169687),(10,27169687),(11,27169687),(12,27169687),(13,27169687),(14,27169687),(15,27169687),(16,27169687),(17,271696877),(18,27169687),(19,27169687),(20,27169687),(21,27169687),(22,27169687),(24,27169687),(25,27169687),(26,27169687),(29,27169687),(30,27169687);
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horas`
--

LOCK TABLES `horas` WRITE;
/*!40000 ALTER TABLE `horas` DISABLE KEYS */;
INSERT INTO `horas` VALUES (1,'09:52:03','09:52:26','2021-06-12','00:00:23'),(2,'10:02:25','10:02:53','2021-06-12','00:00:28'),(3,'16:47:41','16:47:45','2021-06-14','00:00:04'),(4,'16:50:27','16:50:32','2021-06-14','00:00:05'),(5,'16:50:55','16:53:33','2021-06-14','00:02:38'),(6,'16:53:55','16:56:23','2021-06-14','00:02:28'),(7,'16:57:06','16:59:16','2021-06-14','00:02:10'),(8,'17:09:39','12:41:11','2021-06-14','04:28:28'),(9,'12:41:34','12:42:07','2021-06-16','00:00:33'),(10,'12:42:19','12:42:42','2021-06-16','00:00:23'),(11,'12:46:03','12:46:29','2021-06-16','00:00:26'),(12,'12:46:42','17:21:32','2021-06-16','04:34:50'),(13,'17:29:06','17:29:32','2021-06-19','00:00:26'),(14,'16:46:56','16:47:16','2021-06-23','00:00:20'),(15,'16:54:21','16:55:36','2021-06-23','00:01:15'),(16,'10:05:07','08:34:04','2021-06-25','01:31:03'),(17,'08:33:15','08:33:47','2021-06-26','00:00:32'),(18,'08:38:40','08:40:58','2021-06-26','00:02:18'),(19,'10:16:59','10:25:39','2021-06-26','00:08:40'),(20,'09:28:02','09:31:18','2021-06-27','00:03:16'),(21,'21:49:26','21:50:50','2021-06-27','00:01:24'),(22,'09:42:08','09:43:27','2021-06-28','00:01:19'),(24,'16:31:59','16:41:14','2021-06-29','00:09:15'),(25,'16:41:29','17:19:30','2021-06-29','00:38:01'),(29,'16:28:36','16:29:19','2021-06-30','00:00:43'),(30,'16:00:33','16:16:27','2021-07-03','00:15:54');
/*!40000 ALTER TABLE `horas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportes`
--

DROP TABLE IF EXISTS `reportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reportes` (
  `id_reporte` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  `reporte` longblob NOT NULL,
  `id_tipo_reporte` int(10) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_reporte`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportes`
--

LOCK TABLES `reportes` WRITE;
/*!40000 ALTER TABLE `reportes` DISABLE KEYS */;
INSERT INTO `reportes` VALUES (21,'Tipo_Nomina_Empleado_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 1359/Filter/FlateDecode>>stream\nx���\�RG�\��s\�\\�\�\��\�,\�NQ`\�ާ֖r��%R�\�\�:/��\�M\�}H��M\�pt�̷\�=\��y�\�0�imm�\�̚#\�\����\�\�\��1�*�\�]\�^���~\Z>�+_MW��=\������\�\��Լ\\�\�\�7�\�\�\�\�\����X�=���v�\�Լ]\\\\���>t��Z\�\�w[s�\�\�V��\�f�^m\�Wf47����p=\�{\�wG�>r\��͑\r�_~X\�m\�re\���]o\�\�,n\�nV\�r����\�ڳ\�\���ߛ׫\��Ƽ\\�>\�:�k�\�M�򍫻�m����#��u\�E�\���&\�\�\�\�.\�s\�\�T֤�j*�W�z|�Oۼ\�|XO\�\�C\�\�/�ٻ\�\�\�ۛ\�\�o�\�ye�\�\�vL\�j\�l�\�Ʒf��]�\�:?\�\�&��\�h�\�A�b�e1}J\��c�ʱ@�b�6b�J�H�X�Rlݖb�ʱ@\�X�Rl\�K�@\�X�r,P)6ԥX�r,P9�\�K%�T�*\��bm���ʱ@\�X�N��-�R)��T�mJ%�T�*\��b�RI!�c�ʱ@�\�X*)�r,P9�\�K%�T�*\��bm���ʱ@\�X�N��+�R)��T�mJ%�T�*\��b\�RI!�c�ʱ@�\�X*)�r,P9�\�K%�T�*\��b]���ʱ@\�X�N��+�R)��T�mK%�T�*\��b\�RI!�c�ʱB}�\�2\�4\�\�7̻4B�4\�\�>�_�\�\�?y�M#\�\�{\�\�i\\���\��<�/6��q�8����Y\�o֚1�jn+\��\�\� _a��\�,>\�C��\�ly1\�\��㧴���zg�	\�\\��k���.Ns��\�\�}l�蔻\�uӬ\r���\�)k��WY\�R���A�\'-���or�@��Atiw�	 \�C˪�Q��G��}hH�\"<���\�{�A��@<	\��A�\'/�\�m\rATG\�;\�� \�A \�\"��f��(�>tD:|:z�\"6�\�(숅ͮ\�-ZVP\�Du�\�*\��5�\�UH\�`�C\�e9�#\�\�%�u�4�\�1��\�eսUB8��\� \�� ʪ��͎A����\�_��������\�#!�S�D\�\�\�\�b\�\�\�\�\n�r@�\��ٵjd\�\�G~0@\�\��_\�`�#5{Dx�S!��p\�\�U0�pd�t`�%t�ٽb!\�qyRS�\�\�\�F@Q���z�H��]�F�����ʶ3�\�i:So\"�dG\�P�f/�Oڑi\� �\�W\�,� A��E 6�R(\"<i>Iヅǯ\�H��\�_��\�\�@\�K\�@�\���S�F\�y�W\�/�5�G/V��fW\��O��yrR�:��*\� \�A��R��\�`�\����I��{Du\�\��ZґA:|��6;Z�\�`\�HO\�\�&���#����g�Ԩٵ���]{�1�\�\�\�Ba\�\'{������1\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703113700-05\'00\')/ModDate(D:20210703113700-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001563 00000 n \n0000001656 00000 n \n0000000015 00000 n \n0000001744 00000 n \n0000001442 00000 n \n0000001795 00000 n \n0000001840 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<0483450fc68f155eb2ed9e27a8eba388><0483450fc68f155eb2ed9e27a8eba388>]>>\n%iText-5.5.12\nstartxref\n1998\n%%EOF\n',5,'2021-07-03'),(20,'Tipo_Nomina_Empleado_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 1137/Filter/FlateDecode>>stream\nx���\�r\�FE���Y\�23��s�\�t씊�I\�S�	KtQ�L*\��q\����`ڶ\�\�\�.W�(=..\�L��?N~m\'Ya*[�v=�f\��\�//�q޴\�\�_��p;��\�\'~<k?Нo��?��\�f~\�\�\�f\�.o�\��\\�Z��\�ի˟d����Y���ޛ��6�\�\�\�\�\����Ѳ�\�{s�?�\�\�~�\���\�\�tfۙ����\�\�o��\�b\�\n3\�?ʩ\�\�߾\�<\�ͺ7�\�7��1���m߭�\�\��wk����1/���\�\�<\�t����^���T�tE]T\�7쫼\�W\�ν��v�\�m\�:\�\�q?Jsg\\0���ңr\�S\�\�#ms�{��8m#\"�.;�x\�N\�L>\�\��N��mbg��4��Yf\n���aV_�C?Y�\�j?��\�\�~\"5X?sPM�ֲHWI[��-P\���mN��m��l��l��l�j\��lT�j�\���-P\��l\�d�c�@e[��-P��+)��-P\��\�֎�P\��l\��6Tc%�\�d�\�d�\�d[��R\��l\�d���R\��l\�d\�J\n�lT�j��c%�T�*\�5\�\�ђ*\��m�:\�f�XI!5\�\"5\�\"5ٖc%�T�*\�5\�c%�T�*\�\n�M�\�\�0\�1!�\��\�\�h(�2�\\��Sc�hPxr��nFC���%\r5q��\�\�Z!3ggt-&W\�v���\�3�+\���*\�\��/��,\�)UD.\�C���@Ou�w�\�0w��{�%\�\�0L#���MpM�U�\�aB\�\�\�R	M[\�\�چ��ɫ⻃H&=��QD��H\"�0Hy�\�\�D0�\�*&^�\�A�A��JA���A�K[_\"���T�xGa\�n�[$�Pe�8�`\�cՍU�s@�Ĺ�ٵj\� �qEܑQ��\�v�������\�G��+T+0�J\�M��\"q�\�A�P�f�\n��HƑI��)�$l+\�*v\n�\�RN=PR�5�V�D0�&(\�\�A4\"\�&�`I\�b\��)H��}$�`hGb����Jx*-x�J\"\�+	�ٕB\� ��u\�+Z0D#�P��\� �� �z<� 6;\"ׄZ=\Z9�F\�V}+pA�f�JW� 6��ZD0��qrR�Y�-�D:��b�d5lv�B�5\n\���1\��SK1H��߬�͎�&=�FpI\�ې\���$\�\�K}���R�5�f\�ACA�ٵ\�Q�Z-\"��f�\�#�[�6O\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703113636-05\'00\')/ModDate(D:20210703113636-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001341 00000 n \n0000001434 00000 n \n0000000015 00000 n \n0000001522 00000 n \n0000001220 00000 n \n0000001573 00000 n \n0000001618 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<7d1b174e87f2253887aa43dae883eb29><7d1b174e87f2253887aa43dae883eb29>]>>\n%iText-5.5.12\nstartxref\n1776\n%%EOF\n',5,'2021-07-03'),(23,'2021-06-01 2021-07-03_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 1408/Filter/FlateDecode>>stream\nx���KS[G����t(�\��r\�6h���r�%R�\�?οH\�\�6\�t����M\�pt\�on�<>\�~[\�R\�zߺ\�\�̻�З���*�\��#���\�]\�^���~Y~�\'_NO��-\�����ӓ\�\�\�{�p�\�oΗ���7�?)\�l���l���\��ӱ{�8;?=9<~:\�l}�\�\�\�\�h�ۭ�mo/6\�ۻ�[�\����p�ڏ.�|{\��;����~�\��\�==vt�\�_6�\�\�f�\�Ӯ�/��^Qlڡ\��/��\\�\����~�ۻյ�X��\�p�\�\\\�\�\r\r�i\�\�x\�\�\�\�=\�\���\�f��V�>��b9{7�<}G������7\�ˬ\�\�ɵ\r�<o]\�\�n=;1q>@5��\�\�\�<@�c�Y�T��\��c��\�Ub�*�@\�X�k�@�X�J,P�ئ\�+�H\�X�r,R9���X�J,P%�\�\�J\n�T�*\�\�ZI!Ub�*�@\�\�X+)�J,P%�\�%T��\�u�\�C���ʱH\�X�rlW+)�J,P%�\�\�J\n�T�*\�\�ZI!Ub�*�@\�\�X+)�J,P%��%T��\�u�MC���ʱH\�X�rl_+)�J,P%�\�\�J\n�T�*\�\�ZI!Ub�*�@\�\�T+)�J,P%��%T��\��c}���*�@�X�N����R9��T�mk%�T��\�*�]���\�@_��i>\����\�̓�ƋW\�\ZU\��t���\�Ü.��\�6Rn%�ۻ\�\�\�p�\�\��Y\�<_]o,c\�\�7���&T��/\�{K\��T\��X^,w���O4��~�\��B�\�\�_o�!jK�t�x\��\�\�đ���fm���툭M�,X?\�\�hd0H�\�Q�@!4��\0GcK@�C@z\��\�{�A�\'�c\�\� r\��\�QM \�\��\r�=4��f�C ȑ��\� \�! :�t�� \�\�\�j`iَ4&XZ\�\�bL���6;QV\�t�f\�\n�r0\�&\�f\� \�S�Ս\�X�\�tc���v0H�$>�ٵ\'\�0��hG��a\��  \�\�3��\�	�ٍ\�\�\�a%]@L\�<\��  \��\�nu\��\�\�D{xX�\�\�p\�Ҏ\'6\�\��f\� \�S�\�Vvv\���(���b�6;Q�5��\�Ce\�ꑔi�G 6�1[�<eXCe\�B�\n�r<�Fjv�\ZDyʁ�l\�tt�\�W;������<eW�\���lG3&��ltDIjv\�,\� \�Sβ���2�v��T�ud\�A-\��Az\�\�V5\n��a�c6^��X�L�3c{\�\��m�I]\�~\0Dy\�Lgb9bc�D9\n�=Y\��f7\nE@��\�\'t|�p�5T(\��\n�vH2�I�\�1���1\�\�( �����\�\�f�\�b�lvc�Dyh~\�\�\�p�\�H\�UL@��W-�\�\�f���P�P�Tz\�r�\�/^����x��=lv�=<,\�� ��vCjXZ\�Q��ԇ\�^\� jv+D@��@�٭\�M@L\�`��(\�\��\�>�(k��\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703153059-05\'00\')/ModDate(D:20210703153059-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001612 00000 n \n0000001705 00000 n \n0000000015 00000 n \n0000001793 00000 n \n0000001491 00000 n \n0000001844 00000 n \n0000001889 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<8062f5574e827ab388c4dda7e1f22c50><8062f5574e827ab388c4dda7e1f22c50>]>>\n%iText-5.5.12\nstartxref\n2047\n%%EOF\n',2,'2021-07-03'),(24,'2021-06-18 2021-07-03_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 958/Filter/FlateDecode>>stream\nx���_S\�8\�\��)�H�J��Gz�4\�v����\�6.�\�6a�3�\��{eݲlt�\�t\Z`��t|\�{u�x\�U�:ݨ~]huj��\���2V��\����)N\��\�׋�3�|3��\��?7���\�~yu�^-\�\�\�\�_\\��=�MV\�\��ղ_�m�\�B]/���˳�獖\�\�\��ߩ�\�~?�\�mכq�0�A\�\r\�\���v8e�5����)�Ӟ\�\��\�/w�h٠ތ믛�z��=O�_�s7�mk\Z\�t\�O\�W~����~lV?�\�a�S\�Q\�\��SNu��N\�ӝju=�=;\�\�ۏ�H\�ꈐ���\�E_�+�L?V�E\��Y\�V_��++\�\�t�ڕ���ڏŊE\�m\�j}K��\�-\rT�-ubM#\��m�ʶ@M���fl�ʶ@e[�&[\�\�l�ʶ@e[�N�u\�\�\�\"5\�\"5\�\"5ٶv\��lT�j��\�J\n�lT�j�us%�T�*\�5\�ڹ�B*\��m��l�lI�m�ʶ@�l��+)�&[�&[�&\�v���ʶ@e[�&\�f���ʶ@e\�L}?�ix\�QR�����>\"\�?�l\'�\���s��ɓ\�6%\r���74�\��[l�\�Z +�K���\�n#�\�ԥ��q\�\�|D�+�8\�\\DN���a�Lwu\�W�z�M\�\�ڏ�S|�黎u̘6Xt#\��\���\�\n�\��\�:з<RkA[� c�\��P\� \"\�#$#8�FA��\��� C�U�`\r\"u�p���AL05R{��H\n�3�L\�[$\'t*�CA\�-lo\n\�:D\�-�1�\��\�\�A$\�\�Pw0HN\�f\�`\"�Q�\�\�z\"�V�ぃH��\��1��Y)��\�.\n\�\�\�h\�`��B����\��\�\�!��\�q��1�y�h\� QSi	�\�A2\"5��*1�م\�\� C�\�,=yD$� mɉtj	\�8q6;�9C\rB��{D$\�<�r\"���u-lv$c\�mI\�	��\�&��r��\�ɨ�Y��4�\�%�1��]\ZoD$�X($#\�dw?\�ȿ���\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154007-05\'00\')/ModDate(D:20210703154007-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001161 00000 n \n0000001254 00000 n \n0000000015 00000 n \n0000001342 00000 n \n0000001040 00000 n \n0000001393 00000 n \n0000001438 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<9841f9b1beb84331a350f8eae2063979><9841f9b1beb84331a350f8eae2063979>]>>\n%iText-5.5.12\nstartxref\n1596\n%%EOF\n',2,'2021-07-03'),(25,'2021-06-18 2021-07-03_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 958/Filter/FlateDecode>>stream\nx���_S\�8\�\��)�H�J��Gz�4\�v����\�6.�\�6a�3�\��{eݲlt�\�t\Z`��t|\�{u�x\�U�:ݨ~]huj��\���2V��\����)N\��\�׋�3�|3��\��?7���\�~yu�^-\�\�\�\�_\\��=�MV\�\��ղ_�m�\�B]/���˳�獖\�\�\��ߩ�\�~?�\�mכq�0�A\�\r\�\���v8e�5����)�Ӟ\�\��\�/w�h٠ތ믛�z��=O�_�s7�mk\Z\�t\�O\�W~����~lV?�\�a�S\�Q\�\��SNu��N\�ӝju=�=;\�\�ۏ�H\�ꈐ���\�E_�+�L?V�E\��Y\�V_��++\�\�t�ڕ���ڏŊE\�m\�j}K��\�-\rT�-ubM#\��m�ʶ@M���fl�ʶ@e[�&[\�\�l�ʶ@e[�N�u\�\�\�\"5\�\"5\�\"5ٶv\��lT�j��\�J\n�lT�j�us%�T�*\�5\�ڹ�B*\��m��l�lI�m�ʶ@�l��+)�&[�&[�&\�v���ʶ@e[�&\�f���ʶ@e\�L}?�ix\�QR�����>\"\�?�l\'�\���s��ɓ\�6%\r���74�\��[l�\�Z +�K���\�n#�\�ԥ��q\�\�|D�+�8\�\\DN���a�Lwu\�W�z�M\�\�ڏ�S|�黎u̘6Xt#\��\���\�\n�\��\�:з<RkA[� c�\��P\� \"\�#$#8�FA��\��� C�U�`\r\"u�p���AL05R{��H\n�3�L\�[$\'t*�CA\�-lo\n\�:D\�-�1�\��\�\�A$\�\�Pw0HN\�f\�`\"�Q�\�\�z\"�V�ぃH��\��1��Y)��\�.\n\�\�\�h\�`��B����\��\�\�!��\�q��1�y�h\� QSi	�\�A2\"5��*1�م\�\� C�\�,=yD$� mɉtj	\�8q6;�9C\rB��{D$\�<�r\"���u-lv$c\�mI\�	��\�&��r��\�ɨ�Y��4�\�%�1��]\ZoD$�X($#\�dw?\�ȿ���\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154150-05\'00\')/ModDate(D:20210703154150-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001161 00000 n \n0000001254 00000 n \n0000000015 00000 n \n0000001342 00000 n \n0000001040 00000 n \n0000001393 00000 n \n0000001438 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<e95f2b707916eef9494815f28f784ec8><e95f2b707916eef9494815f28f784ec8>]>>\n%iText-5.5.12\nstartxref\n1596\n%%EOF\n',2,'2021-07-03'),(26,'_Hedwin Diaz_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 780/Filter/FlateDecode>>stream\nx���\�R\�0�\��{I/p%Y�\�]\n�\�aH|\�1ą0�)q:\��{\�w\�\�\�\0�v\rt��a9�ttV�\�}����\n�A=�\�\����D�TPÏ\�\��&:������|ӯ�\��\�\r�\�u4\�\�\�9W0��\�\�j|t6z7�iu1�\�\�߫\�\�pQMg��\��e��fu�m\r���\�\Z�\�ϗ��_�\�ƀ\�eVfE�2񟏊x$\�\�\'��\�\\ov\�\�-\�n�Mg@\�-hXa\�p�\���E�k\�\�K�\0�\��\�v\�\�M�n�\�|\r,7$0�\�t��%�\�r�\'%�\�[���\�\��U�?��8���(\��� t��*`\�F3/\�R\�%��2\�wN\�BŒU�-\�o\'ʌ�eTo˨ޖQ��C��\�m\�\�2��zȖQ�-�z[F\�mӢ�\�Tg˩ΖS�m��l\�\�2��eTg���z[F���\�l�PKq��eTo˨\�V\r��z[F���zi��e?�\�7p�\�\�\�ճzp\�^\�6v�\��y��2Ɓ>�\�ӎ�j�áF��1>˓�f��@-\�X��8�\�\n��\�\�\�;m��z\�\\5w��.\\���*�ֶ��Pd�*Y\�~�\�3�0Ia� �V���#-LZ��\�$E#��\�(�� #���IK6E�\�$\��\rB\����$g��(�*�`l�H$Y_$$0H��b���xs��Fc\�\�!�[���6�4JsAr\�!�\�\�W+<y6I$�*�}I4�����@|�����\�\��и-��>H@\� ��)D���0n[ჄD�\�5	\�Z�Ap2\n\�Q\�e�L|��� x\����DI6��D��\'�\0��%�\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154833-05\'00\')/ModDate(D:20210703154833-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000983 00000 n \n0000001076 00000 n \n0000000015 00000 n \n0000001164 00000 n \n0000000862 00000 n \n0000001215 00000 n \n0000001260 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<4476a205e721dd9f404eaf5968df183b><4476a205e721dd9f404eaf5968df183b>]>>\n%iText-5.5.12\nstartxref\n1418\n%%EOF\n',3,'2021-07-03'),(16,'_Hedwin Diaz_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 1410/Filter/FlateDecode>>stream\nx���KO\\G���+zIL�u�;�Ǳ#6\�>\Z�	`\�Y\�?\�\"�!շ\�Su\Z���-c\�|��\�[Տϳ���Ժ޷ny>�n?�\�_�[�F�*\�ۋ\�ޯ\��\�\�\'z�\��������uxr�<=9r�\�\�\�\�\�rq|��\�Y�.ޝ�.\�>��w\�\�-N\�N����:\�\�|خG�f}�\�\�ֽ�Z��4t�\��׫\�\�.�C\�wO��\�ɥx����\�\��?y��[]��\�lW�х\�.]\�\�\r\�]Ӻ\�3���\�\�\�n}��x\���t��f{�v\�\��vu�q+w�ٹ\�\��^\�\�\�\�f�s]yx�1<z\�b9{?�<��\��\�\�3?oܗY\�ϓk�3�筋�ۮgg\"�!\��ơ���}���--,�ְ�\�Ul�ʶ\�\�l�*�@[���\�5[��-P\���m\��[��-R\��l\�Ś-P\��bT�mj%�T��\��ms���*�@[��m��R\��bT��Ւ�\�Ul�:\�\�VRHe[��-Rٶ��R\��bT�mk%�T��\��ms���*�@[��m��R\��bT�\rՒ�\�Ul�:٦�VRHe[��-Rٶ��R\��bT�mk%�T��\��ms���*�@[��m��R\��bT�\rՒ�\�Ul�ʶ�ZR@[��-P\'\�\�\�J\n�l�T�E*۶��B�\�Ul���ܗ\�t�/\�4\�\�\�\��\��g\���\�媜�\��\��ч9] �\�\�\�\�\\�wt�0\���>�ɳ\���\�\�\�}c��w��]\�\�/rA��\�Շ\�\'\Z\�N?}�\�}��\�r\�\��\�~�\Z	C�n�?�M}2fm���M\�\�M�,X�\�O4<8H�/��@&4�DcK�(B��(���\�dD1�s7\�\0� .A�A�1�)H3�\�\r��\�\�PD$\�sMH#:\��˃(��\��Ҳ�4&XZ��S1&TZM�Q�\�$Z�u%�\"8\�&\�f\�AS�Ս\�X�$�Ic���&8H�(H|y�k&P�aL��Hk\��\�A�(\�gz�7`��%A\�\�JFt	b��˃Q7�\�US�<�f�A4\�\�\n�� \"\�UKOl���͎�(���\�숈Ft	�	b�����\�q\���� �\�\�*��&�GR�Uɰٍْ �)\�\Z*�\"*A�\�I�٭j� �)��1� &\�U�_MH�Fj�JŔ]�VGxֲ�fL8�\"JZ�\�%\r�٭�,\�L9\�6\�b\�A4\��R�\����T0ңf��Q�(����\�%�Ed:�ۛ\�\�\�hCL\�\��� ��72�9`���y� �(A\�\�\� \rlv�P$�b\�|B\��_��B�\�W�h��$sy\� 	6;��0\��\\\Z%�E���1�D\�\�]�R�\�n̖Q\�o99�1�d^\�$�&x\�2���x\�\�pC\�5J�G,��~񪥈d�\�o\�a�\� �\�aY1\�\r�M`ii�}�����t�\�-	�\nB\�nmo\�$�P$�\"xg\�_��\0\�\'\�\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703112556-05\'00\')/ModDate(D:20210703112556-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001614 00000 n \n0000001707 00000 n \n0000000015 00000 n \n0000001795 00000 n \n0000001493 00000 n \n0000001846 00000 n \n0000001891 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<93395af410016b142fc6c0c8760aac3b><93395af410016b142fc6c0c8760aac3b>]>>\n%iText-5.5.12\nstartxref\n2049\n%%EOF\n',3,'2021-07-03'),(27,'2021-06-26 2021-07-03_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 779/Filter/FlateDecode>>stream\nx����R\�0�\�~\n\�!�$˶�[\ZL�\�$��\�1\�@��\'f�\�}��,\r\�hהaH~}���W�\�\�K�dӼ`�2\�l$��\��`B��>r?\�mr��_�\�{\���\���\���\�d6�\�sv\\��\�lQW\�\�\����\�\�\�l^W\�\r\�\�\�E5_̦\��\�\�\�j�\�l�\�v�c�Y�\�;e\r[7즽�kv�I.ň#Y�QxS�x���\�\�\�lk\�i�|Zm\����65����n���)t��B�\��#�����f͖-�\�v.�`wL�8(�;l\�\���\�n�W�\�$��\�\�\�N.�\��W�o�\�ׄ�9{J�N3V\�pz�҂Iͺ6YQ�\ZR�������L�z[��^bK���P�-�z[ɇl	5\�j�%To\�Ր-�[B\r��\�\�\�Z\�R���ToK�޶�C��\Zl	5\���͇Z�R�-�[B��j��(5\�j�%To+�Z�R�-�\�H�tߜ�0n\�d���.`\n>�\Z~G\'n��\�\�\�z\�E\n\�*^\n�э\�j�\�%Bf����&\�z��J\�)\��y,�v|F�J37\�C�ꮹj\�\�T�xw\�����~�*�aT?\��m��\�HՌ\�\'B(ns���G&0�[.�@D\�����(ln\� !s�!D.^,�>\�\� %$b��RC�\� �	��!HL@�\�E\�\rw�VA\�\�A�Z��.��RQAJEA��D\�WIx�d�\�,V�$&� iF$\'/;�� \Z��#(�\�XH}C��pA�9D���1�X�\�D	ŵ\�ZA`2rA�\�e\�LB��� p\�3����A%��D8�c �\0*\�V\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154919-05\'00\')/ModDate(D:20210703154919-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000982 00000 n \n0000001075 00000 n \n0000000015 00000 n \n0000001163 00000 n \n0000000861 00000 n \n0000001214 00000 n \n0000001259 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<736e22c3428972db35dc90933c6bb475><736e22c3428972db35dc90933c6bb475>]>>\n%iText-5.5.12\nstartxref\n1417\n%%EOF\n',2,'2021-07-03'),(28,'Tipo_Nomina_Empleado_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 807/Filter/FlateDecode>>stream\nx���\�R\�0��~\n-\�\"��\�\�ڥ�:L���\r�Ibp\�a�o\�u_�W���H\�)�aH�>����\�\�\�K��(����(1e��|\�㤸��\�Ow}��ק\�v�\�w\��\�F�\�5�ϊ\���\�d�<[�lz6� �E~1_�۽\�\�9�\�\��lr~\�hQ\�6\�]גi\�u���\�TM�\�դ$��\�\�\�w\�VN9\�t\�S2ro\�#*o_4-�j2��n6�&��aU�U{���G;k\�W_�Ӻzj6\�)����+H\�\�,\�R5��s\r,I���{}^��re\�x\�v\�<�#�@I	�\�Ц{��-�r��n�P t\��\�Et=���|�O�F4N\�S�T,H\�R¨�S\�\�\�h\�D��8CU��\�/�J\�c��֖R\'\�*\�Q�-�:[D\�m%l1\�\�b��\�Tk��![Du��\�l\�\�&|\�Q�-�:[D��\"�ETg��\�Q�-j)Lu��\�l\�\�\���BTg��\�Q{[��Z\nS�-�Z[_�4Ox\�3nD��0\\֯�\�щy��\�\�\�zNY\�\�_\n�ь\�|�\�\�*@\nFcX��\�rՄ@ɒ�&�y,��|F����w\� GEW^����\�\�\�\�\��\�\�#,��T\�g�\�BiIU˲~\�Iu��\�\�X���r\�D$Q黃����:ɰ A�\'Z\�\'L�p�l���i?�A<�f�+(\Z$D��\�D@�� �|�aZB���\"h�@}]�0A�\�\"$P-\�c���\�ɣA��Сb� >\�a�f�A8z\��\�1pA�Q\�H����uA<\�\�4K� �\�x��_+D� >1�\�j���G@���!Ad�]���\r\�3.�@\�H�Ȃ�b���9\n�\�?~�9�\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154939-05\'00\')/ModDate(D:20210703154939-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001010 00000 n \n0000001103 00000 n \n0000000015 00000 n \n0000001191 00000 n \n0000000889 00000 n \n0000001242 00000 n \n0000001287 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<6736ee8b81b9ef55c731c4b564445ac1><6736ee8b81b9ef55c731c4b564445ac1>]>>\n%iText-5.5.12\nstartxref\n1445\n%%EOF\n',5,'2021-07-03'),(29,'Departamento_Recursos Humanos_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 832/Filter/FlateDecode>>stream\nx���\�N\�0�\���d/��_R\�w\�RV��6��@�\r$E+\�\�[\�86�L\�.A9�\�\�\�\�c�LT\�\�Y�L8\���z\"������\��69������P���v¨Ԩg�W\��lZ\�g\�\�x\�F��E9��\�F\�\� P��\�R#\�\n�\�\�l^N\�W�O\�\�b2_̦��\�r�׈7�\�\�U�k6nڶ\��\�rUow5�غb7��]\�Y&��d\�\�\�p�\�^^��q�P��j%\�\���S\�5;}\�Tۦ�������M�\�4��\�z�k�eǫ\��\�\��\��i]A��\"/r3��`Ȓl��\�訖ͮZ�e\�\�\�\�`wL�\r<(�Vt\�w\��^\�\�땣\r	`\�d�L.�\��G��\�\�	O3�+1&U,9\\�9���u��(dZ��,��R5�� Uo\�yaUlK���P�-����\�l)\�\�R���To��C��\Zl	5\���\�\�![B\r��\Zl	\�۪��-�[B\r��\�m\�#E���P�-�z[~�Hj�%\�`K���6���z[J���z\�^Ң0nܨ���`�l\����r�Λ����U��F������Oa-M.��\n�\�R�!\�\�Xv�w\�\"u�ܼ39*\�ꪺ��\�\�\�\�\�ܫ��\�Q\�~�\�3\�Xe�\�H׊��t��\�\Z�L`�\\Z�}�\�\�3�[�۬����̬B$&\\�Y>\�p�_�\� \�+\r4��J��\rAb�(\�$ӟ3\�jȂ�� ��\�B��D�\"�\�Te� H�B����j	;OA	e�f� 1\�\�a�A$y\�$�� pP\��\��XHC��pA\n+2*\'/;$b�caDCh�U�ъ��\"�.�ˎ�� 1A\�+�\�D�$&܎p8���\�W5\�\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154945-05\'00\')/ModDate(D:20210703154945-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001035 00000 n \n0000001128 00000 n \n0000000015 00000 n \n0000001216 00000 n \n0000000914 00000 n \n0000001267 00000 n \n0000001312 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<c7debfed39da960718362d93bc3ecc57><c7debfed39da960718362d93bc3ecc57>]>>\n%iText-5.5.12\nstartxref\n1470\n%%EOF\n',4,'2021-07-03'),(22,'Departamento_Recursos Humanos_Empleado_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 1349/Filter/FlateDecode>>stream\nx���[SI�\�\�W\�#>0[����0.n�üo�\�\�0�3F\�ߪ\�\\e\�<�l��ӧ��\�\�\���\��\�,Ԧ��Y]Ϭ9tm�\�o��qެ>�\�_��\��_?�\�\�\�c��\�t�ǹ\�\�\���:�8_-/\�\�\�\�]��\\-Ώ\����\�\�\�\�r��\�\�wg\�\�byyq~t�|\�r�Y\�v[s�\�\�\���\�\�z=nF3���|�n�}o��\�\�և.�C��9�\��˟���\�\�p�.�\�\�r���\�o�\��\���\�\���\�\r>\�޿O7�7�\��\��Ɯ���`�\�GBk�Ԯ��\�>w\�z4�\�]�\�Ι[SYs��+�W��4�h��n\�\\��-�Сu\�\�/V�w�\�\�o�L?�cf\��:k\�y0u�\�\�8��o\�n�]�\�:?\�\�&��\�h�\�A�b\��It�T�*\��b�/\��c�ʱ@�b��.\�\"�b�J�H�\�Ɩb�ʱ@\�X�RlK�@\�X�r,P)6�J\n�T�*\��RI!�c�ʱ@�X[,)�r,P9�Sl\�J%�T�E*\�\"�b�RI!�c�ʱ@�تTRH\�X�r,P)6�J\n�T�*\��RI!�c�ʱ@�XW,)�r,P9�Sl\�J%�T�E*\�\"�b�RI!�c�ʱ@�غTRH\�X�r,P)6�J\n�T�*ņRI!�c�ʱ@�XW,)�r,P9�S�\�J%�T�E*\�\"�b\�RI!�c�ʱB}�\�\�4\�\�7̻4\�\�4\�?\Z�^\�w�<����\�\�u�4\�ϟ��<�\�\�\�n�V��\�y�,v^wk\�]5��b��j��0�%}��8y⮳\�`�\�Ӫ��\�ͣ��O���UNZ\\�+<�\�c\�G�ܵ�\�C/rT\nt\�2�8�\��oeUb\�\�A�\'-���o pA��A�	�j�\��� \�C˪�\���HG��}hH\�_\"<���\�{�A��@<�ꗃO^V\�\�\Z����w��A��@�E �\�\�.=.Qt}\� �t�t6�N9D8lL\�Q\��]�[\"<����3�\��U�jv��\�\�f\� \�C\�rxG�#\�SK:D\�	$v�\�!��\�eսUB9��N \�� ʪ��͎A����\�_��������\�#!�S�԰ٕ�\� �\�N-\�(�\�s;Q�k\�\� ��`� ��)�\�� pG<j���\�B:ᬥ;�>`\�\� \��F#Jt�ٽba\�qyRS\�\�\�F@��\�RN=P&�Сfת�@�\'/��\��:b�Δ\��(z��\���	/��#\�\�A4��\�Y�A�#�\�7�@j\�\�J�0���$���#�vD:HP�/m?\0\"=���z42�\�ȃ�rD8�\�=z�\n6�r�Dx\��͓�\�`\�\�W1�:��b$�>�\'5H*�B�h�<�\�SK:2H��\�`a�c\�ei���4Lm�KK8�\��PyVM �Eͮ���$�\�\�\�\�@tG�\n�H=\�\�ϑ\0�\'\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703113755-05\'00\')/ModDate(D:20210703113755-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001553 00000 n \n0000001646 00000 n \n0000000015 00000 n \n0000001734 00000 n \n0000001432 00000 n \n0000001785 00000 n \n0000001830 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<5ac9d802f507f76efcecca4297016f9d><5ac9d802f507f76efcecca4297016f9d>]>>\n%iText-5.5.12\nstartxref\n1988\n%%EOF\n',6,'2021-07-03'),(30,'Departamento_Recursos Humanos_Empleado_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 793/Filter/FlateDecode>>stream\nx���OO\�@\�\��s����ώ��L�B	$�W�\"1\�AH����W@�3�T��\"H���fgǏѷ2\�)d\"�r	\�\����X�TP^\�O\�\�\�D??����Õov���}u�xΦ\�|vGL�����N>\�j^�\�\�e�\�\��\�΋�b6���o4�oVݶm\�iۺ{h6\�U�\�\�P�}\��\�m\�YPBɑHG*���2	���G�C\�n�5.\�X�\�WOm\�tp�6M�>�7xڬ/�N\�\��jG�\�\�_\�qI�߻*\�ݲ\�V���\�i]�%܂�5\�\"\�Q�\��N:ܹzs�rt\�Թٿ�(��\�q�Q���8�\�(\�b\r�6 ��SP�u��\�U���\�\���S�P�d\�\�\�eJ\�2��eTo˨��PC��\�m\�\�2\�\�6\�\�[N\�m9��\�\�\�v,�l\�\�2��e\�\�61C��\�m\�\�2jo��Z�S�-�z[F\�m\�PKq��eTo˨��l)F���\�m�\�=�\�n��q�\�O���~3��\��\�\�8o�WB\�x$\�\�Op4�Yl�m�$H-E�\��䢺_Q��I,|\�n�\�\�Q&\�nޥ9(\�겺û\�\�\�s\��{k�>FCD\�ƍ���ՙ5��Z���CF\�$#B\�I�V(+	�\"\�ǃ�V�6\�\� ��	\�	�.\�.H�\�\��K�1$dDnU�ゐ��d}� �A4֋2V2\�\Z\�B�� �`k��A\��V.H�rA�j� ��5\nw�\rB\�R\��ABbD\�\�1\�a\'$`��`��g�$\�Q_$ \\�\�ʄ�\�\�\�	���(\�	�1\�j���\�d�\"�\�N�� �A�k���DN6�nG��\'~��0�\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154953-05\'00\')/ModDate(D:20210703154953-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000996 00000 n \n0000001089 00000 n \n0000000015 00000 n \n0000001177 00000 n \n0000000875 00000 n \n0000001228 00000 n \n0000001273 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<0edc0768e2fc59b52a2b36cb6b56db7e><0edc0768e2fc59b52a2b36cb6b56db7e>]>>\n%iText-5.5.12\nstartxref\n1431\n%%EOF\n',6,'2021-07-03'),(31,'Registro_3-7-2021_.pdf',_binary '%PDF-1.4\n%\�\�\�\�\n3 0 obj\n<</Length 300/Filter/FlateDecode>>stream\nx���\�N�0\�\�}�9\�l�|\�\r�fI�л���e1&��oaqq\�M�h\�Cۙ��;\�yE\�Q<\�\0��A�asqC�X�7�j�]�\�\��p��\'M.�\�Z�x\��\�(>I�Y\��,��AP\�gic���\�5�}L\�\�:\�9�(�8;\�Sk�Y\Z$uG\���Te�\�¶\�\���md��^��Z�F=<\n�\�\Z�\�,\��,\�	5XvI\�\�{��+%߫�J|,G���։[.q�ϝE\�Ԥ\�\�[\�Qo�\�N�T���R��\�c\�S\n��u�7\�e�\0�\�E=��`\�Ol߾��ɝ*^l\�yUG�\�G\�!\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText� 5.5.12 �2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703161703-05\'00\')/ModDate(D:20210703161703-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000503 00000 n \n0000000596 00000 n \n0000000015 00000 n \n0000000684 00000 n \n0000000382 00000 n \n0000000735 00000 n \n0000000780 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<e9b88fe4672736204e9a4400d5fab91e><e9b88fe4672736204e9a4400d5fab91e>]>>\n%iText-5.5.12\nstartxref\n938\n%%EOF\n',1,'2021-07-03');
/*!40000 ALTER TABLE `reportes` ENABLE KEYS */;
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
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_nomina`
--

LOCK TABLES `tipo_nomina` WRITE;
/*!40000 ALTER TABLE `tipo_nomina` DISABLE KEYS */;
INSERT INTO `tipo_nomina` VALUES (2,'Empleado'),(3,'Comisión de Servicios');
/*!40000 ALTER TABLE `tipo_nomina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_reporte`
--

DROP TABLE IF EXISTS `tipo_reporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_reporte` (
  `id_tipo_reporte` int(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipo_reporte`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_reporte`
--

LOCK TABLES `tipo_reporte` WRITE;
/*!40000 ALTER TABLE `tipo_reporte` DISABLE KEYS */;
INSERT INTO `tipo_reporte` VALUES (1,'Diario'),(2,'General'),(3,'Individual'),(4,'Por Departamento'),(5,'Por Nómina'),(6,'Por Departamento y Nómina');
/*!40000 ALTER TABLE `tipo_reporte` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-03 18:03:33
