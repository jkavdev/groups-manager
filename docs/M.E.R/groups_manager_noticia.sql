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
-- Table structure for table `noticia`
--

DROP TABLE IF EXISTS `noticia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noticia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `corpo` text,
  `foto` varchar(255) DEFAULT NULL,
  `aberta_ao_publico` bit(1) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `grupo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_noticia_grupo_id` (`grupo_id`),
  CONSTRAINT `fk_noticia_grupo_id` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticia`
--

LOCK TABLES `noticia` WRITE;
/*!40000 ALTER TABLE `noticia` DISABLE KEYS */;
INSERT INTO `noticia` VALUES (1,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(2,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2),(3,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(4,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2),(5,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(6,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2),(7,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(8,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2),(9,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(10,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2),(11,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(12,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2),(13,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(14,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2),(15,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(16,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2),(17,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Bom, tá funcionando',2),(18,'<h3>Tudo funcionando de boas</h3><p>Derive inexpedient reason law virtues superiority victorious. Overcome pious horror suicide revaluation. Holiest ocean societydisgust passion value love. Faithful mountains morality hope disgust merciful moral will revaluation societyfearful love.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore sed consequuntur error repudiandae numquam deserunt quisquamrepellat libero asperiores earum nam nobis, culpa ratione quam perferendis esse, cupiditate neque quas!</p><p>In et blandit turpis, ut congue nibh. Nam vitae tincidunt nunc, sed accumsan lacus. Sed efficitur malesuada augue ut varius.Pellentesque ultricies leo massa, eu posuere diam sodales quis.</p>',NULL,'\0','Outra, véi esse negócio é bom mesmo',2);
/*!40000 ALTER TABLE `noticia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-16 10:49:30
