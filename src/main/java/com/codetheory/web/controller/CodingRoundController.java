package com.codetheory.web.controller;

import com.codetheory.web.dao.ContestDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/codinground")
public class CodingRoundController {

	@Autowired
	ContestDAO contest_dao;
	 
	@RequestMapping(method = RequestMethod.GET)
	public String round(Model model) {
				
		model.addAttribute("contestname", "yoyo");
		model.addAttribute("round" , contest_dao.getRoundById("12"));
		return "codinground";
    }
}