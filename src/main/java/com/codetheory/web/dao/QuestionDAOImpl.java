package com.codetheory.web.dao;

import com.codetheory.web.model.Question;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class QuestionDAOImpl implements QuestionDAO {

    private JdbcTemplate jdbcTemplate;

    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addQuestion(Question ques) {
        String sql = "insert into User values(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[] {
                //employee.getId(), employee.getAge(), employee.getDept(), employee.getName()
        });
    }

    // Getting a particular Quesiton
    public QuizQuestion getQuestionBdId(int id) {
        String sql = "select * from Question where id=?";
        return new QuizQuestion();
    }


}