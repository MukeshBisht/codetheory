package com.codetheory.web.dao;

import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.model.QuizQuestion;
import com.codetheory.web.model.Round;
import com.codetheory.web.model.CodeQuestion;
import com.codetheory.web.model.Question;
import java.util.List;

public interface ChallengeDAO {

    //challenge
    public void addChallengeGroup(ChallengeGroup cg);
    public List<ChallengeGroup> getChallengeGroups(String user);
    public boolean challengeGroupExist(String name, String user);
    public ChallengeGroup getChallengeById(String id);
    public boolean isUsersQuestion(int qid, String userid);
    //question
    public void addQuestion(QuizQuestion question, String user, int group);
    public void deleteQuestion(QuizQuestion question);
    public void updateQuestion(QuizQuestion question);
    public QuizQuestion getQuestionById(int id);
    public List<QuizQuestion> getAllQuestion ();   
    public List<QuizQuestion> getAllQuestion (String groupid);
    public Boolean checkAnswerById (int id , int selected);
    public int getAnswerById (int id);

    public List<Question> getChallengesByGroup(ChallengeGroup group);
    
    public List<QuizQuestion> getQuizQuestionByRound (Round round);
    public List<CodeQuestion> getCodeQuestionByRound (Round round);
    
    //code question
    public void addCodeQuestion(CodeQuestion ques, String user, int group);
    public CodeQuestion getCodeQuestion();
    public CodeQuestion getCodeQuestionById(int id);
    public List<CodeQuestion> getAllCodeQuestion();
    public List<CodeQuestion> getAllCodeQuestionByGroup(int grpId);
    public void deleteCodeQuestion(int id);
    public void updateCodeQuestion(CodeQuestion question);
}