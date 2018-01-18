package com.codetheory.web.dao;

import com.codetheory.web.model.QuizQuestion;

import java.util.List;

public interface QuestionDAO {
    public void addQuestion(Question question);
    public QuizQuestion getQuestionId(int id);
    public List<QuizQuestion> getAllQuestion ();
}