package com.codetheory.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.Contest;

import java.util.List;

@RestController
@RequestMapping(value="/contest")
public class ParticipateContoller {

    @Autowired
    ContestDAO dao;

    @RequestMapping (value="/{contestname}/isParticipated" ,method = RequestMethod.GET)
    // this method check whether user is participated in a contest or not
    public boolean checkParticipated(@PathVariable String contestname,Principal principal){

        boolean stat = false;

        try{
            stat = dao.isParticipated (principal.getName() , contestname);
         } catch(NullPointerException np){
             return false;              // if user is not logged in
        }
        
        return stat;
    }

    @RequestMapping (value="/{contestname}/participate" ,method = RequestMethod.GET)
    public boolean participate(@PathVariable String contestname,Principal principal){

        try{
            dao.participate (principal.getName() , contestname);
        }
        catch(NullPointerException np){
            return false;              // if user is not logged in
        }
        return true;
    }
/*
    @RequestMapping (value = "/participation" , method = RequestMethod.GET)
    public List<Contest> userParticipation (Principal principal){
        return dao.getUserParticipation (principal.getName());
    }
*/
    @RequestMapping (value = "/{contest}/remove")
    public void removeParticipation ( @PathVariable String contest, Principal principal){
        dao.removeParticipation(principal.getName(), contest);
    }
}