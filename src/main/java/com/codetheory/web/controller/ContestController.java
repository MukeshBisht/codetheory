package com.codetheory.web.controller;


import com.codetheory.web.model.Contest;
import com.codetheory.web.viewModel.CreateContest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contest")
public class ContestController {

	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createContest(Model model) {
		CreateContest con = new CreateContest();
		con.setContest(new Contest());
		model.addAttribute("newContest", con);
		model.addAttribute("contest", con.getContest());
		return "createContest";
	}
	
	@RequestMapping(value="/manage/{id}", method = RequestMethod.GET)
	public String manageContest(Model model) {
		return "manageContest";
	}
	
}