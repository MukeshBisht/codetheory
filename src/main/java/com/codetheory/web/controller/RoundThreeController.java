package com.codetheory.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/RoundThree")
public class RoundThreeController {

	@RequestMapping(method = RequestMethod.GET)
	public String RoundOne(Model model) {
		return "roundThree";
    }
}