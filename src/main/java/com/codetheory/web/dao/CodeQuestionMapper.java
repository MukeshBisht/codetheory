package com.codetheory.web.dao;

import java.util.List;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.jdbc.core.RowMapper;

import com.codetheory.web.constant.OrganizationType;
import com.codetheory.web.model.CodeQuestion;
import com.codetheory.web.model.Test;

import java.io.IOException;
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

        ArrayList<Test> test = new ArrayList<>();
        
        try{
            
            String test_case = rs.getString("test_case");
            ObjectMapper mapper = new ObjectMapper();
            test = mapper.readValue(test_case, ArrayList.class);

        }catch(Exception e){
            e.printStackTrace();
        }

        question.setTests(test);
        return question;
    }

}