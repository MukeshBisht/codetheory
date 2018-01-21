package com.codetheory.web.model;

public class Code {

    private String languageid;
    private String code;

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

    public String getcode(){
        return code;
    }

    public void setcode(String cod){
        code = cod;
    }
}