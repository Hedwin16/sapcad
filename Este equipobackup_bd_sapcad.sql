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
INSERT INTO `departamentos` VALUES (1,'Recursos Humanos','00:00:00'),(2,'Presidencia','00:00:00'),(3,'DirecciÃ³n de Cronista','00:00:00');
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
INSERT INTO `reportes` VALUES (21,'Tipo_Nomina_Empleado_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 1359/Filter/FlateDecode>>stream\nxœ½—\İRG…\ïõs\é\\ \Ì\ßş\Ş,\ÇNQ`\ÃŞ§Ö–r„%R®\Ê\ç:/™\í¶M\Ô}H¹‚M\ÙptöÌ·\Ó=\Ûûyö\Ë0µimm†\åÌš#\×\æÿüü\Ê\ç\Íğ1ı*ÿ\Ù]\Í^üş¿~\Z>¥+_MW˜û=\Íü‡¯“ó³\á\âüÔ¼\\˜\ã\Ë7—\Ã\â\ì\ä\ÍñŠºX¼=¿ÿ¾vú\éÔ¼]\\\\ŸŸ>t±ºZ\ï\ïw[s²\İ\íVû»\íf¹^m\îWf47£ù¸úp=\î{\ã­wG¶>r\ÑñÍ‘\r_~X\ßm\Íre\Îş¾]o\Æ\Ş,n\ïnV\ãrû¸óÿ\İÚ³\í\íû„ß›×«\å—õÆ¼\\>\î:ùkù\ÇM¢ò«»ºm°¯ò#¡µu\îE\Ûûñ&\ß\Ç\ë\í.\ï‡s\æ\ÚTÖ¤›j*³W®z|¼OÛ¼\Ú|XO\Û\é¡C\ë²\Ã/†Ù»\Ù\ç\éÛ›\ß\Òo\Ùye¾\Ì\ÚvL\íj\ãlœ\×Æ·f·š]²\è:?\ï \ê»&ı‹\Ôhı\ÜA•b­e1}J\Æ•cÊ±@b«6b‘J±H¥X¤Rlİ–bÊ±@\åX Rl\åK±@\åX r,P)6Ô¥X r,P9¨\ëK%…T*\Ç•bm±¤€Ê±@\åX N±±-•R)©‹TŠmJ%…T*\Ç•b«RI!•cÊ±@¥\ØX*)¤r,P9¨\ëK%…T*\Ç•bm±¤€Ê±@\åX N±¡+•R)©‹TŠmJ%…T*\Ç•b\ëRI!•cÊ±@¥\ØX*)¤r,P9¨\ëK%…T*\Ç•b]±¤€Ê±@\åX N±¾+•R)©‹TŠmK%…T*\Ç•b\ëRI!•cÊ±B}—\ß2\İ4\â\æ7Ì»4B†4\Ş\Ş>À_¼\Ê\ï?yúM#\ïƒ\Ï{\ë\æi\\–Ÿ\Æó<¦/6÷»q©8ƒ³óôY\ì¼oÖš1ºjn+\Åø\í\Õ _aŸ\ß,>\ÎC¸\Ûly1\ì\Æ÷ã§´ª½¼zg§	\Ú\\ûûkŸ´¸.Nsõ¡\Ç\Õ}lúè”»\ÖuÓ¬\r•¶\Ì)kûüWY\ÕRµõ³A¤\'-«²½or@¤ƒAtiwû	 \ÂCËª”Q¡‚G¦ğ}hHŸ\"<´¬ˆ\ê¨{A„ƒ@<	\íóA„\'/«\ém\rATG\×;\ÅÁ \ÂA \Î\"ÿüf——(º>tD:|:z§\"6¦\í(ìˆ…Í®\Ü-ZVP\ĞDuø\Ş*\Çƒ5»\ÖUH\ì`³C\é¡e9¸#\È\á©%¢u4°\Ù1ˆğ\äeÕ½UB8¼‚\Î \ÂÁ Êª¤‚ÍA„‡–¥\İ_‘¦÷®ğ‘\Ô#!¦SD\Ø\ì\Ê\İb\á\É\Ë\ê\n§r@„\ã±ñ¨Ùµjd\á\ÉG~0@\Õ\Ñ_\é`¸#5{DxòS!p\Ö\ÒU0ˆpdt`£%t¨Ù½b!\éqyRS‘\Û\æŠ\×F@Q©¥œz Hƒš]«F¼¬¶Ê¶3ˆ\æˆi:So\"ôdG\ÄP£f/€OÚ‘i\æ€ š\ÃW\ê,À Â‘Aô›E 6»R(\"<i>Iãƒ…Ç¯\êH…¢\İ_‘\Ô\ã@\ÄK\Û@¤\Çõ±SF\ÑyğW\î/ƒ5»G/VÁÁfW\îƒOº¿yrR¢:‚ú*\Æ \ÒA§–RŒˆ\ï`³\Ã¢ô¤I…‚{Du\ä\éZÒ‘A:|üú6;Z–\æ`\éHO\Ã\Ô&°´¤#¾©•gÔ¨Ùµ’š]{¼1ˆ\ê\è\ÔBa\á \'{üúù‚°³1\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703113700-05\'00\')/ModDate(D:20210703113700-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001563 00000 n \n0000001656 00000 n \n0000000015 00000 n \n0000001744 00000 n \n0000001442 00000 n \n0000001795 00000 n \n0000001840 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<0483450fc68f155eb2ed9e27a8eba388><0483450fc68f155eb2ed9e27a8eba388>]>>\n%iText-5.5.12\nstartxref\n1998\n%%EOF\n',5,'2021-07-03'),(20,'Tipo_Nomina_Empleado_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 1137/Filter/FlateDecode>>stream\nxœ½–\Ër\ÛFE÷üŠY\Ê23ƒÁs§\Ètì”Š²I\ìS°	KtQ¤L*\åªüq\Öùô`Ú¶\Â\î\Ú.Wô(=..\îL÷ ?N~m\'Ya*[˜v=±f\êªø\Ë//œqŞ´\ï\é_ñóp;¹ø\ã\'~<k?Ğo‡»?õı\êf~\à\ã\êf\Ñ.o®\Íó¹¹\\½Zµó\ÅÕ«ËŸdµœ¿¾Y¶óÿŞ›şº6¯\ç\Ë\Õ\Í\âòú¼Ñ²¿\İ{sµ?ú\ã\Ã~·\Şô»\Ç\ŞtfÛ™÷ı»»\î\Øo½›\Úb\ê\n3\å?Ê©\Í\Îß¾\İ<\ìÍº7‹\î7»®1óû‡mß­÷\ç\Éÿwkûû·¿1/ûõ§\Í\Î<\ßt§®ş^ÿ¹¥T¾tE]T\å7ì«¼\ÄW\á¤Î½¨óvÿ\Øm\ã:\Ş\íq?Jsg\\0´¦ñÒ£r\×S\ã\Ë#ms¿{·‰8m#\"´.;½x\ŞN\ŞL>\ß\ŞüNÿımbg¹ù4©ªYf\nº»³aV_™C?Y±\èj?«¡\ê\ë’~\"5X?sPM¶Ö²HWI[ ²-P\Ù¨ƒmN»‡m‘šl‘šl‘šl‹j\Ì¨lT¶j²\Íı˜-P\Ù¨l\Ôd›c¶@e[ ²-P“­+)¤²-P\Ù¨\ÉÖ–P\Ù¨l\ÔÁ6Tc%…\Ôd‹\Ôd‹\Ôd[•R\Ù¨l\Ôd›•R\Ù¨l\Ôd\ÆJ\n©lT¶j²õc%…T¶*\Û5\Ù\ÚÑ’*\Û•m:\ØfõXI!5\Ù\"5\Ù\"5Ù–c%…T¶*\Û5\Ùc%…T¶*\Û\nõMœ\Í\İ0\Ä1!›\Õô\â\Íh(¸2¶\\¼ˆScœhPxr½·nFC†¼ş%\r5q¸™\ï\İZ!3ggt-&W\İv£Á\å3›+\à—*\Ş\áÁ/ˆ³,\Î)UD.\ÚC÷¶û@Ou”w¯\í0wø“{–%\â\ê0L#§ŒóMpM”U«\ëaB\Ñ\ß\ØR	M[\æ\ÂÚ†¾²É«â»ƒH&=–«QD‚H\"ñ0Hyº\Û\ßD0ñ±Š\Æ*&^‰\ÎAÁA”§JAòğıA“K[_\"‰²ñTŒxGa\Õn“[$«Peµ8ˆ`\âcÕU¢s@ŒÄ¹ñ¨Ùµj\ä ‚qEÜ‘Q‰²\Ñvƒ‚ƒÀ±¨\ÙG‚†+T+0ˆJ\äM†ƒ\"q\ËAP£f÷\n’‚HÆ‘I®¦)ˆ$l+\Ş*v\n¢\ÔRN=PR5»VD0ñ±ª&(\Û\ÎA4\"\Ø&¯`I\Ğb\Ñ¯)Hš}$ˆ`hGb­À÷ˆJx*-xüJ\"\Ñ+	°Ù•B\á ‚±u\ã+Z0D#¨P´õ\å ’  ™z<¤ 6;\"×„Z=\Z9ˆF\äV}+pA¤f÷JW¥ 6»²ZD0´¾qrR¢Y£-‘D:µ”b‚d5lvøB”5\n\î• 1\ÓÁSK1Hß¬„Íƒ&=–FpI\ĞÛ\Ú––$\â\èK}¨¼«R5»f\ÂACA¨Ùµ\×Q‰Z-\"ˆôfŸ\ß#ÿ[ø6O\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703113636-05\'00\')/ModDate(D:20210703113636-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001341 00000 n \n0000001434 00000 n \n0000000015 00000 n \n0000001522 00000 n \n0000001220 00000 n \n0000001573 00000 n \n0000001618 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<7d1b174e87f2253887aa43dae883eb29><7d1b174e87f2253887aa43dae883eb29>]>>\n%iText-5.5.12\nstartxref\n1776\n%%EOF\n',5,'2021-07-03'),(23,'2021-06-01 2021-07-03_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 1408/Filter/FlateDecode>>stream\nxœ­—KS[G…÷ú³t(óº\ÏÁr\ì6hŸ’rŠ%R®\Ê?Î¿H\Ï\í6\ÆtŸÁ¤ŒM\Ùpt\î™on÷<>\Ï~[\ÎR\ëzßº\å\ÅÌ»ƒĞ—ÿüú*¸\İò#ıªü\Ù]\Î^üù¿~Y~¢\'_NO˜û-\Íı¯£Ó“\å\Ù\é±{¹p‡\çoÎ—‹“£7‡?)\êlñöôl¹øş\ÙôÓ±{»8;?=9<~:\èl}¹\Ù\ß\í¶\îh»Û­÷mo/6\ëÛ»µ[¹\ë•û¸şpµÚ.ú|{\àƒ;ºŸ~ü\Éö\æ==vt¯\×_6·\î\åfõ\ÏÓ®£/ş¾^QlÚ¡\í»˜/ı‘\\Š\å»ú‰ª~–Û»Õµ»X»«\í®p†\à®\\\ã\İ\r\rµi\İ\Şx\ì\ã\ä\Ã=\Í\ßúö\Ãfš§Vù>şğb9{7û<}G÷ıö÷™Ÿ7\îË¬\ï\çÉµ\rø<o]\ì\İn=;1q>@5ı‹\Ô\ì\ã<@•c©Y­T‰ª\Ä•c£¯\ÅUb*±@\åXŸk±@•X J,P§Ø¦\ï+±H\åX¤r,R9¶‹µX J,P%¨\Û\ÔJ\n©T‰*\Ç\æZI!Ub*±@\å\ØX+)¤J,P%¨\ë«%T‰ª\ÄuŠ\ÍC­¤Ê±H\åX¤rlW+)¤J,P%¨\Û\ÖJ\n©T‰*\Ç\æZI!Ub*±@\å\ØX+)¤J,P%¨ª%T‰ª\ÄuŠMC­¤Ê±H\åX¤rl_+)¤J,P%¨\Û\ÖJ\n©T‰*\Ç\æZI!Ub*±@\å\ØT+)¤J,P%¨ª%T‰ª\Ä•c}µ¤€*±@•X N±±¯•R9©‹Tmk%…T‰ª\Ä*õ]¹¬†\é@_÷i>\Ğ²¥‹\ëÍƒûÆ‹W\å\ZU\ÎútÀğù\èÃœ.úó¯\é6Rn%‹Û»\İ\ê\Âp¦\à\çôY\ì<_]o,c\Í\Ü7†ñş&T°/\Æ{K\ÌóT\î¹X^,w«÷«O4ª½~ú\à§ûBÿ\è\Ù_o!jKòt‹x\ìñ\Ã\ØÄ‘¯˜fm¦›…íˆ­M¯,X?\Ò\ßhd0HŒ\ÏQ@!4¬‚\0GcK@”C@z\â¿\í{A”\'´c\î\Æ r\è¢\âQM \Í\àŸ\r¢=4¬†f«C È‘Œ·\Î \Ú! :ƒtùù \Ê\Ã\Ãj`iÙ4&XZ\Ú\á§bL¨´š6;QV\Ät´f\ë\nˆr0\ì‘&\Ãf\Ç \ÊS†Õ\ŞXƒ\Ätc€«–v0Hğ$>¿Ùµ\'\Å0¦‚hG¤µa\Æò  \Ê\á3½\Ê	°Ù\Ù\å\áa%]@L\í<\Æò  \ÊÁ\Ínu\Õ’\Ø\ìD{xX¾\ä\Èp\ÕÒ\'6\Ä\ÜÁf\Ç \ÊS†\ÕVvv\äˆº€(‡€£b6;Q–5¿¢\İCe\Ñê‘”i•G 6»1[¢<eXCe\ÕB\nˆr<õFjv«\ZDyÊ£l\Ätt•\åW;¾‘€š½¢<eW \ÕµlG3&¢„ltDIjv\ë,\Ë \ÚSÎ²¹˜2ˆvø¾T¼ud\ÃA-\Ì…Az\Ô\ìV5\nˆò”aõc6^»€XL§3c{\í\àmˆI]\Ú~\0Dy\èLgb9bcD9\nˆ=Y\ÒÀf7\nE@”‡\Î\'t|ğpù5T(\Öü\nˆvH2—I°\Ù1ˆö„1\æ\Ò( –£üù\å\àf\èb•lvc¶Dyh~\Ë\É\Épˆ\éH\æUL@´ƒW-£\Ä\Ãf‡¢öPƒP¡Tz\Är”\Ó/^µ”£€xù=lv¢=<,\ËÁ †ƒvCjXZ\ÚQ¾Ô‡\Æ^\Å jv+D@”‡@¨Ù­\íM@L\Ç`Š€(\ï\ìù\ë>ò(kÿˆ\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703153059-05\'00\')/ModDate(D:20210703153059-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001612 00000 n \n0000001705 00000 n \n0000000015 00000 n \n0000001793 00000 n \n0000001491 00000 n \n0000001844 00000 n \n0000001889 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<8062f5574e827ab388c4dda7e1f22c50><8062f5574e827ab388c4dda7e1f22c50>]>>\n%iText-5.5.12\nstartxref\n2047\n%%EOF\n',2,'2021-07-03'),(24,'2021-06-18 2021-07-03_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 958/Filter/FlateDecode>>stream\nxœ­–_S\Û8\Å\ßı)ôHğJ²üGz£4\İv‡šø½\ã6.¤\É6a§3ı\Æı{eİ²lt\ét\Z`€ÿt|\ä{uó¥x\ÙU£:İ¨~]hujºø\Ç¯2VõŸ\è­øµ¿)N\Şÿ\Æ×‹ş3­|3­ş\Ô÷?7õ¯ó«\Ë~yu¡^-\Ô\Ù\ê\íª_\\¿=ûMV\Ë\ÅõÕ²_ümú\ïB]/–««Ë³‹ç–\ã\Í\æğ°ß©ó\İ~?ş\Şm×›qû0ªA\İ\r\ê\Óøñv8eµ5§º‰ô)ÿÓ\ê\êù\å/w÷hÙ ŞŒë¯›­zµ¾=O_ÿs7mk\Z\ßt\íO\ìW~‰µú¨~lV?ı\îa¸S\ëQ\İ\îöSNu«ªN\İÓju=ö=;\Ğ\îÛ›H\ÓêˆŠ÷ø\âE_¼+¾L?VıE\ïşY\è²V_‹®++\Õ\ÔtûÚ•²ÚÅŠE\ãm\é¡j}K¿‘\ê´-\rT“-ubM#\Ø•mÊ¶@M¶ôğflÊ¶@e[ &[\í\ælÊ¶@e[ N¶u\×\Í\Ø\"5\Ù\"5\Ù\"5Ù¶v\Î¨lT¶j²­\çJ\n©lT¶j²us%…T¶*\Û5\ÙÚ¹’B*\Û•mšlõlI•mÊ¶@lŸ+)¤&[¤&[¤&\Ûv®¤Ê¶@e[ &\Ûf®¤Ê¶@e\ÛL}?™ix\ÄQR•«†>\"\İ?™l\'¯\ãÀs…†É“\ë­6%\r¢üú74÷\âü[lö\ÃZ +£Kº“«\án#\ÎÔ¥®ğq\æ\Æ|D¬+«8\Ë\\DNúığaøLwu\ÈW÷zšM\İ\ÑÚŸS|ï¦‰uÌ˜6Xt#\ìš÷\Ó“‰\Ê\n¡\é‘\Ğ:Ğ·<RkA[Á cš\àšP\ã \"\Ñ#$#8ˆFAôñ\Óş‰ C·U»`\r\"u¨pŒˆAL05R{‚H\n’3†L\ê [$\'t*´CAÂ„\Ê-lo\n\Ò:D\Ø-’1ñ¶º\à„\Ç\ÎA$\Â\éPw0HN\Ğf\Ù`\"©Q³\Ï\Éz\"±V„ãƒH„¥\Ò’1ˆ¼Y)ˆƒ\Í.\n\É\íƒ\íh\Ã`‰ B‘ö—ƒ\ä©\Ä\ã!±°\Ùqœ1Áyñh\ä QSi	û\ËA2\"5»º*1°Ù…\İ\â Cû\ë,=yD$ª mÉ‰tj	\Å8q6;ˆ9C\rB…‚{D$\İ<µr\"ñøøu-lv$c\ÒmI\É	š†\Ô&°´r‚‚\ĞÉ¨…Y•‚4¨\Ù%’1„š]\ZoD$¼X($#\Òdw?\æÈ¿»š¡\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154007-05\'00\')/ModDate(D:20210703154007-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001161 00000 n \n0000001254 00000 n \n0000000015 00000 n \n0000001342 00000 n \n0000001040 00000 n \n0000001393 00000 n \n0000001438 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<9841f9b1beb84331a350f8eae2063979><9841f9b1beb84331a350f8eae2063979>]>>\n%iText-5.5.12\nstartxref\n1596\n%%EOF\n',2,'2021-07-03'),(25,'2021-06-18 2021-07-03_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 958/Filter/FlateDecode>>stream\nxœ­–_S\Û8\Å\ßı)ôHğJ²üGz£4\İv‡šø½\ã6.¤\É6a§3ı\Æı{eİ²lt\ét\Z`€ÿt|\ä{uó¥x\ÙU£:İ¨~]hujºø\Ç¯2VõŸ\è­øµ¿)N\Şÿ\Æ×‹ş3­|3­ş\Ô÷?7õ¯ó«\Ë~yu¡^-\Ô\Ù\ê\íª_\\¿=ûMV\Ë\ÅõÕ²_ümú\ïB]/–««Ë³‹ç–\ã\Í\æğ°ß©ó\İ~?ş\Şm×›qû0ªA\İ\r\ê\Óøñv8eµ5§º‰ô)ÿÓ\ê\êù\å/w÷hÙ ŞŒë¯›­zµ¾=O_ÿs7mk\Z\ßt\íO\ìW~‰µú¨~lV?ı\îa¸S\ëQ\İ\îöSNu«ªN\İÓju=ö=;\Ğ\îÛ›H\ÓêˆŠ÷ø\âE_¼+¾L?VıE\ïşY\è²V_‹®++\Õ\ÔtûÚ•²ÚÅŠE\ãm\é¡j}K¿‘\ê´-\rT“-ubM#\Ø•mÊ¶@M¶ôğflÊ¶@e[ &[\í\ælÊ¶@e[ N¶u\×\Í\Ø\"5\Ù\"5\Ù\"5Ù¶v\Î¨lT¶j²­\çJ\n©lT¶j²us%…T¶*\Û5\ÙÚ¹’B*\Û•mšlõlI•mÊ¶@lŸ+)¤&[¤&[¤&\Ûv®¤Ê¶@e[ &\Ûf®¤Ê¶@e\ÛL}?™ix\ÄQR•«†>\"\İ?™l\'¯\ãÀs…†É“\ë­6%\r¢üú74÷\âü[lö\ÃZ +£Kº“«\án#\ÎÔ¥®ğq\æ\Æ|D¬+«8\Ë\\DNúığaøLwu\ÈW÷zšM\İ\ÑÚŸS|ï¦‰uÌ˜6Xt#\ìš÷\Ó“‰\Ê\n¡\é‘\Ğ:Ğ·<RkA[Á cš\àšP\ã \"\Ñ#$#8ˆFAôñ\Óş‰ C·U»`\r\"u¨pŒˆAL05R{‚H\n’3†L\ê [$\'t*´CAÂ„\Ê-lo\n\Ò:D\Ø-’1ñ¶º\à„\Ç\ÎA$\Â\éPw0HN\Ğf\Ù`\"©Q³\Ï\Éz\"±V„ãƒH„¥\Ò’1ˆ¼Y)ˆƒ\Í.\n\É\íƒ\íh\Ã`‰ B‘ö—ƒ\ä©\Ä\ã!±°\Ùqœ1Áyñh\ä QSi	û\ËA2\"5»º*1°Ù…\İ\â Cû\ë,=yD$ª mÉ‰tj	\Å8q6;ˆ9C\rB…‚{D$\İ<µr\"ñøøu-lv$c\ÒmI\É	š†\Ô&°´r‚‚\ĞÉ¨…Y•‚4¨\Ù%’1„š]\ZoD$¼X($#\Òdw?\æÈ¿»š¡\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154150-05\'00\')/ModDate(D:20210703154150-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001161 00000 n \n0000001254 00000 n \n0000000015 00000 n \n0000001342 00000 n \n0000001040 00000 n \n0000001393 00000 n \n0000001438 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<e95f2b707916eef9494815f28f784ec8><e95f2b707916eef9494815f28f784ec8>]>>\n%iText-5.5.12\nstartxref\n1596\n%%EOF\n',2,'2021-07-03'),(26,'_Hedwin Diaz_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 780/Filter/FlateDecode>>stream\nxœ½•\İR\Û0…\ïı{I/p%Yş\Ó]\n¦\ĞaH|\ß1Ä…0ù)q:\Ìô{\Ñw\è\Ê\Ò\0v\rt˜†a9şttV«\Í}ô©’\n‘A=\Ê\ÂşññD‚TPÃ\ì\Ïö&:øú¯õ®|Ó¯ş\Ü÷\É\rş\áu4\×\Ó\É9W0š\Í\êj|t6z7«iu1™\Ö\Õß«\ã\çpQMg“ñ\èüe«ñfuµm\rœ¶ó‡\Å\Z\ÍÏ—¡£_ó\ËÆ€\ÊeVfEş2ñŸŠx$\İ\ï\'ô…\í­\\ov\Í\æ-\Ün¶Mg@\Â-hXa\åpı\îŒºE·k\×\×K¯\0¦\í÷\Ív\×\ÂM»n·\Í|\r,7$0ÿ\İt¸“%¬\Úr»\'%”\Ü[°ª£\Ë\è¾ÿUğ?ı‰8…‡¨(\â²‹ tœ*`\ÛF3/\ÊR\Å%«ª2\ÇwN\ÕBÅ’U-\Şo\'ÊŒ°eToË¨Ş–Q­C¶Œ\êm\Õ\Û2ª³zÈ–Q½-£z[F\ímÓ¢°\åTgË©Î–Sm®†l\Õ\Û2ª·eTg›µ§z[Fõ¶Œ\êlõPKqª·eToË¨\ÎV\rµ§z[Fõ¶zi¿e?\ì7p—\Ø\Ò\ÓÕ³zp\Ò^\ß6vö\àÀyö¼2Æ>Š\ãÓ¬j½Ã¡F‰1>Ë“³f¹ @-\ÓX¤ø8º\í\n¥\ã\Ä\Î;m‘ƒz\Û\\5w¸«.\\½ıü*öÖ¶“÷Pd‡*Y\ê~ª\í3¢0Ia´ ªV–ı¤#-LZ¡ñ\È$E#”‘\á‚(õö #…‘™IK6E¨\Ô$\áƒ„\rB\Ëû§ı$gƒŒ(*°`lŠH$Y_$$0H‚õb‚¤¥xs‚‘Fc\Â\Ä!‰[‹¨¯6ˆ4JsAr\Í!ª\åƒ\ÖW+<y6I$†*–}I4£’²—@|€Á‚\Â\ß’Ğ¸-¢¾>H@\Ø ¥‘)D³—0n[áƒ„D\Å5	\ßZAp2\n\ÉQ\Üe§L|€Á x\ÙşDI6ŠöDö£\'ş\0¦ %•\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154833-05\'00\')/ModDate(D:20210703154833-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000983 00000 n \n0000001076 00000 n \n0000000015 00000 n \n0000001164 00000 n \n0000000862 00000 n \n0000001215 00000 n \n0000001260 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<4476a205e721dd9f404eaf5968df183b><4476a205e721dd9f404eaf5968df183b>]>>\n%iText-5.5.12\nstartxref\n1418\n%%EOF\n',3,'2021-07-03'),(16,'_Hedwin Diaz_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 1410/Filter/FlateDecode>>stream\nxœ½—KO\\G…÷ó+zILúuŸ;‚Ç±#6\Ì>\Z›	`\ÏY\Ê?\Î\"ÿ!Õ·\ÊSu\Zˆ¬€-c\Î|÷ô\é[ÕÏ³Ÿ–³ÔºŞ·ny>ón?ô\å‡_¢[şF¿*\ßÛ‹\ÙŞ¯\ßñ\ë‡\å\'zò\Åôô‡¾ÿº¹ÿğuxr¼<=9r¯\î\à\ì\í\Ùrq|øö\à»Y.Şœ.\ß>şw\ä\Ş-N\ÏN¶:\Ş\Ü|Ø®G÷f}ş\å\êÖ½ºZıù4tø\×ù×«\Ñ\Å.´C\ÛwOÿó«\ÒÉ¥x¾©§¨\ê\ÉÀ?y¹¹[]»óµ»\ÜlW»Ñ…\à.]\ã\İ\r\Í]Óº\İ3ñ—ƒ\İ\Õ\în}ûñªx\Åüôtıûf{·v\ë\Ûõvu¾q+w½Ù¹\ä\Îÿ^\í\è‘\×\îf½s]yxô1<z\àb9{?û<ı\îú\í\Ï3?oÜ—Y\ßÏ“kš3Ÿç­‹½Û®gg\"†!\Î¨Æ¡£‘š}œ¨²--,†Ö°ª\ØUlÊ¶\Ñ\×l*¶@[ ²­\Ï5[ Š-P\Å¨“m\Ó÷[¤²-R\Ù©l\ÛÅš-P\Å¨bT¶mj%…T±ª\Ø•ms­¤*¶@[ ²m¬•R\Å¨bT¶õÕ’ª\ØUl:\Ù\æ¡VRHe[¤²-RÙ¶«•R\Å¨bT¶mk%…T±ª\Ø•ms­¤*¶@[ ²m¬•R\Å¨bT¶\rÕ’ª\ØUl:Ù¦¡VRHe[¤²-RÙ¶¯•R\Å¨bT¶mk%…T±ª\Ø•ms­¤*¶@[ ²mª•R\Å¨bT¶\rÕ’ª\ØUlÊ¶¾ZR@[ Š-P\'\Û\Ø\×J\n©l‹T¶E*Û¶µ’Bª\ØUl•ú¾Ü—\Ãtü/\ä4\è\Ù\Ò\İù\æÁg\ïõú\ãåªœõ\é€ÿ\àóÑ‡9] ô\ç\ß\Ğ\í¦\\·wt‰0\Èüœ>‹É³\Õõ•\æ\Ğ\Ì}c€÷wò„]ï‘˜\ç©\Ü/rAö–\ÛÕ‡\Õ\'\Z\ÕN?}ğ\Ó}¡ô\ìr\Ó\Ù÷\í~ˆ\Z	Cn?ŒM}2fm¦›…M\Ä\ÖM¯,X„\éO4<8HŒ/¢˜@&4¬DcK‚(B‚ô(ˆü¶\ïƒdD1¡s7\æ\0ƒ Âˆ.AÁA¼1ª)H3ø\Ñ\r«¡\Ù\êPD$\ã­sMH#:\éòËƒ(†‡\ÕÀÒ²‰4&XZšğS1&TZM›Q«\Ä$Z³u%ˆ\"8\ì‘&\Ãf\ÇAS†Õ\ŞXƒ$ˆIc€«–&8Hğ(H|y³k&PŠaL¢‰Hk\ÃŒ\åA‚(\Âgz•7`³³%A\Ã\ÃJFt	b´óËƒQ7»\ÕUS<Àf‡A4\Ã\Ã\nğ \"\ÃUKOlˆ¹ƒÍƒ(¦«­\ììˆˆFt	¢	bŒŠƒ´°\Ùq\Åğ°¬ù• š\è\Æ*ûˆ&¨GR¦UÉ°ÙÙ’ Š)\Ã\Z*«\"*Añ\ÔI¨Ù­j” Š)²1À &\ÑU–_MHøFjöJÅ”]VGxÖ²‰fL8ˆ\"JZ°\Ñ%\r¨Ù­³,\ÑL9\Ë6\æb\ÊA4\áûRñ\ÖƒµT0Ò£f·ªQ‚(¦«³ñ\Ú%ˆEd:Û›\Ñ\ï\ìhCL\ê\ÒöŒ Š¡729`‹ˆy Š(A\ì\É\â \rlv£P$ˆb\è|B\Ç—_“ B±\æW‚h‚‚$sy\à 	6;¢™0\æÁ\\\Z%ˆE”ƒ¿1¿D\Ü\ì]¬R€\ÍnÌ–Q\Ío99„1‰d^\Å$ˆ&x\Õ2Š‘ƒx\Ø\ìpC\Ô5J¥G,¢œ~ñª¥ˆdÀ\Ëo\ìa³\Ã š\áaY1\Ú\r©M`ii¢}©½Šƒt¨\Ù-	¢\nB\Ínmo\Ä$³P$ˆ\"xg\Ï_÷‘\0\ß\'\á\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703112556-05\'00\')/ModDate(D:20210703112556-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001614 00000 n \n0000001707 00000 n \n0000000015 00000 n \n0000001795 00000 n \n0000001493 00000 n \n0000001846 00000 n \n0000001891 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<93395af410016b142fc6c0c8760aac3b><93395af410016b142fc6c0c8760aac3b>]>>\n%iText-5.5.12\nstartxref\n2049\n%%EOF\n',3,'2021-07-03'),(27,'2021-06-26 2021-07-03_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 779/Filter/FlateDecode>>stream\nxœ­•ÁR\Û0†\ï~\n\é!®$Ë¶¤[\ZL¡\Ã$ø\Ş1\Ä@˜\'fú\Æ}‹®,\r\Ğh×”aH~}úõ¯W›\Ç\äKdÓ¼`õ2\ál$´û\çó‰`B²ú>r?\İmrôı_Ÿ\ê{\Øù¶\ßıµ\ï‹û\×d6­\ç³sv\\±ñ\âlQW\Ó\É\Ùøƒ¬\æ\Õ\Ål^W\ï\r\ï\Î\ÙE5_Ì¦\ãó·\æ\í\íj·\ï¶l²\íºv÷c»Y®\ÚÍ¾e\r[7ì¦½¾kv–I.Åˆ#Y°QxSxööö\Ó\í\Ãlk\Ùi»|Zm\Øñªùõ65ù½ü¹nÀ¶…)tùõB–\ä‡ı#£ş©·ûfÍ–-»\Ûv.§`wL±8(À;l\Ó\ßñª\×n®W\Ö$€õ\î\á\âªN.“\ÇşW²oğ\é×„§9{J´N3V\äpz®Ò‚IÍº6YQ™\ZR•¦„¿”ª¸L©z[¸ˆ^bK¨Á–Pƒ-¡z[É‡l	5\Øj°%To\ËÕ-¡[B\r¶„\Ú\Û\æZ\ØRª·¥ToK©Ş¶”C¶„\Zl	5\Øª·Í‡ZŠRƒ-¡[Bõ¶j¨¥(5\Øj°%To+‡ZŠRƒ-¡\ÛH½tßœ¢0n\Üd©–.`\n>¼\Z~G\'n¦»\Ù\ç\Õz\ÉE\n\Ã*^\n£Ñ\Èj³\ïš%Bf‚§°–&\Íz…J\ä)\Ïğy,»v|F¤J37\ï”Cê®¹j\î\áT»xw\Ãûù¥ö~ù*‹aT?\Õ®m¦­\âHÕŒ\é\'B(ns„†G&0‚[.­@D\Ê÷‰Á­(ln\È !s›!D.^,„>\í\ç %$b¸±RCÁ\È ‘	´¾!HL@\êE\É\rw„VA\Ä\ÄA‰Z©¯.ˆ°RQAJEAª‚D\ÔWIxòd”\È,V¬$&ú iF$\'/;‚„ \Z…¾#(¡\àXH}CˆpAŒ9D‘—1şX‚\ÄD	Åµ\İZA`2rA‘\Ôe\ÇLBˆ p\Ù3ú „A%‰÷D8ôc ş\0*\İV\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154919-05\'00\')/ModDate(D:20210703154919-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000982 00000 n \n0000001075 00000 n \n0000000015 00000 n \n0000001163 00000 n \n0000000861 00000 n \n0000001214 00000 n \n0000001259 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<736e22c3428972db35dc90933c6bb475><736e22c3428972db35dc90933c6bb475>]>>\n%iText-5.5.12\nstartxref\n1417\n%%EOF\n',2,'2021-07-03'),(28,'Tipo_Nomina_Empleado_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 807/Filter/FlateDecode>>stream\nxœ½•\ÍR\Û0…÷~\n-\é\"®ş\ì\ÈÚ¥Á:L‰÷ƒ\r˜Ibp\Òa¦o\Üu_ W–†ŸH\×)¦aH>œ««\ë\Ç\èK‰”(š’¢Š(1eşù|\Âã¤¸\ÌOw}ÿÀ×§\âv¾\íw\íû\âFş\á5ÏŠ\Åüœ\çd²<[ùlz6ù «E~1_ùÛ½\á\İ9¹\È\Ëùlr~\ØhQ\ß6\Û]×’i\Ûuõö¡\İTM½\ÙÕ¤$«’\Ü\Ô\×w\åVN9\Ñt\ÄS2ro\Æ#*o_4-©j2û½n6¥&ùúaU—U{˜ü¿G;k\×W_“Óºzj6\ä¸)¦¦¿ª+H\Å\Ç,\ÍR5ş‹s\r,Iöûœ{}^´»re\êx\×v\æ<¹#’@I	À\ÛĞ¦{¾“-œr½¹n­P t\Çö\çEt=ö¿œ|ƒO¿F4N\ÈS¤T,H\ÊRÂ¨ŒS\Â\é\êh\éD–ñ8CU\á/¦J\Êc†ªÖ–R\'\Â*\ßQ-¢:[D\ím%l1\Õ\Úbªµ\ÅTk›ª![Du¶ˆ\êl\Õ\Ú&|\ÈQ-¢:[Dµ¶\"²ETg‹¨\ÎQ­-j)Lu¶ˆ\êl\Õ\Ú\ÒÁ–BTg‹¨\ÎQ{[©†Z\nS­-¦Z[_½4Ox\Ö3nDœÁ0\\Ö¯†\ßÑ‰yö˜\Ù\ç\ÕzNY\Ã\Ê_\n£ÑŒ\È|³\ë\Ê*@\nFcX‹“\ËrÕ„@É’˜&ğy,›¶|F¸Œ…™w\Ê GEW^•÷ğ­¶ş\î\í\ç\ß\Ûû\å‘\ë#,“ıT\Ûg¨\ÒBiIUË²~\ÒIu¢¡\á\ÈXˆ šr\ÍD$Qé»ƒø£š¥:É° A‚\'Z\Ä\'Lp±lñşi?£A<†fš+(\Z$D¬¯\âD@½° ‰|ŸaZB–€‰\"h­@}]0A˜\æ\"$P-\Äc ¾’\ÃÉ£A‚„Ğ¡b¹ >\Ñaf´A8z\Ùˆ\â1pA Q\îHˆğµõuA<\Â\É4K° ½\ìx±_+D¸ >1†\âj·–G@˜Œ”!Ad†]ö‰\r\â3.»@\ïH˜È‚bƒø„9\nı\èˆ?~ù9ü\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154939-05\'00\')/ModDate(D:20210703154939-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001010 00000 n \n0000001103 00000 n \n0000000015 00000 n \n0000001191 00000 n \n0000000889 00000 n \n0000001242 00000 n \n0000001287 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<6736ee8b81b9ef55c731c4b564445ac1><6736ee8b81b9ef55c731c4b564445ac1>]>>\n%iText-5.5.12\nstartxref\n1445\n%%EOF\n',5,'2021-07-03'),(29,'Departamento_Recursos Humanos_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 832/Filter/FlateDecode>>stream\nxœµ•\İN\ã0…\ïó¾d/šõ_R\Çw\İRV¨…6÷«@µ\r$E+\í\ï[\ì86õL\Ò.A9ş\æ\äŒ\í\Écò­LT\Î\ÏY¹L8\ãşøz\"˜¬¼¹\ïö69úù¿¾”÷Pù¶¯vÂ¨Ô¨góW\ËñlZ\Îg\ç\ìx\ÂF‹³E9™\ÏF\Ï\ì P¾‚\ÊR#\ã\nó\É\Ål^N\ŞW€O\ç\ìb2_Ì¦£ó\×r¾×ˆ7•\ê\ÛU·k6nÚ¶\îš\írUow5«Øºb7õõ]\ÕY&¹d\Î\á\ÃpÀ\Õ^^¤üqıPµ»j%\Ë\æõõS\Û5;}\ÚTÛ¦û˜ÿ»ƒ¸M›\Í4Á²\ÓzùkµeÇ«\ê÷\Ç\Ôø\Ïòi]A“†\"/r3ü˜`È’lÿ¨\Êè¨–Í®Z³e\Í\îš\Ö\íŠ`wL³\r<(ÀVt\Ïw\ÔÁ^\×\Ûë•£\r	`\×dñ¤L.“\ÇşG²ğ\ß\ï	O3ö+1&U,9\\§9“†µu²¢(dZª,†ğ›R5—© Uo\ËyaUlK¨Á–Pƒ-¡ö¶™\Ñl)\Õ\ÛRª·¥To››C¶„\Zl	5\Øª·\Í\ä![B\r¶„\Zl	\ÕÛªü-¡[B\r¶„\êm\å¡#E©Á–Pƒ-¡z[~ğHj°%\Ô`K¨½­6‡¥z[Jõ¶±z\é^Ò¢0nÜ¨´€¬`¸l\Ş¿£÷r³Î›õ’‹†U¼şF£‘“í®­–©Oa-M.ªõ\nµ\ÈR!\à\ËXvúw\Ú\"uªÜ¼39*\Ûêªº‡§\ê\â\ê\ï\ç—Ü«ıú\âQ\è~ª\í3\ÜXe¬\æH×Š¢Ÿt¡¹\Í\Z¶L`·\\Z}\Ì\äŸ3‚[‘Û¬ ‚ „Ì¬B$&\\¼Y>\Èp·_‚\É \Ã+\r4Œ‚J ı\rAb‚(\è$ÓŸ3\ÂjÈ‚˜„ ‘Á\ÑBú‚D„\"¬\ÔTe¨ H·Bˆşj	;OA	e±f… 1\Ñ\ÈaôA$y\Ù$‰¸ pP\ÜŒ\ĞğXHCˆpA\n+2*\'/;$bücaDCh®UôÑŠ“‘\"ˆ.¨Ë™ø 1A\à²+ò\àD$&Üp8ø\ŞW5\Å\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154945-05\'00\')/ModDate(D:20210703154945-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001035 00000 n \n0000001128 00000 n \n0000000015 00000 n \n0000001216 00000 n \n0000000914 00000 n \n0000001267 00000 n \n0000001312 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<c7debfed39da960718362d93bc3ecc57><c7debfed39da960718362d93bc3ecc57>]>>\n%iText-5.5.12\nstartxref\n1470\n%%EOF\n',4,'2021-07-03'),(22,'Departamento_Recursos Humanos_Empleado_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 1349/Filter/FlateDecode>>stream\nxœ½™[SI…\ß\çW\Ô#>0[·¾¾±0.n Ã¼o´\Ğ\Â0£3F\ì¯ßª\Î\\e\É<…l¢†Â™Ó§¾®\Ì\ê\ìğó\ì÷\Õ,Ô¦µµY]Ï¬9tmş\Ço¯qŞ¬>¤\å_»›\ÙÁ_?ñ\ë\Õ\êcºò\ÍtõÇ¹\ß\Ó\Ìÿø:¾8_-/\Î\Ì\É\Â]¾¹\\-Î\ßı¤¨\å\â\í\Årµø\ïµ\Ówg\æ\íbyyq~tö|\Ğr¼Y\ïv[s¼\İ\í\Æı§\í\æz=nF3˜»Á|¯n‡}o¼õ\î\ĞÖ‡.šCş¦9´\áùËŸŒŸ†\İ\ÃpŸ.¹\í\Ír¼ú²\Ûo÷\æô\Ëı°\Ù\îŸ÷ÿ\Ú\r>\ßŞ¿O7¡7§\ãõ\×õÆœ¬‡¿`¯\äGBkŸÔ®µ»\Ú>w\æz4·\Û]¾\ÇÎ™[SYsŸ‚+³W®ú4øhŸ¶n\Ü\\­§-òĞ¡u\Î\Ó/V³w³\Ï\ÓoşL?ıcf\ç•ù:k\Ûy0uˆ\Æ\Ù8¯o\Ínœ]²\è:?\ï \ê»&ı\Ôhı\ÜA•b\ÓúItµT*\Ç•b­/\Å•cÊ±@b«¶.\Ä\"•b‘J±H¥\ØÆ–bÊ±@\åX RlK±@\åX r,P)6”J\n©T*\ÅúRI!•cÊ±@¥X[,) r,P9¨Sl\ìJ%…TŠE*\Å\"•b›RI!•cÊ±@¥ØªTRH\åX r,P)6–J\n©T*\ÅúRI!•cÊ±@¥XW,) r,P9¨Sl\èJ%…TŠE*\Å\"•b›RI!•cÊ±@¥ØºTRH\åX r,P)6–J\n©T*Å†RI!•cÊ±@¥XW,) r,P9¨S¬\ïJ%…TŠE*\Å\"•b\ÛRI!•cÊ±B}—\ß\İ4\â\æ7Ì»4\Ë\Å4\ß?\ZÀ^\çwš<ı¦‘÷\Ñ\ç½uó4\ÊÏŸ¦ñ<\é‹\Í\Ãn¸VœÁ\Ùyú,v^wk\Í]5·•büöj¯0½%}³ø8yâ®³\å`µ\ŞÓªöò\êÍ£¬·O®ııUNZ\\ó€+<®\îc\ÓG§Üµ®\ËC/rT\nt\Ú2§8¬\íóoeUb\ã\ËA„\'-«²½o pA„ƒAô	¤jŸ\îöó \ÒCËª”\Ñ¡HG¦ğ}hH\ã_\"<´¬ˆ\ê¨{A„ƒ@<©ê—ƒO^V\Ó\Û\Z‚¨®wŠƒA„ƒ@œE ñ\å\Í.=.Qt}\è ˆtøt6ôN9D8lL\ÛQ\Ø›]¹[\"<´¬  3ˆ\êğ½Ujv­«\Ä\Âf\Ç \ÂC\ËrxG€#\ÂSK:D\ëª	$v°\Ù!ˆô\äeÕ½UB9¼‚N \ÒÁ Êª¤ÍA„‡–¥\İ_‘¦÷®ğ‘\Ô#!¦SÔ°Ù•»\Å Â“—\ÕN-\ä(€\Çs;Q³k\Õ\È Â“ü`€ ª£)¿\ÒÁ pG<jöˆğ\ä§B:á¬¥;ª>`\á\È \éÀF#Jt¨Ù½ba\áqyRS\Û\æŠ\×F@‘\ÔRN=P&Ğ¡f×ª‘@¤\'/«í£²\í¢:bšÎ”\Ç(z²£\âôÿ	/´#\Ó\ÌA4‡¯\ÔY€A„#ƒ\è7‹@j\Ø\ìJ¡0ˆğ¤ù$¿ª#ŠvD:HP/m?\0\"=®z42ˆ\æÈƒ¿rD8¨\Ù=z±\n6»r·Dx\ÒıÍ““\â`\Õ\ÔW1‘:µ”b$›>¥\'5H*”Bh<ı\ÂSK:2H‡\ß`a³c\á¡ei‘ô4Lm‚KK8ò\è›úPyVM ¾EÍ®…ˆô$\Ô\ì\Ú\ã@tG§\nH=\Ù\ã¿Ï‘\0òª\'\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703113755-05\'00\')/ModDate(D:20210703113755-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000001553 00000 n \n0000001646 00000 n \n0000000015 00000 n \n0000001734 00000 n \n0000001432 00000 n \n0000001785 00000 n \n0000001830 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<5ac9d802f507f76efcecca4297016f9d><5ac9d802f507f76efcecca4297016f9d>]>>\n%iText-5.5.12\nstartxref\n1988\n%%EOF\n',6,'2021-07-03'),(30,'Departamento_Recursos Humanos_Empleado_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 793/Filter/FlateDecode>>stream\nxœ½•OO\Û@\Å\ïşs¤‡¸ûÏ½·L¡B	$¾W†\"1\ØAHıôW@³3¦T¨‰\"HûüfgÇÑ·2\Ò)d\"…r	\É\ÌıóõX‚TP^\ãO\î\İ\ŞD??ñõ¥¼Ã•ov«¿õ}uƒxÎ¦\å|vGL§‹²˜N>\Éj^œ\Ï\æeñ\ç\Úø\íÎ‹ùb6œ½o4¯oVİ¶m\à°iÛº{h6\ËU½\Ù\ÖPÁ}\×õ\Õm\ÕYPBÉ‘HG*…‘ÿ2	ışòGõC\Õn«5.\ÙX˜\×WOm\×tpò´®6M÷>ÿ7xÚ¬/±N\ê\åójG«\ê\×_\ìqI²ß»*\èİ²\ÙV÷°¬\á¶i]%Ü‚5\Ú\"\ÜQ‹\îùN:Ü¹zsµrt\ÆÔ¹Ù¿¸(£‹\èq÷Qğı‰8\ç(\Ëb\r©6 …‰SP´u´ğ¢\ÌUœ³ª\Ê\Çø—SP±d\Õ\Ş\ï¿eJ\Ø2ª·eToË¨½­PC¶Œ\êm\Õ\Û2\ê\Î6\É\Ò[N\ím9µ·\å\Ô\Şv,†l\Õ\Û2ª·e\Ô\Ş61C¶Œ\êm\Õ\Û2jo«‡ZŠS½-£z[F\ím\ÕPKqª·eToË¨½­l)Fõ¶Œ\êmõ\Â=µ\ånÀ¸q£\ãO’Á´~3ü\İó\Ä\Í8o®WB\Æx$\Ã\ëOp4ºYl¶mµ$H-EŒ\×òä¢º_Q ‘I,|\Ën…\İ\êQ&\ÖnŞ¥9(\Ûê²ºÃ»\ê\Â\Õs\á‰{k¿>FCD\æÆ—€™Õ™5‚¨Z»‘CF\Ø$#B\ã–IŠV(+	¢\"\ÌÇƒŒV¦6\É\Ù ¡«	\Â	„.\Ö.H’\í\ïöK1$dDnU†ã‚„–d}û A4Ö‹2V2\Ò\Z\ÌB˜ø ‘`kõõA\Â‘V.H’rAˆjù ƒõ5\nw\rB\ÚR\ÅòABbD\Í\Ø1\ìa\'$`ğ€`£ğg„$\ŞQ_$ \\\ÜÊ„¢\Ø\Ã\Î	˜ş¶(\Â	‰1\×j¾µƒ\àd’\"¸\ÃN™ø ƒAğ°kşŒDN6ŠnGö£\'~÷ş0ò\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703154953-05\'00\')/ModDate(D:20210703154953-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000996 00000 n \n0000001089 00000 n \n0000000015 00000 n \n0000001177 00000 n \n0000000875 00000 n \n0000001228 00000 n \n0000001273 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<0edc0768e2fc59b52a2b36cb6b56db7e><0edc0768e2fc59b52a2b36cb6b56db7e>]>>\n%iText-5.5.12\nstartxref\n1431\n%%EOF\n',6,'2021-07-03'),(31,'Registro_3-7-2021_.pdf',_binary '%PDF-1.4\n%\â\ã\Ï\Ó\n3 0 obj\n<</Length 300/Filter/FlateDecode>>stream\nxœµ’\ÍN„0\Ç\ï}Š9\êl©|\È\r¡fI¬Ğ»©¶‹e1&¾±oaqq\ÙM¸h\ÛCÛ™ùı;\ÓyE\×Q<\ì\0—ƒA¼asqC€XÀ7új˜]‰\Î\îşpœó\'M.¿\éZx\Ôô\è(>I†Y\Êó,ˆAP\Ägic¬±\Ú5‰}L\È\Ù:\Ë9ƒ(ò8;\éSk–Y\Z$uG\ÂõøTeµ\í»Â¶\ë\Ôö¥md¥š^€ZÀF=<\n¨\á\Z¶\È,\Í¸,\ê	5XvI\Û\ç{—+%ß«¢J|,G…Ÿò­Ö‰[.q®ÏE\ØÔ¤\Ş\Ô[\ÖQo­\ÚN€TÀš¾Rƒˆ\ãc\ìS\n£¥uµ7\èe¹\0¼\íE=˜ı`\íOlß¾üùÉ*^l\ìyUG·\èG\Ï!\nendstream\nendobj\n5 0 obj\n<</Type/Page/MediaBox[0 0 595 842]/Resources<</Font<</F1 1 0 R/F2 2 0 R>>>>/Contents 3 0 R/Parent 4 0 R>>\nendobj\n1 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica-Bold/Encoding/WinAnsiEncoding>>\nendobj\n2 0 obj\n<</Type/Font/Subtype/Type1/BaseFont/Helvetica/Encoding/WinAnsiEncoding>>\nendobj\n4 0 obj\n<</Type/Pages/Count 1/Kids[5 0 R]>>\nendobj\n6 0 obj\n<</Type/Catalog/Pages 4 0 R>>\nendobj\n7 0 obj\n<</Producer(iText® 5.5.12 ©2000-2017 iText Group NV \\(AGPL-version\\))/CreationDate(D:20210703161703-05\'00\')/ModDate(D:20210703161703-05\'00\')>>\nendobj\nxref\n0 8\n0000000000 65535 f \n0000000503 00000 n \n0000000596 00000 n \n0000000015 00000 n \n0000000684 00000 n \n0000000382 00000 n \n0000000735 00000 n \n0000000780 00000 n \ntrailer\n<</Size 8/Root 6 0 R/Info 7 0 R/ID [<e9b88fe4672736204e9a4400d5fab91e><e9b88fe4672736204e9a4400d5fab91e>]>>\n%iText-5.5.12\nstartxref\n938\n%%EOF\n',1,'2021-07-03');
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
INSERT INTO `tipo_nomina` VALUES (2,'Empleado'),(3,'ComisiÃ³n de Servicios');
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
INSERT INTO `tipo_reporte` VALUES (1,'Diario'),(2,'General'),(3,'Individual'),(4,'Por Departamento'),(5,'Por NÃ³mina'),(6,'Por Departamento y NÃ³mina');
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
