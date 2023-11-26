-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lab9
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `idcurso` int NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_edicion` datetime NOT NULL,
  `idfacultad` int NOT NULL,
  PRIMARY KEY (`idcurso`),
  KEY `fk_curso_facultad1_idx` (`idfacultad`),
  CONSTRAINT `fk_curso_facultad1` FOREIGN KEY (`idfacultad`) REFERENCES `facultad` (`idfacultad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'mat101','calculo 1','2023-11-25 14:55:00','2023-11-25 15:35:00',10),(2,'mat103','calculo 2','2023-11-25 14:55:00','2023-11-25 15:35:00',12),(3,'mat155','mate basica','2023-11-25 14:55:00','2023-11-25 15:35:00',21),(4,'mat125','mate 1','2023-11-25 14:55:00','2023-11-25 15:35:00',23),(5,'fis101','fisica 1','2023-11-25 14:55:00','2023-11-25 15:35:00',21),(6,'fis102','fisica 2','2023-11-25 14:55:00','2023-11-25 15:35:00',10),(7,'fis103','fisica 3','2023-11-25 14:55:00','2023-11-25 15:35:00',10),(8,'fis100','fisica 0','2023-11-25 14:55:00','2023-11-25 15:35:00',10),(9,'quim101','quimica 1','2023-11-25 14:55:00','2023-11-25 15:35:00',12);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_has_docente`
--

DROP TABLE IF EXISTS `curso_has_docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso_has_docente` (
  `idcurso` int NOT NULL,
  `iddocente` int NOT NULL,
  PRIMARY KEY (`idcurso`,`iddocente`),
  KEY `fk_curso_has_usuario_usuario1_idx` (`iddocente`),
  KEY `fk_curso_has_usuario_curso1_idx` (`idcurso`),
  CONSTRAINT `fk_curso_has_usuario_curso1` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`),
  CONSTRAINT `fk_curso_has_usuario_usuario1` FOREIGN KEY (`iddocente`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_has_docente`
--

LOCK TABLES `curso_has_docente` WRITE;
/*!40000 ALTER TABLE `curso_has_docente` DISABLE KEYS */;
INSERT INTO `curso_has_docente` VALUES (1,401),(2,402),(3,403),(4,404),(5,405),(6,406),(7,407),(8,407);
/*!40000 ALTER TABLE `curso_has_docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluaciones`
--

DROP TABLE IF EXISTS `evaluaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluaciones` (
  `idevaluaciones` int NOT NULL,
  `nombre_estudiantes` varchar(45) NOT NULL,
  `codigo_estudiantes` varchar(45) NOT NULL,
  `correo_estudiantes` varchar(45) NOT NULL,
  `nota` int NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_edicion` datetime NOT NULL,
  `idsemestre` int NOT NULL,
  `idcurso` int NOT NULL,
  PRIMARY KEY (`idevaluaciones`),
  KEY `fk_evaluaciones_semestre1_idx` (`idsemestre`),
  KEY `fk_evaluaciones_curso1_idx` (`idcurso`),
  CONSTRAINT `fk_evaluaciones_curso1` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`idcurso`),
  CONSTRAINT `fk_evaluaciones_semestre1` FOREIGN KEY (`idsemestre`) REFERENCES `semestre` (`idsemestre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluaciones`
--

LOCK TABLES `evaluaciones` WRITE;
/*!40000 ALTER TABLE `evaluaciones` DISABLE KEYS */;
INSERT INTO `evaluaciones` VALUES (900,'juan ','20201234','juan@pucp.edu.pe',12,'2023-11-25 15:40:00','2023-11-25 16:00:00',2,1),(902,'juana','20201238','juana@upc.edu.pe',12,'2023-11-25 15:40:00','2023-11-25 16:00:00',2,1),(903,'leo','20201231','leo@senati.edu.pe',13,'2023-11-25 15:40:00','2023-11-25 16:00:00',2,1),(904,'lea','20201212','lea@pucp.edu.pe',14,'2023-11-25 15:40:00','2023-11-25 16:00:00',2,1),(905,'ana','20201208','ana@pucp.edu.pe',15,'2023-11-25 15:40:00','2023-11-25 16:00:00',2,1);
/*!40000 ALTER TABLE `evaluaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facultad`
--

DROP TABLE IF EXISTS `facultad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facultad` (
  `idfacultad` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_edicion` datetime NOT NULL,
  `iduniversidad` int NOT NULL,
  PRIMARY KEY (`idfacultad`),
  KEY `fk_facultad_universidad1_idx` (`iduniversidad`),
  CONSTRAINT `fk_facultad_universidad1` FOREIGN KEY (`iduniversidad`) REFERENCES `universidad` (`iduniversidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facultad`
--

LOCK TABLES `facultad` WRITE;
/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
INSERT INTO `facultad` VALUES (10,'teleco','2023-11-25 15:25:00','2023-11-25 15:50:00',101),(11,'derecho','2023-11-25 15:25:00','2023-11-25 15:50:00',101),(12,'civil','2023-11-25 15:25:00','2023-11-25 15:50:00',101),(21,'software','2023-11-25 15:00:00','2023-11-25 15:50:00',102),(22,'medicina','2023-11-25 15:00:00','2023-11-25 15:50:00',102),(23,'costureria','2023-11-25 15:00:00','2023-11-25 15:50:00',102),(24,'comunicaciones','2023-11-25 15:00:00','2023-11-25 15:50:00',102),(25,'sociologia','2023-11-25 15:00:00','2023-11-25 15:50:00',102),(31,'artes','2023-11-25 15:00:00','2023-11-25 15:50:00',103),(32,'gestion','2023-11-25 15:00:00','2023-11-25 15:50:00',103),(33,'artes','2023-11-25 15:00:00','2023-11-25 15:50:00',103);
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facultad_has_decano`
--

DROP TABLE IF EXISTS `facultad_has_decano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facultad_has_decano` (
  `idfacultad` int NOT NULL,
  `iddecano` int NOT NULL,
  PRIMARY KEY (`idfacultad`,`iddecano`),
  KEY `fk_facultad_has_usuario_usuario1_idx` (`iddecano`),
  KEY `fk_facultad_has_usuario_facultad1_idx` (`idfacultad`),
  CONSTRAINT `fk_facultad_has_usuario_facultad1` FOREIGN KEY (`idfacultad`) REFERENCES `facultad` (`idfacultad`),
  CONSTRAINT `fk_facultad_has_usuario_usuario1` FOREIGN KEY (`iddecano`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facultad_has_decano`
--

LOCK TABLES `facultad_has_decano` WRITE;
/*!40000 ALTER TABLE `facultad_has_decano` DISABLE KEYS */;
INSERT INTO `facultad_has_decano` VALUES (10,301),(11,302),(12,303),(21,304),(21,305),(22,306);
/*!40000 ALTER TABLE `facultad_has_decano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idrol` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Rector'),(3,'Decano'),(4,'Docente');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semestre`
--

DROP TABLE IF EXISTS `semestre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semestre` (
  `idsemestre` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `habilitado` tinyint NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_edicion` datetime NOT NULL,
  `idadministrador` int NOT NULL,
  PRIMARY KEY (`idsemestre`,`idadministrador`),
  KEY `fk_semestre_usuario1_idx` (`idadministrador`),
  CONSTRAINT `fk_semestre_usuario1` FOREIGN KEY (`idadministrador`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semestre`
--

LOCK TABLES `semestre` WRITE;
/*!40000 ALTER TABLE `semestre` DISABLE KEYS */;
INSERT INTO `semestre` VALUES (0,'2023-0',0,'2023-11-25 14:55:00','2023-11-25 15:45:00',101),(1,'2023-1',0,'2023-11-25 14:55:00','2023-11-25 15:45:00',102),(2,'2023-2',1,'2023-11-25 14:55:00','2023-11-25 15:45:00',103);
/*!40000 ALTER TABLE `semestre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `universidad`
--

DROP TABLE IF EXISTS `universidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `universidad` (
  `iduniversidad` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_edicion` datetime NOT NULL,
  `idadministrador` int NOT NULL,
  `logo_url` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`iduniversidad`),
  KEY `fk_universidad_usuario1_idx` (`idadministrador`),
  CONSTRAINT `fk_universidad_usuario1` FOREIGN KEY (`idadministrador`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `universidad`
--

LOCK TABLES `universidad` WRITE;
/*!40000 ALTER TABLE `universidad` DISABLE KEYS */;
INSERT INTO `universidad` VALUES (101,'PUCP','2023-11-25 14:30:00','2023-11-25 14:30:00',101,'https://pbs.twimg.com/media/E6sqz46WEAQOe4r.jpg:large'),(102,'MOLINA','2023-11-25 14:35:00','2023-11-25 15:10:00',102,'https://wuidy.com/wp-content/uploads/2023/04/Universidad-Nacional-Agraria-La-Molina-UNALM.jpg'),(103,'SENATI','2023-11-25 14:45:00','2023-11-25 15:10:00',103,'https://yt3.googleusercontent.com/ytc/APkrFKZ3FxHJhVcDjn2BxNSNkKBSuzrutqm8RfKIWvgnEg=s900-c-k-c0x00ffffff-no-rj');
/*!40000 ALTER TABLE `universidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `universidad_has_rector`
--

DROP TABLE IF EXISTS `universidad_has_rector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `universidad_has_rector` (
  `iduniversidad` int NOT NULL,
  `idrector` int NOT NULL,
  PRIMARY KEY (`iduniversidad`,`idrector`),
  KEY `fk_universidad_has_usuario_usuario1_idx` (`idrector`),
  KEY `fk_universidad_has_usuario_universidad1_idx` (`iduniversidad`),
  CONSTRAINT `fk_universidad_has_usuario_universidad1` FOREIGN KEY (`iduniversidad`) REFERENCES `universidad` (`iduniversidad`),
  CONSTRAINT `fk_universidad_has_usuario_usuario1` FOREIGN KEY (`idrector`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `universidad_has_rector`
--

LOCK TABLES `universidad_has_rector` WRITE;
/*!40000 ALTER TABLE `universidad_has_rector` DISABLE KEYS */;
INSERT INTO `universidad_has_rector` VALUES (101,201),(102,202),(103,203);
/*!40000 ALTER TABLE `universidad_has_rector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ultimo_ingreso` datetime DEFAULT NULL,
  `cantidad_ingresos` int NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_edicion` datetime NOT NULL,
  `idrol` int NOT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usuario_rol_idx` (`idrol`),
  CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (101,'leonardo','leonardo@pucp.edu.pe','123456','2023-11-25 16:30:00',3,'2023-11-25 14:30:00','2023-11-25 14:31:00',2),(102,'juan','juan@gmail.com','123456','2023-11-25 14:30:00',4,'2023-11-25 14:30:00','2023-11-25 14:30:00',1),(103,'gabriel','gabriel@gmail.com','123456','2023-11-30 20:15:00',6,'2023-12-01 08:45:00','2023-11-26 10:00:00',1),(104,'karim','karim@gmail.com','123456','2023-11-30 20:15:00',3,'2023-12-01 08:45:00','2023-11-26 10:00:00',1),(105,'rodrigo','rodrigo@gmail.com','123456','2023-11-30 20:15:00',2,'2023-12-01 08:45:00','2023-11-26 10:00:00',1),(106,'jesus','jesus@gmail.com','123456','2023-11-30 20:15:00',1,'2023-11-25 18:00:00','2023-11-26 10:00:00',1),(201,'pablo','pablo@gmail.com','12346','2023-11-25 14:35:00',5,'2023-11-25 14:35:00','2023-11-25 15:15:00',2),(202,'job','job@gmail.com','123456','2023-11-25 16:10:00',3,'2023-11-25 14:45:00','2023-11-25 15:15:00',2),(203,'joe','joe@gmail.com','123456','2023-11-25 16:10:00',3,'2023-11-25 14:50:00','2023-11-25 15:15:00',2),(204,'ana','ana@gmail.com','123456','2023-11-25 16:10:00',5,'2023-11-25 14:55:00','2023-11-25 15:15:00',2),(205,'lio','lio@gmail.com','123456','2023-11-25 16:10:00',12,'2023-11-25 14:55:00','2023-11-25 15:15:00',2),(301,'Luis ','luis@email.com','123456','2023-11-25 15:55:00',6,'2023-11-25 14:45:00','2023-11-25 15:45:00',3),(302,'Carla ','carla@email.com','123456','2023-11-25 15:55:00',6,'2023-11-25 14:45:00','2023-11-25 15:45:00',3),(303,'Juan ','juan@email.com','123456','2023-11-25 15:55:00',8,'2023-11-25 14:45:00','2023-11-25 15:45:00',3),(304,'Andrea ','andrea@email.com','123456','2023-11-25 15:55:00',1,'2023-11-25 14:45:00','2023-11-25 15:45:00',3),(305,'Rosa ','rosa@email.com','123456','2023-11-25 15:55:00',2,'2023-11-25 14:45:00','2023-11-25 15:45:00',3),(306,'Martín ','martin@email.com','123456','2023-11-25 15:55:00',4,'2023-11-25 14:45:00','2023-11-25 15:45:00',3),(307,'Isabel ','isabel@email.com','123456','2023-11-25 16:10:00',3,'2023-11-25 16:10:00','2023-11-25 16:10:00',3),(308,'julio','julio@email.com','123456','2023-11-25 16:10:00',2,'2023-11-25 16:10:00','2023-11-25 16:10:00',3),(401,'Rodrigo ','rodrigo@email.com','123456','2023-11-25 16:05:00',23,'2023-11-25 14:45:00','2023-11-25 15:20:00',4),(402,'Beatriz ','beatriz@email.com','123456','2023-11-25 16:05:00',23,'2023-11-25 14:45:00','2023-11-25 15:20:00',4),(403,'Javier ','javier@email.com','123456','2023-11-25 16:05:00',12,'2023-11-25 14:45:00','2023-11-25 15:20:00',4),(404,'Patricia ','patricia@email.com','123456','2023-11-25 16:05:00',3,'2023-11-25 14:45:00','2023-11-25 15:20:00',4),(405,'Victor ','victor@email.com','123456','2023-11-25 16:05:00',12,'2023-11-25 14:45:00','2023-11-25 15:20:00',4),(406,'Raquel ','raquel@email.com','123456','2023-11-25 16:05:00',34,'2023-11-25 14:45:00','2023-11-25 15:20:00',4),(407,'Oscar ','oscar@email.com','123456','2023-11-25 16:05:00',12,'2023-11-25 14:45:00','2023-11-25 15:20:00',4);
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

-- Dump completed on 2023-11-26 17:55:37
