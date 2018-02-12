package com.codetheory.web.dao;

import org.springframework.jdbc.core.RowMapper;

import com.codetheory.web.constant.OrganizationType;
import com.codetheory.web.model.CodeQuestion;
import com.codetheory.web.model.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CodeQuestionMapper implements RowMapper<CodeQuestion> {

    @Override
    public CodeQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        CodeQuestion question=new CodeQuestion();  
        question.setId(rs.getInt("id"));
        question.setLevel(rs.getInt("level"));
        question.setQuestion(rs.getString("question"));
        question.setDetails(rs.getString("details"));
        /*
        ArrayList<Test> testcase = new ArrayList<>();
        
        while (rs.next()){
            Test test = new Test();
                test.setId(rs.getInt("test_id"));
                test.setInput(rs.getString("input"));
                test.setOutput(rs.getString("output"));
                test.setPoints(rs.getInt("points"));
            testcase.add(test);
        }
        
        question.setTests(testcase);
*/
        return question;
    }

}