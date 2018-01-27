package com.codetheory.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codetheory.web.model.User;
import com.codetheory.web.dao.UserDAO;

@Controller
@RequestMapping("/user")
public class ProfileController {

	@Autowired
	UserDAO dao;
	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public ModelAndView getProfile( Principal principal) {
		ModelAndView modelandview = new ModelAndView("profile");
		User user;
		user = dao.getUserByUsername (principal.getName());
		modelandview.addObject("username" , principal.getName() );
		modelandview.addObject(user);
		System.out.println(user.getEmail());
		return modelandview;
	}	
}