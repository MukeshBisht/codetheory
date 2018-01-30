package com.codetheory.web.dao;

import org.springframework.jdbc.core.RowMapper;

import com.codetheory.web.constant.OrganizationType;
import com.codetheory.web.model.QuizQuestion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizQuestionMapper implements RowMapper<QuizQuestion> {

    @Override
    public QuizQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuizQuestion question=new QuizQuestion();  
                
        question.setQuestion(rs.getString("question"));
         String op[] = new String[4];
         op[0] = rs.getString("option1");
         op[1] = rs.getString("option2");
         op[2] = rs.getString("option3");
         op[3] = rs.getString("option4");
         question.setOptions(op);
         return question;
    }

}