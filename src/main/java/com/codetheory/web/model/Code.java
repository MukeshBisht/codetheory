package com.codetheory.web.model;

public class Code {

    private String languageid;
    private String code;
    private int questionid;
    private int roundid;

    public Code(){

    }

    public Code(String lid, String cod){
        languageid = lid;
        code = cod;
    }

    public String getlanguageid(){
        return languageid;
    }

    public void setlanguageid(String id){
        languageid = id;
    }

    public int getquestionid(){
        return questionid;
    }

    public void setquestionid(int qid){
        questionid = qid;
    }

    public String getcode(){
        return code;
    }

    public void setcode(String cod){
        code = cod;
    }

    public void setroundid(int id){
        roundid = id;
    }

    public int getroundid(){
        return roundid;
    }
}