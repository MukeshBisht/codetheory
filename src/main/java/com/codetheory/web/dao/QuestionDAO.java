package com.codetheory.web.dao;

import com.codetheory.web.model.QuizQuestion;

import java.util.List;

public interface QuestionDAO {
    public void addQuestion(QuizQuestion question);
    public QuizQuestion getQuestionById(int id);
    public List<QuizQuestion> getAllQuestion ();
}