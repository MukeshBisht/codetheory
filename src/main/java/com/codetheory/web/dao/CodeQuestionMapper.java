package com.codetheory.web.dao;

import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.jdbc.core.RowMapper;

import com.codetheory.web.model.CodeQuestion;
import com.codetheory.web.model.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeQuestionMapper implements RowMapper<CodeQuestion> {

    @Override
    public CodeQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        CodeQuestion question=new CodeQuestion();  
        question.setId(rs.getInt("id"));
        question.setLevel(rs.getInt("level"));
        question.setQuestion(rs.getString("question"));
        question.setDetails(rs.getString("details"));

        ArrayList<Test> test = new ArrayList<Test>();
        
        try{           
            String test_case = rs.getString("test_case");
            test = fromJSON(new TypeReference<ArrayList<Test>>() {}, test_case);

        }catch(Exception e){
            e.printStackTrace();
        }

        question.setTests(test);
        return question;
    }

    private <T> T fromJSON(final TypeReference<T> type,final String jsonPacket) {
        T data = null;

        try {
            data = new ObjectMapper().readValue(jsonPacket, type);
        } catch (Exception e) {
        // Handle the problem
        }
        return data;
    }
}