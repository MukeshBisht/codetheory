package com.codetheory.web.api;

import com.codetheory.web.dao.UserDAO;
import com.codetheory.web.model.User;
import com.codetheory.web.util.Mailer;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserDAO dao;
    
    @RequestMapping(value = "/available/{uname}", method = RequestMethod.GET)
    public ResponseEntity<Object> userAvailable(@PathVariable("uname") String uname) {
        if(dao.userExist(uname)){
            return new ResponseEntity<>("1", HttpStatus.OK);
        }
        return new ResponseEntity<>("0", HttpStatus.OK);
    }

    @RequestMapping(value = "/suggestion/{uname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> userSuggestions(@PathVariable("uname") String uname) {
        return dao.suggest(uname);
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public ResponseEntity<Object> resetPassword(@RequestParam("email") String userEmail) {
        String response = "Email successfully sent, Please check your inbox.";
        User user = dao.findUserByEmail(userEmail);
        if(user == null)
            response = "This email address is not registered with us.";
        else {
            String password = UUID.randomUUID().toString().split("-")[0];

            String mailText = "Dear user,<br>";
            mailText += "<p style='margin-left:20px;'>your Codetheory username is <b>" + user.getUsername() + "</b></br>";
            mailText += "and your temporary password is <b>" + password + "</b></br>";
            mailText += "Please consider changing your password.";
            mailText += "</br>";
            mailText += "<button style='background-color:lightgreen'><a href='http://www.codetheory.in/'></a>go to codetheory</button>";
            mailText += "</p>";
            mailText += "Regards,</br>";
            mailText += "Codetheory";
            
            Mailer mailService = new Mailer();
            if(mailService.sendMail(user.getEmail(), "Password change", mailText)){
                dao.changePassword(password, user.getUsername());
            }
            else{
                response = "Can't send mail at this movement, please retry in a while.";
            }
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}