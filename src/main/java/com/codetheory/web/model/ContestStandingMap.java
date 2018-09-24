package com.codetheory.web.model;

public class ContestStandingMap {

    private String username;
    private String contest;
    private float score;

    public void setUsername (String username){
        this.username = username;
    }

    public String getUsername (){
        return username;
    }

    public void setContestName (String contest){
        this.contest = contest;
    }

    public String getContestName (){
        return contest;
    }

    public void setScore (float score){
        this.score = score;
    }

    public float getScore (){
        return score;
    }
}