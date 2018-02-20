package com.codetheory.web.model;

public class QuizQuestion extends Question implements IQuestion{

    private String options[];
    private int selected;

    public QuizQuestion() {
        options = new String[4];
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