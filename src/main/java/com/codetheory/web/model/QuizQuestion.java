package com.codetheory.web.model;

public class QuizQuestion {
    private int id;
    private String question;
    private String options[];
    private int selected;

    public int getId (){
        return id;
    }
    public void setId (int id){
        this.id = id;
    }
    public QuizQuestion() {
        options = new String[4];
    }

    public void setQuestion (String question){
        this.question = question;
    }
    public String getQuestion (){
        return question;
    }
    public void setOptions (String options[]){
        for (int i=0; i<options.length; i++)
            this.options[i] = options[i];
    }
    public String[] getOptions (){
        return options;
    }

    public void setSelected (int selected){
        this.selected = selected;
    }
    public int getSelected (){
        return this.selected;
    }
}