CREATE DATABASE  IF NOT EXISTS `groups_manager` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `groups_manager`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: groups_manager
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `igreja_id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `objetivo` varchar(255) DEFAULT NULL,
  `status_grupo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grupo_igreja_id` (`igreja_id`),
  KEY `fk_grupo_status_grupo_id` (`status_grupo_id`),
  CONSTRAINT `fk_grupo_igreja_id` FOREIGN KEY (`igreja_id`) REFERENCES `igreja` (`id`),
  CONSTRAINT `fk_grupo_status_grupo_id` FOREIGN KEY (`status_grupo_id`) REFERENCES `status_grupo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,1,'Pastoral da criança','Grupo de crianças',1),(2,1,'Pastoral da saúde','Grupo de saúde',1),(3,1,'Pastoral da educação','Grupo de educação',1),(4,1,'Pastoral da juventude','Grupo de juventude',1),(5,1,'Pastoral da comunicação','Grupo de comunicação',1),(6,1,'Pastoral da sobriedade','Grupo de sobriedade',1),(7,1,'Pastoral do menor','Grupo de menor',1),(8,1,'Pastoral da liturgia','Grupo de liturgia',1),(9,1,'Pastoral da catequese','Grupo de catequese',1),(10,1,'Pastoral da familiar','Grupo familiar',1),(11,1,'Pastoral da carcerária','Grupo de carcerária',1),(12,1,'Encontro de Casais com Cristo','Grupo de Casais',2),(13,1,'Apostolado da Oração','Grupo de Oração',2),(14,1,'Renovação Carismática Católica','Grupo de Renovação',2),(15,1,'Mãe Rainha','Grupo de Mães',2),(16,1,'Terço dos Homens','Grupo de Homens',2),(17,1,'Comunidade Canção Nova','Grupo de Canção',2),(18,1,'Oração Paroquiais','Grupo de Paroquiais',2);
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-16 10:49:31
