package com.codetheory.web.dao;

import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.model.QuizQuestion;

import java.util.List;

public interface ChallengeDAO {

    public void addChallengeGroup(ChallengeGroup cg);
    public List<ChallengeGroup> getChallengeGroups(String user);
    public boolean challengeGroupExist(String name, String user);

    //need changes
    public void addQuestion(QuizQuestion question);
    public QuizQuestion getQuestionById(int id);
    public List<QuizQuestion> getAllQuestion ();
}