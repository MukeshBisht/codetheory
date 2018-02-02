package com.codetheory.web.dao;

import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.model.QuizQuestion;

import java.util.List;

public interface ChallengeDAO {

    public void addChallengeGroup(ChallengeGroup cg);
    public List<ChallengeGroup> getChallengeGroups(String user);
    public boolean challengeGroupExist(String name, String user);
    public ChallengeGroup getChallengeById(String id);

    //need changes
    public void addQuestion(QuizQuestion question, String user, int group);
    public QuizQuestion getQuestionById(int id);
    public List<QuizQuestion> getAllQuestion ();   
    public List<QuizQuestion> getAllQuestion (String groupid);
    public Boolean checkAnswerById (int id , int selected);
}