package com.codetheory.web.api;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.codetheory.web.dao.QuestionDAO;
import com.codetheory.web.model.QuizQuestion;

import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.ResultSetExtractor;  
import org.springframework.jdbc.core.RowMapper;  

@RestController
public class QuizController {

	@Autowired
	QuestionDAO dao;
	
	@RequestMapping(value = "/quiz", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<QuizQuestion> createQuiz() {
		List<QuizQuestion> quizquestion = dao.getAllQuestion();
		return quizquestion;
	}
}