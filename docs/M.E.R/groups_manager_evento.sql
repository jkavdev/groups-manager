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
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `lotacao_maxima` int(11) NOT NULL,
  `objetivo` text,
  `valor` decimal(19,2) DEFAULT NULL,
  `endereco_id` bigint(20) NOT NULL,
  `grupo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_evento_endereco_id` (`endereco_id`),
  KEY `fk_evento_grupo_id` (`grupo_id`),
  CONSTRAINT `fk_evento_endereco_id` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`),
  CONSTRAINT `fk_evento_grupo_id` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (2,'2018-03-16 01:13:29','Encontro Luz',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(3,'2018-03-16 01:13:29','Encontro Pego',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(4,'2018-03-16 01:13:29','Encontro Bom',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(5,'2018-03-16 01:13:29','Encontro Santo',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(6,'2018-03-16 01:13:29','Encontro Nego',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(7,'2018-03-16 01:13:29','Encontro Jesus',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(8,'2018-03-16 01:13:29','Encontro Maior',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(9,'2018-03-16 01:13:29','Encontro Centrado',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(10,'2018-03-16 01:13:29','Encontro Melo',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2),(11,'2018-03-16 01:13:29','Encontro Martugico',120,'Vice-campeão do primeiro hackathon realizado pela Câmara, em 2013, o aplicativo para acompanhamento de gastos e atividades de deputados e senadores se popularizou e cresceu: hoje tem versões para iOS e Android que também permitem o acompanhamento de projetos de lei e outras proposições, tem uma página no Facebook para discussões e notícias de política, e ainda conta com um chatbot em seu site. Um de seus colaboradores é Gustavo Warzocha Cruvinel, servidor da Câmara que fez uma pesquisa muito útil para o projeto do novo serviço de Dados Abertos.',564.56,1,2);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-16 10:49:27
