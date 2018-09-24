package com.codetheory.web.controller;

import java.security.Principal;

import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.Contest;
import com.codetheory.web.model.Round;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/practice")
public class PracticeController {

	@Autowired
	private ContestDAO dao;

	@Autowired
	private ChallengeDAO chdao;

    @RequestMapping (method = RequestMethod.GET, value = "/quiz")
    public String quizRound (Model model) {

        model.addAttribute("contestname", "practice");
		model.addAttribute("round" , new Round ("quiz", ChallengeType.MCQ));
		model.addAttribute ("roundName", "Round");

		return "roundone";
    }

    @RequestMapping(value = "/codinground", method = RequestMethod.GET)
	public String codingRound(Model model) {
				
        model.addAttribute("contestname", "practice");
        Round round = new Round ("Coding", ChallengeType.Code);
        round.setRoundId(14);
		model.addAttribute("round" , round);
		return "codinground";
    }

    @RequestMapping (method = RequestMethod.GET, value = "open/{contest}")
	public String practice (@PathVariable("contest") String contestName, Principal principal){
       
        if(principal ==  null)
            return "signIn";
        
        Contest contest = dao.getContestByContestName(contestName); 

        //if the contest is not open
        if(!contest.getIsOpen())
            return "redirect:/contest/"+contestName;
        
        return "resultdummy";
	}

}