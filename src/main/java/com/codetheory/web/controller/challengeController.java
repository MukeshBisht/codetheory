package com.codetheory.web.controller;

import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.viewModel.GroupChallenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/challenge")
public class challengeController {

    @Autowired
    ChallengeDAO dao;

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public String showGroups(Model model, Principal principal) {
        String name = principal.getName();
        List<ChallengeGroup> challengeGroups = dao.getChallengeGroups(name);
        ArrayList<ChallengeGroup> mcqs = new ArrayList<ChallengeGroup>();
        ArrayList<ChallengeGroup> codes = new ArrayList<ChallengeGroup>();
        GroupChallenge gc = new GroupChallenge();
        for (ChallengeGroup var : challengeGroups) {
            if (var.getChallengeType() == ChallengeType.MCQ) {
                mcqs.add(var);
            }
            if (var.getChallengeType() == ChallengeType.Code) {
                codes.add(var);
            }
        }
        gc.setCodeGroups(codes);
        gc.setMcqGroups(mcqs);
        model.addAttribute("user", name);
        model.addAttribute("challenge", gc);
        return "ChallengeGroup";
    }

    @RequestMapping(value = "/group/manage/{id}", method = RequestMethod.GET)
    public String manageGroups(Model model, @PathVariable("id") String id, Principal principal) {
        String user = principal.getName();
        ChallengeGroup cgrp = dao.getChallengeById(id);
        if (cgrp != null) {
            if (dao.challengeGroupExist(cgrp.getName(), user)) {
                model.addAttribute("grpid", id);
                model.addAttribute("grpname", cgrp.getName());              
                if(cgrp.getChallengeType() == ChallengeType.MCQ){
                    return "manageMCQGroup";
                }
                else
                {
                    
                    return "manageCodeGroup";
                }
            }
        }
        return "redirect:/challenge/group";
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    public String addGroup(HttpServletRequest request, Principal principal) {
        String user = principal.getName();
        String name = request.getParameter("name");
        String ctype = request.getParameter("ctype").trim();
        //System.out.println(ctype);
        if (!dao.challengeGroupExist(name, user)) {
            ChallengeGroup cg = new ChallengeGroup();
            cg.setName(name);
            cg.setOwner(user);
            if (ctype.equals("mcq")) {
                cg.setChallengeType(ChallengeType.MCQ);
            }
            if (ctype.equals("code")) {
                cg.setChallengeType(ChallengeType.Code);
            }
            //cg.setChallengeType(ChallengeType.Code);
            dao.addChallengeGroup(cg);
        }else{

        }
        return "redirect:/challenge/group";
    }
}