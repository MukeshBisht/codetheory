package com.codetheory.web.controller;


import com.codetheory.web.dao.UserDAO;
import com.codetheory.web.dao.UserDAOImpl;
import com.codetheory.web.viewModel.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

    @Autowired
    UserDAO dao;

    @RequestMapping (method=RequestMethod.GET )
    public String register(Model model){
        model.addAttribute("registerForm", new Register());
        return "register";
    }

    @RequestMapping(method=RequestMethod.POST )
    public String register(@ModelAttribute("registerForm") Register reg){
        UserDAOImpl dao = new UserDAOImpl();
        dao.registerUser(reg);
        return "home";
    }
}