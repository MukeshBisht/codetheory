-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: codedb
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `question_challengegrp_map`
--

DROP TABLE IF EXISTS `question_challengegrp_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question_challengegrp_map` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ChallengeGrpId` int(11) NOT NULL,
  `QuestionId` int(11) NOT NULL,
  `Userid` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `id_idx` (`QuestionId`),
  KEY `challengeGroupid_idx` (`ChallengeGrpId`),
  KEY `user_idx` (`Userid`),
  CONSTRAINT `cgid` FOREIGN KEY (`ChallengeGrpId`) REFERENCES `challengegroup` (`ChallengeGroupId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
--  CONSTRAINT `qig` FOREIGN KEY (`QuestionId`) REFERENCES `quiz_question` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `user` FOREIGN KEY (`Userid`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question_challengegrp_map`
--

LOCK TABLES `question_challengegrp_map` WRITE;
/*!40000 ALTER TABLE `question_challengegrp_map` DISABLE KEYS */;
INSERT INTO `question_challengegrp_map` VALUES (15,2,27,'sam'),(16,7,28,'sagar'),(17,7,29,'sagar'),(21,10,33,'sagar');
/*!40000 ALTER TABLE `question_challengegrp_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-19 20:08:25
