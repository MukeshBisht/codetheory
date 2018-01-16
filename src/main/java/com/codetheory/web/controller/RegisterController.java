package com.codetheory.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    @RequestMapping ( value="/register" , method=RequestMethod.GET )
    public String register (ModelMap model){
        /* After verifying email id, Put Everything in DB then
         *
         *  
         */
        return "register";
    }

    // @RequestMapping ( value="/register" , method=RequestMethod.POST )
    // public String register (ModelMap model){
    //     /* After verifying email id, Put Everything in DB then
    //      *
    //      *  
    //      */
    //     return "register";
    // }
}