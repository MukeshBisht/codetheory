package com.codetheory.web.model;

import java.util.ArrayList;
import java.util.Date;

public class Card {
    private int comId;
    private String name;
    private Date startDate;
    private ArrayList<String> languages;
    private String info;

    public Card() {

    }

    public Card(int id, String name, String info) {
        this.comId = id;
        this.name = name;
        this.info = info;
        this.startDate = new Date();
        languages = new ArrayList<String>();
        languages.add("c");
        languages.add("c#");
        languages.add("python");
        languages.add("java");
    }

    public String getname(){
        return this.name;
    }

    public String getinfo(){
        return this.info;
    }

    public int getcomId(){
        return this.comId;
    }

    public Date getstartDate(){
        return this.startDate;
    }

    public ArrayList<String> getlanguages(){
        return this.languages;
    }
}