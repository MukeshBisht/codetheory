package com.codetheory.web.viewModel;

public class Register {

    private String username;
    private String password;
    private String name;
    private String email;
    private boolean newsletter = true;
    private boolean notifications = true;
    
    public String getusername(){
        return this.username;
    }

    public void setusername(String username){
        this.username = username;
    }

    public String getpassword(){
        return this.password;
    }

    public void setpassword(String password){
        this.password = password;
    }

    public String getemail(){
        return this.email;
    }

    public void setemail(String email){
        this.email = email;
    }
   
    public String getname(){
        return this.name;
    }

    public void setname(String name){
        this.name = name;
    }

    public boolean getnewsletter(){
        return this.newsletter;
    }

    public void setnewsletter(boolean newsletter){
        this.newsletter = newsletter;
    }

    public boolean getnotifications(){
        return this.notifications;
    }

    public void setnotifications(boolean notifications){
        this.notifications = notifications;
    }
}