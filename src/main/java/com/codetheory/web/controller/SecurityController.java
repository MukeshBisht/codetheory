package com.codetheory.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController{
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            request.getSession().invalidate();
        }
        
        return "home";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response){
        //return "redirect:"+request.getRequestURL().toString() + "?" + request.getQueryString();

        return "home";
    }
}