package com.codetheory.web.api;

import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.model.QuizQuestion;
import com.codetheory.web.model.CodeQuestion;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/api/challenge")
public class ChallengeApiController {

    @Autowired
    ChallengeDAO dao;

    @RequestMapping(value = "group/questions/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionData getQuestions(@PathVariable String id, Principal principal) {
        String user = principal.getName();
        QuestionData data = new QuestionData();
        ChallengeGroup chgrp = dao.getChallengeById(id);
        if(chgrp!=null){
            if (dao.challengeGroupExist(chgrp.getName(), user)) {
                data.setData(dao.getAllQuestion(id));
                return data;
            }
        }
        return data;
    }

    @RequestMapping(value = "group/mcq/{id}/questions/add", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Object> addMCQQuestion(@RequestBody QuizQuestion question, @PathVariable int id, Principal principal) {
        String user = principal.getName();
        if(question.getId() == -1){
            dao.addQuestion(question, user, id);
        }else{
            if(dao.isUsersQuestion(question.getId(), user)){
                //update question
                dao.updateQuestion(question);
            }
        }
        return new ResponseEntity<>("0", HttpStatus.OK);
    }

    @RequestMapping(value = "group/mcq/questions/delete", method = RequestMethod.POST)
    public ResponseEntity<Object> deleteQuestion(@RequestBody QuizQuestion question, Principal principal) {
        String user = principal.getName();
        if(dao.isUsersQuestion(question.getId(), user)){
            //delete question
            dao.deleteQuestion(question);
        }
        return new ResponseEntity<>("0", HttpStatus.OK);
    }


    @RequestMapping(value = "group/code/question/add", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Object> addCodeQuestion(@RequestBody CodeQuestion question, Principal principal) {
        if(question.getId() == -1){
            dao.addCodeQuestion(question, principal.getName(), 0);
        }else{
            //if(dao.isUsersQuestion(question.getId(), user))
                //update question
                dao.updateCodeQuestion(question);
            }
        return new ResponseEntity<>("0", HttpStatus.OK);
    }

    @RequestMapping(value = "group/code/question/delete", method = RequestMethod.POST)
    public ResponseEntity<Object> deleteCodeQuestion(@RequestBody CodeQuestion question, Principal principal) {
        //String user = principal.getName();
        //if(dao.isUsersQuestion(question.getId(), user)){
            //delete question
            dao.deleteCodeQuestion(question.getId());
        //}
        return new ResponseEntity<>("0", HttpStatus.OK);
    }
}