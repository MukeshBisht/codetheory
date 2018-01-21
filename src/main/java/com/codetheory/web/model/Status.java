package com.codetheory.web.model;

public class Status
{
    private int id;

    private String description;

    public Status(){

    }

    public Status(int i, String des){
        this.id = i;
        this.description = des;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }
}