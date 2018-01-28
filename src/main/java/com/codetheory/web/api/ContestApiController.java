package com.codetheory.web.api;

import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.UserContestMap;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        System.out.println(uc.getContest());
        System.out.println(uc.getUser());
        if(principal != null && dao.validUserContest(principal.getName(), uc.getContest())){
            dao.removeEditor(uc.getUser(), uc.getContest());
        }
    }
}