package com.codetheory.web.dao;

import com.codetheory.web.model.QuizQuestion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        QuizQuestion question = new QuizQuestion();
        Map row = jdbcTemplate.queryForMap(sql, id);
        String op[] = new String[4];
        op[0] = row.get("option1").toString();
        op[1] = row.get("option2").toString();
        op[2] = row.get("option3").toString();
        op[3] = row.get("option4").toString();
        question.setQuestion(row.get("question").toString());
        question.setOptions(op);
        return question;
    }

    public List<QuizQuestion> getAllQuestion() {
        return new ArrayList<QuizQuestion>();
    }
}