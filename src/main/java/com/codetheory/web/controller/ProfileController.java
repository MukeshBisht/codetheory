package com.codetheory.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import com.codetheory.web.model.User;
import com.codetheory.web.model.Contest;
import com.codetheory.web.dao.UserDAO;
import com.codetheory.web.dao.ContestDAO;
import java.util.List;


@Controller
@RequestMapping("/user/profile")
public class ProfileController {

	@Autowired
	UserDAO dao;

	@Autowired
	ContestDAO contestDao;
	
	@RequestMapping(method = RequestMethod.GET)
	
	public String getProfile(Model model,  Principal principal) {
		
		if (principal == null) {
			return "redirect:/home";
		}
		
		User user = dao.getUserByUsername (principal.getName());
		List<Contest> contests = contestDao.getUserParticipation (principal.getName());
		model.addAttribute("user", user);
		model.addAttribute ("contestList", contests);

		return "profile";
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