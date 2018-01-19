package com.codetheory.web.dao;

import com.codetheory.web.model.QuizQuestion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addQuestion(QuizQuestion ques) {
        String sql = "insert into User values(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[] {
                //employee.getId(), employee.getAge(), employee.getDept(), employee.getName()
        });
    }

    // Getting a particular Quesiton
    public QuizQuestion getQuestionById(int id) {
        String sql = "select * from quiz_question where id=?";
        QuizQuestion question =(QuizQuestion)jdbcTemplate.queryForObject(sql, new Object[]{new Integer(id)},new RowMapper() {
        
            public Object mapRow (ResultSet rs , int arg) throws SQLException{
                QuizQuestion q = new QuizQuestion();
                q.setQuestion(rs.getString("question"));
                String op[] = new String[4];
                op[0] = rs.getString("option1");
                op[1] = rs.getString("option2");
                op[2] = rs.getString("option3");
                op[3] = rs.getString("option4");
                q.setOptions(op);
                return q;
            }
        });
        return question;
    }
 
    public List<QuizQuestion> getAllQuestion (){
        return new ArrayList<QuizQuestion>();
    }
}