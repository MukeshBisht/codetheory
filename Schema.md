
# users table  
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# user_roles table  
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

# quiz_question table  
CREATE TABLE `quiz_question` (
  `id` int(11) NOT NULL,
  `question` varchar(255) NOT NULL,
  `option1` varchar(100) DEFAULT NULL,
  `option2` varchar(100) DEFAULT NULL,
  `option3` varchar(100) DEFAULT NULL,
  `option4` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
# contests table  
CREATE TABLE `contests` (
  `contestName` varchar(45) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `orgType` tinyint(4) NOT NULL DEFAULT '0',
  `orgName` varchar(45) NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `creationDate` datetime NOT NULL,
  PRIMARY KEY (`contestName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# user_contests table  
CREATE TABLE `user_contests` (
  `contest` varchar(45) NOT NULL,
  `user` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# challengegroup table  
CREATE TABLE `codedb`.`challengegroup` (
  `ChallengeGroupId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `User` VARCHAR(45) NOT NULL,
  `Type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ChallengeGroupId`));

# user_challengegroup_map table  
CREATE TABLE `codedb`.`user_challengegroup_map` (
  `user_challengegroup_mapid` INT NOT NULL AUTO_INCREMENT,
  `challengegroupid` INT NOT NULL,
  `owner` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_challengegroup_mapid`));

# INSERT TRIGGER  
DELIMITER $$
create trigger insertmap AFTER insert on challengegroup for each row 
BEGIN
	insert into user_challengegroup_map(user_challengegroup_map.challengegroupid, user_challengegroup_map.user)
    values (NEW.challengegroupid, NEW.owner);
END; $$

# question insert funcation: addQuestion  
DELIMITER $$
CREATE FUNCTION `addQuestion` (
ques nvarchar(2000), op1 nvarchar(1000), op2 nvarchar(1000), op3 nvarchar(1000), op4 nvarchar(1000), lvl int, ans int, grp int, usr varchar(45)) 
RETURNS INTEGER
BEGIN
	#insert question in table
	INSERT into quiz_question
    (question, option1, option2, option3, option4, answer, level)
    values
    (ques, op1, op2, op3, op4, ans, lvl);
    #insert mapping
    insert into question_challengegrp_map(ChallengeGrpId, QuestionId, Userid)
    values
	(grp, LAST_INSERT_ID() ,usr);  
RETURN 1;
END $$



CREATE TABLE `test_case` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `input` varchar(45) NOT NULL,
  `output` varchar(45) NOT NULL,
  `points` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`test_id`),
  KEY `id_idx` (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `code_question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `code_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(200) NOT NULL,
  `details` varchar(100) DEFAULT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

# round table  
CREATE TABLE `round` (
  `Roundid` int(11) NOT NULL AUTO_INCREMENT,
  `contest` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Length` int(11) NOT NULL,
  `Type` int(11) NOT NULL,
  PRIMARY KEY (`Roundid`),
  KEY `contestid_idx` (`contest`),
  CONSTRAINT `contestid` FOREIGN KEY (`contest`) REFERENCES `contests` (`contestName`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

# round_challenges_map table  
CREATE TABLE `round_challenges_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roundid` int(11) DEFAULT NULL,
  `questionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid_idx` (`roundid`),
  CONSTRAINT `rid` FOREIGN KEY (`roundid`) REFERENCES `round` (`Roundid`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#addCodeQuestion sp

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addCodeQuestion`(ques nvarchar(2000), detail nvarchar(1000), lvl int, test nvarchar(1000) )
BEGIN
	INSERT into code_question
    (question, details, level, test_case)
    values
    (ques, detail, lvl,test);
   
END$$
DELIMITER ;
