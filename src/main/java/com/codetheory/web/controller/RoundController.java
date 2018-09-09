package com.codetheory.web.controller;


import java.util.List;

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
@RequestMapping("/Round/{contestname}/{round}")
public class RoundController {

    @Autowired
    ContestDAO dao;
    
    @RequestMapping (method = RequestMethod.GET)
    public String round (@PathVariable("contestname") String cname,
                         @PathVariable("round") String rno, 
                         Model model){
                           
        List<Round> round = dao.getRounds(cname);
        int roundNum = Integer.parseInt(rno);
        
        if (roundNum > round.size())
            return "contestEnd";
        
        try{
            ChallengeType type = round.get(Integer.parseInt (rno)-1).getType();
    
            model.addAttribute("contestname" , cname);
            model.addAttribute("round" , rno);

            if (type.getValue() == 1)
                return "roundone";
    
            else if (type.getValue() == 2)
                return "codinground";
            
            else
                return "contestEnd";
        
        }catch(Exception e){
            return "contestEnd";
    }
    }
}