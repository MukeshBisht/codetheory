package com.codetheory.web.api;

import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.model.QuizQuestion;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
    public List<QuizQuestion> getQuestions(@PathVariable String id, Principal principal) {
        String user = principal.getName();
        ChallengeGroup chgrp = dao.getChallengeById(id);
        if(chgrp!=null){
            if (dao.challengeGroupExist(chgrp.getName(), user)) {
                return dao.getAllQuestion(id);
            }
        }
        return new ArrayList<QuizQuestion>();
    }

    @RequestMapping(value = "group/mcq/{id}/questions/add", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Object> addMCQQuestion(@RequestBody QuizQuestion question, @PathVariable int id, Principal principal) {
        String user = principal.getName();
        dao.addQuestion(question, user, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "group/mcq/questions/update", method = RequestMethod.POST)
    public ResponseEntity<Object> updateQuestion(@RequestBody QuizQuestion question, Principal principal) {
        
        return new ResponseEntity<>("0", HttpStatus.OK);
    }
}