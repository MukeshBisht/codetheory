package com.codetheory.web.dao;

import org.springframework.jdbc.core.RowMapper;
import com.codetheory.web.model.Question;
import com.codetheory.web.model.QuizQuestion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {

    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question=new QuizQuestion();  
        question.setId(rs.getInt("id"));
        question.setQuestion(rs.getString("question"));
        question.setLevel(rs.getInt("level"));
        return question;
    }
}