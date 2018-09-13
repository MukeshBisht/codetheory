
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


#addCodeQuestion sp
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addCodeQuestion`(ques nvarchar(2000), detail nvarchar(1000), lvl int, test nvarchar(1000), grp int, usr varchar(45))
BEGIN
	INSERT into code_question
    (question, details, level, test_case)
    values
    (ques, detail, lvl,test);
	#insert mapping
    insert into question_challengegrp_map(ChallengeGrpId, QuestionId, Userid)
    values
	(grp, LAST_INSERT_ID() ,usr); 
   
END$$
DELIMITER ;


#round_submission table
CREATE TABLE `round_submission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `round_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  `contest` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `round_id_idx` (`round_id`),
  KEY `username_idx` (`username`),
  CONSTRAINT `round_id` FOREIGN KEY (`round_id`) REFERENCES `round` (`Roundid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#code_submission table
CREATE TABLE `code_submission` (
  `user` varchar(50) NOT NULL DEFAULT 'none',
  `max_exe_time` double DEFAULT NULL,
  `roundid` int(11) NOT NULL DEFAULT '1',
  `score` double DEFAULT NULL,
  `code` longtext,
  `languageid` int(11) DEFAULT NULL,
  `questionid` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`questionid`,`roundid`,`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;