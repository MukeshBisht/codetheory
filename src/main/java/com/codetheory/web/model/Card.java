package com.codetheory.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Card {
    private int comId;
    private String name;
    private Date startDate;
    private ArrayList<String> tags;
    private String info;
    private String organiser;
    private int participants;

    public Card() {

    }

    public Card(int id, String name, String info) {
        this.comId = id;
        this.name = name;
        this.info = info;

        participants = new Random().nextInt(1000);
        tags = new ArrayList<String>();
        tags.add("c");
        tags.add("c#");
        tags.add("python");
        tags.add("java");
    }

    public void setname (String name){
        this.name = name;
    }
    public String getname(){
        return this.name;
    }

    public void setinfo(String info){
        this.info = info;
    }
    public String getinfo(){
        return this.info;
    }

    public void setcomId(int id){
        this.comId = id;
    }
    public int getcomId(){
        return this.comId;
    }
    
    public void setstartDate(Date date){
        this.startDate = date;
    }
    public Date getstartDate(){
        return this.startDate;
    }

    public ArrayList<String> gettags(){
        return this.tags;
    }

    public void setorganiser(String organiser){
        this.organiser = organiser;
    }
    public String getorganiser(){
        return this.organiser;
    }

    public int getparticipants(){
        return this.participants;
    }
}