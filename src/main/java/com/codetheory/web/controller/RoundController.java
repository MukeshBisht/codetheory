package com.codetheory.web.controller;


import java.util.List;
import java.security.Principal;
import java.util.Date;

import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.Round;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Round/{contestname}")
public class RoundController {

    @Autowired
    ContestDAO dao;
    

    @RequestMapping (method = RequestMethod.GET, value = "/quiz")
    public String round (@PathVariable ("contestname") String contestName, Model model) {

        model.addAttribute("contestname", contestName);
		model.addAttribute("round" , new Round ("quiz", ChallengeType.MCQ));

		return "roundone";
    }


    @RequestMapping (method = RequestMethod.GET)
    public String round (@PathVariable("contestname") String contestName, 
                         Model model,
                        Principal principal){
                           
        String username = principal.getName();

        if (dao.isParticipated(username, contestName) == false) {
            return "contestAlreadyStarted";
        }

        Round round = dao.getRoundByDate(contestName, new Date());
        String roundName = round.getName();


        if (contestName == "practice"){
            
        }

        if (round == null)
            return "contestEnd";

        //checking if user has already made a submission
        if (dao.isUserAlreadySubmitted (contestName, roundName, username ) == true){
            
            Round nextRound = dao.getNextRound (contestName, new Date());
            if (nextRound == null)
                return "contestEnd";
            else {
                model.addAttribute("nextRound", nextRound);
                return "timer";
            }
        }
        
        try{
            ChallengeType type = round.getType();
    
            model.addAttribute("contestname" , contestName);
            model.addAttribute("round" , round);

            if (type.getValue() == 1)
                return "roundone";
    
            else if (type.getValue() == 2)
                return "codinground";
            
            else
                return "/Error";
        
        }catch(Exception e){
            return "/Error";
    }
    }
}