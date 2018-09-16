package com.codetheory.web.api;

import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.Round;
import com.codetheory.web.model.UserContestMap;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/contest")
public class ContestApiController {

    @Autowired
    ContestDAO dao;

    @RequestMapping(value = "/moderator",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public void addModerator(@RequestBody UserContestMap uc) {
        if(!dao.validUserContest(uc.getUser(), uc.getContest()))
            dao.addModerators(uc.getContest(), uc.getUser());
    }

    @RequestMapping(value = "/editors/{contest}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserContestMap> getEditors(@PathVariable("contest") String contest, Principal principal) {
        List<UserContestMap> data = null;
        if(principal != null && dao.validUserContest(principal.getName(), contest))
            data = dao.getContestsEditors(contest);
        return data;
    }

    @RequestMapping(value = "/editors/{contest}",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public void removeEditor(@RequestBody UserContestMap uc, Principal principal) {
        if(principal != null && dao.validUserContest(principal.getName(), uc.getContest())){
            dao.removeEditor(uc.getUser(), uc.getContest());
        }
    }

    @RequestMapping(value = "/round", method = RequestMethod.DELETE)
    public void deleteRound(@RequestBody Round round, Principal principal) {        
        String user = principal.getName();
        if(dao.validUserContest(user, round.getContest())){
            if(dao.roundExist(round)){
                dao.deleteRound(round);
            }
        }
    }

    @RequestMapping(value="/round", method = RequestMethod.POST)
    public ResponseEntity<Object> addRound(@RequestBody Round round, Principal principal){
        String user = principal.getName();        
        if(dao.validUserContest(user, round.getContest())){
            dao.addRound(round);
            return new ResponseEntity<>("0", HttpStatus.OK);
        }

        return new ResponseEntity<>("0", HttpStatus.UNAUTHORIZED);
    }
    
    @RequestMapping(value="/round/{roundid}/Challenges", method = RequestMethod.POST)
    public ResponseEntity<Object> addChallengesToRound(@RequestBody int[] chlngIds, @PathVariable("roundid") String roundid, Principal principal){
        String user = principal.getName();
        Round round = dao.getRoundById(roundid);
        dao.addChallengesToround(chlngIds, round);
        return new ResponseEntity<>("0", HttpStatus.OK);
    }

    @RequestMapping(value="/round/{roundid}/Challenges", method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeChallengesFromRound(@RequestBody int[] chlngIds, @PathVariable("roundid") String roundid, Principal principal){
        String user = principal.getName();
        Round round = dao.getRoundById(roundid);
        dao.removeChallengesFromround(chlngIds, round);
        return new ResponseEntity<>("0", HttpStatus.OK);
    }

    @RequestMapping(value="/round/{roundid}/Challenges", method = RequestMethod.GET)
    public QuestionList getChallenges(@PathVariable("roundid") String roundid, Principal principal){
        String user = principal.getName();
        Round round = dao.getRoundById(roundid);
        QuestionList questions = new QuestionList();
        questions.setqList(dao.getChallengesByRound(round));
        return questions;
    }

    @RequestMapping(value = "/available/{cname}", method = RequestMethod.GET)
    public ResponseEntity<Object> userAvailable(@PathVariable("cname") String cname) {
        if(dao.contestExist(cname)){
            return new ResponseEntity<>("1", HttpStatus.OK);
        }
        return new ResponseEntity<>("0", HttpStatus.OK);
    }
}