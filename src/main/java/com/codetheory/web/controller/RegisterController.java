package com.codetheory.web.controller;


import com.codetheory.web.dao.UserDAO;
import com.codetheory.web.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

    @Autowired
    UserDAO dao;

    @RequestMapping (method=RequestMethod.GET )
    public String register(ModelMap model){
        return "register";
    }

    @RequestMapping(method=RequestMethod.POST )
    public String register(@ModelAttribute User user){
        
        return "register";
    }

    @RequestMapping(value="/available/{username}", method=RequestMethod.GET)
    public ResponseEntity available(@PathVariable String username){
        if(dao.userExist(username)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}