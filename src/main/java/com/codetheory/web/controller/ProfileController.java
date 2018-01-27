package com.codetheory.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.servlet.ModelAndView;

import com.codetheory.web.model.User;
import com.codetheory.web.dao.UserDAO;

@Controller
@RequestMapping("/user/profile")
public class ProfileController {

	@Autowired
	UserDAO dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getProfile( Principal principal) {
		ModelAndView modelandview = new ModelAndView("profile");
		User user;
		user = dao.getUserByUsername (principal.getName());
		modelandview.addObject(user);
		return modelandview;
	}	

	@RequestMapping (method = RequestMethod.POST)
	public ModelAndView setProfile (@ModelAttribute("updateForm") User userDetail ,Principal principal){
		ModelAndView modelandview = new ModelAndView("profile");
		String username = principal.getName();
		userDetail.setUsername (username);
		dao.updateUser(userDetail);
		modelandview.addObject(userDetail);
		return modelandview;
	}

	@RequestMapping (value="/changePass" , method = RequestMethod.POST)
	public ModelAndView changePassword (@RequestParam ("password")String password ,
									@RequestParam ("newpassword")String newpassword , 
									Principal principal ){
		dao.updateUser (password , newpassword , principal.getName());
		return new ModelAndView("redirect:/user/profile");
	}
}