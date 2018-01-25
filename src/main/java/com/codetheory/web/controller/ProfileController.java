package com.codetheory.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class ProfileController {

	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public String getProfile(Model model) {
		return "profile";
	}	
}