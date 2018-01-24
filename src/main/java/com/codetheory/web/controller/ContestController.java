package com.codetheory.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contest")
public class ContestController {

	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createContest(Model model) {
		return "createContest";
	}
	
	@RequestMapping(value="/manage", method = RequestMethod.GET)
	public String manageContest(Model model) {
		return "manageContest";
	}
	
}