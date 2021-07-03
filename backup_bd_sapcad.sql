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
  `salida_default` time NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'Recursos Humanos','00:00:00'),(2,'Presidencia','00:00:00'),(3,'Direcci√≥n de Cronista','00:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados_horas`
--

LOCK TABLES `empleados_horas` WRITE;
/*!40000 ALTER TABLE `empleados_horas` DISABLE KEYS */;
INSERT INTO `empleados_horas` VALUES (1,27169687),(2,27169687),(3,27169687),(4,27169687),(5,27169687),(6,27169687),(7,27169687),(8,27169687),(9,27169687),(10,27169687),(11,27169687),(12,27169687),(13,27169687),(14,27169687),(15,27169687),(16,27169687),(17,271696877),(18,27169687),(19,27169687),(20,27169687),(21,27169687),(22,27169687),(24,27169687),(25,27169687),(26,27169687),(29,27169687);
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horas`
--

LOCK TABLES `horas` WRITE;
/*!40000 ALTER TABLE `horas` DISABLE KEYS */;
INSERT INTO `horas` VALUES (1,'09:52:03','09:52:26','2021-06-12','00:00:23'),(2,'10:02:25','10:02:53','2021-06-12','00:00:28'),(3,'16:47:41','16:47:45','2021-06-14','00:00:04'),(4,'16:50:27','16:50:32','2021-06-14','00:00:05'),(5,'16:50:55','16:53:33','2021-06-14','00:02:38'),(6,'16:53:55','16:56:23','2021-06-14','00:02:28'),(7,'16:57:06','16:59:16','2021-06-14','00:02:10'),(8,'17:09:39','12:41:11','2021-06-14','04:28:28'),(9,'12:41:34','12:42:07','2021-06-16','00:00:33'),(10,'12:42:19','12:42:42','2021-06-16','00:00:23'),(11,'12:46:03','12:46:29','2021-06-16','00:00:26'),(12,'12:46:42','17:21:32','2021-06-16','04:34:50'),(13,'17:29:06','17:29:32','2021-06-19','00:00:26'),(14,'16:46:56','16:47:16','2021-06-23','00:00:20'),(15,'16:54:21','16:55:36','2021-06-23','00:01:15'),(16,'10:05:07','08:34:04','2021-06-25','01:31:03'),(17,'08:33:15','08:33:47','2021-06-26','00:00:32'),(18,'08:38:40','08:40:58','2021-06-26','00:02:18'),(19,'10:16:59','10:25:39','2021-06-26','00:08:40'),(20,'09:28:02','09:31:18','2021-06-27','00:03:16'),(21,'21:49:26','21:50:50','2021-06-27','00:01:24'),(22,'09:42:08','09:43:27','2021-06-28','00:01:19'),(24,'16:31:59','16:41:14','2021-06-29','00:09:15'),(25,'16:41:29','17:19:30','2021-06-29','00:38:01'),(29,'16:28:36','16:29:19','2021-06-30','00:00:43');
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
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportes`
--

LOCK TABLES `reportes` WRITE;
/*!40000 ALTER TABLE `reportes` DISABLE KEYS */;
INSERT INTO `reportes` VALUES (5,'Registro_30-6-2021_.pdf',_binary '%PDF-1.4\n%\‚\„\œ\”\n3 0 obj\n<</Length 339/Filter/FlateDecode>>stream\nxúµí\ÀRÉ0Ü˜<\≈YÍÇöã–ê\“8e\Ï@Ö\Ïù(i\≈APä:\„˚ÜV\ƒ^úNΩ¿\…˘˛¸?\Á\—:ìuÅ!df!∞1kN\Œ1`rf>µ´û[GWx\À;Cû/\ÈF3:`¥\Ô%É8íI<Åë\0?\rS)¢ Ùª^˚£kE¿tÄùmB\"¶q\"åB?	\„uêyõ¿T$i˘ìû∫\"°µ<æ\0ı<_4uAU\◊zÒPïYÆ\ÀFÉÇB¡L\ﬂ\‹*ŸÆM¡>w˛1\’j∞KT\›_c\∆:{\…K\Â\ÍuWñ=\∆9b\◊s\Ÿp£√°\ ˙\·\"[\√5ÆjôQ6µ\ ªú0nF≥´§™»ªÇ«± ´Fm©\›bå7˜)˝¸ï+U¥w≤I\ÂB?õP|c∂> ó1\«s–ØS!àc¬©∑ïJ[†\∆˛w©Ù£¯\„TÑ¥.≠w¸\–i\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iTextÆ 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210630201306-05\'00\')/ModDate(D:20210630201306-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000542 00000 n \n0000000635 00000 n \n0000000015 00000 n \n0000000723 00000 n \n0000000421 00000 n \n0000000774 00000 n \n0000000819 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<2a8ad7f5cf364b79257b796b263695ad><2a8ad7f5cf364b79257b796b263695ad>]>>\n%iText-5.5.12\nstartxref\n977\n%%EOF\n',1,'2021-06-30'),(7,'_Hedwin Diaz_.pdf',_binary '%PDF-1.4\n%\‚\„\œ\”\n3 0 obj\n<</Length 1393/Filter/FlateDecode>>stream\nxúΩóKS[GÖ˜˙≥$îy\›\Áé`9vä¥O…ë∏\0\≈)W\Âgëˇêû\€Ç\È>ÉIπvst\Óôon˜<>\Õ~X\ŒR\Îzﬂ∫\Âz\Ê\›a\Ë\Àﬂø.D∑¸ï~Uæwó≥Éüø\·\◊wÀèÙ\‰\À\È\ÈèsˇMsˇ\·\Î¯\Ïty~v\‚^-\‹\—\≈€ã\Â\‚Ù¯\Ì\—7ã:_º;;_.æ|:˝\ÔƒΩ[ú_úùù<u∫Ω˝∞€å\Ó\Õf˝˘˙ŒΩ∫^˝Òº\È¯\œı\Ô7´\—\≈.¥C\€w\œ;˛\ÁW•?íKÒ|QOQ’ìa{˙\‰\Âˆ~u\„\÷wµ›≠ˆ£¡]π∆ª[öª¶u˚Øx\ƒ˘\Ê∑\Ì\Ó~\„.7wõ\›jΩu+w≥›ª\‰\›˙Ø’ûû}\„n7{◊ñî\ËcxÚ\ƒ\≈rˆ~ˆi˙\›OÙ\€g~ﬁ∏œ≥æü\'\◊6Ñ\ÂÛºu±wª\Õ\ÏB\ƒ0\ƒ˘\0\’8tÙ/R≥èÛ\0Ué•ée1¥F,P%®TéçæTâ™\ƒïc}Æ\≈UbÅ*±@ùbõæØ\ƒ\"ïcë ±H\Â\ÿ.\÷bÅ*±@ïX†rlS+)§J,P%®õk%ÖTâ™\ƒïcc≠§ê*±@ïX†r¨ØñP%®\‘)6µíB*\«\"ïcë ±]≠§ê*±@ïX†rl[+)§J,P%®õk%ÖTâ™\ƒïcc≠§ê*±@ïX†rl®ñP%®\‘)6\rµíB*\«\"ïcë ±}≠§ê*±@ïX†rl[+)§J,P%®õk%ÖTâ™\ƒïcS≠§ê*±@ïX†rl®ñP%®Téı’í™\ƒUbÅ:\≈∆æVRH\ÂX§r,R9∂≠ïR%®´\‘˜\ÂJ¶Ûπ√¶˘@G»ñÆ∑∑èn!Ø7ø\\≠\ Yü¯è>}ò\”\rB˛\r]@\ aqwO∑√ôÇü\”g±Ûbusmsh\Êæ1åóüÚÑ}1>Xbûßrø\»\≈r∞‹≠>¨>“®ˆ˙ÈÉü\Ó˝ìgóõŒ°oC‘ñ0\‰\ÈÒ\‘„á±â£O∆¨\r\√t≥∞±5†\Èï\À\·G˙çâÒ\Â \ (ÑÜ\’@\‡håa	àrHè@¸”∑˝\0í!àÚÑv\Ã›òA]@îÉAº1™	§¸ãA¥áÜ\’\–lu9íÒ\÷D;\ƒ@gê.øDyxX\r,-€ë\∆KK;¸Tå	ïV\”¿f\« \ \√√™Äòé\÷l]QÅ=\“d\ÿ\ÏDy ∞∫\—kêÄòéap\’\“	Åƒó7ªˆ¢\∆4@Ìà¥6å¡XD9|¶\◊Qy#6ª1[¢<<¨d†àÈ†ù\«XD9∏Ÿ≠Æö@Ú\0õÇh+¿7ÇÆZ\⁄ÒÃÜò;\ÿ\ÏDy ∞\⁄\ Œé\—@\ÂcT\“\¬f\« \ \√√≤\ÊW@¥£c®\Ï#\⁄A=í2≠Ú$\√f7fK@îßk®¨Z\»QQé\Á\ﬁHB\ÕnU£Ä(O9pîçÇòéÆ≤¸jáÄ¿7P≥W@îß\Ï\n¥:¬≥ñ\Ìh∆ÑAî£Ä–Ççé(i@\ÕnùeD{\ Y∂1S\—ﬂóä∑éÄb8®•Çπ†0Hèö›™FQû2¨~\Ã\∆kÀë\Ètflo¢º≥£\r1©K\€WÄ(Ωë\È\ÃA,GlÃ≥ÄÄ(G±\'ãA\Z\ÿ\ÏF°àÚ\–˘Ñé.ø¶É\n≈ö_\—I\ÊÚ¿ 	6;—û0\Ê¡\\\Z\ƒrîÉø1ø¢\‹\Ï]¨RÄ\ÕnÃñÄ(\Õo991…ºä	àv™e#Éx\ÿ\ÏpC\‘j*îJèXér˙≈´ñrê/ø±á\ÕA¥ááe9\ƒp\–nHmKK;\ —ó˙\–ÿ´§C\ÕnÖàÚ5ªµΩ	à\È\ÃB\Â\‡ù=ˇ≥è¸\r\ =\ﬁ\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iTextÆ 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210630201416-05\'00\')/ModDate(D:20210630201416-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001597 00000 n \n0000001690 00000 n \n0000000015 00000 n \n0000001778 00000 n \n0000001476 00000 n \n0000001829 00000 n \n0000001874 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<ad73bed4fd89436b9f669475754be5b7><ad73bed4fd89436b9f669475754be5b7>]>>\n%iText-5.5.12\nstartxref\n2032\n%%EOF\n',3,'2021-06-30');
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
INSERT INTO `tipo_nomina` VALUES (2,'Empleado'),(3,'Comisi√≥n de Servicios');
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
INSERT INTO `tipo_reporte` VALUES (1,'Diario'),(2,'General'),(3,'Individual'),(4,'Por Departamento'),(5,'Por N√≥mina'),(6,'Por Departamento y N√≥mina');
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

-- Dump completed on 2021-07-01 10:47:09
