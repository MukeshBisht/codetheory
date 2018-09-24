package com.codetheory.web.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer{  

    Properties props = new Properties();
    
    private final String email = "";
    private final String pass = "";
    
    public Mailer() {
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");
    }

    public boolean sendMail(String to, String sub, String msg){
        return send(email, pass, to, sub, msg);
    }

    private boolean send(String from, String password, String to, String sub, String msg){  
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setContent(msg, "text/html; charset=utf-8"); 
           //send message  
           Transport.send(message);
           return true; 
          } catch (MessagingException e) {
              System.out.println(e.getMessage());
            return false;
        }    
             
    }  
}  