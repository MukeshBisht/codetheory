package com.codetheory.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

import com.codetheory.web.dao.ContestDAO;

@RestController
@RequestMapping(value="/contest/{contestname}")
public class ParticipateContoller {

    @Autowired
    ContestDAO dao;

    @RequestMapping (value="/isParticipated" ,method = RequestMethod.GET)
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

    @RequestMapping (value="/participate" ,method = RequestMethod.GET)
    public boolean participate(@PathVariable String contestname,Principal principal){

        try{
            dao.participate (principal.getName() , contestname);
        }
        catch(NullPointerException np){
            return false;              // if user is not logged in
        }

        return true;
    }
}