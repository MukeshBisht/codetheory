package com.codetheory.web.api;

import com.codetheory.web.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserDAO dao;
    
    @RequestMapping(value = "/available/{uname}", method = RequestMethod.GET)
    public ResponseEntity<Object> userAvailable(@PathVariable("uname") String uname) {
        if(dao.userExist(uname)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}