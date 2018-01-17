package com.codetheory.web.api;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codetheory.web.model.QuizQuestion;

@RestController
public class QuizController {

	@RequestMapping(value = "/quiz", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ArrayList<QuizQuestion> createQuiz() {
		ArrayList<QuizQuestion> quizquestion = new ArrayList();

		QuizQuestion question = new QuizQuestion();
		question.setQuestion("What is JAVA?");
			String options[] = new String[4];
			options[0] = "JAVA IS AN OOP LANGUAGE";
			options[1] = "JAVA IS AN OOD LANGUAGE";
			options[2] = "JAVA IS AN OOA LANGUAGE";
			options[3] = "JAVA IS AN OBP LANGUAGE";
		question.setOptions(options);

		quizquestion.add(question);

		question=new QuizQuestion();

		question.setQuestion("What is Maven?");
			options[0] = "Maven is a Programming Language";
			options[1] = "Maven is a Build Tool";
			options[2] = "Maven is a Framework";
			options[3] = "None of these";
		question.setOptions(options);

		quizquestion.add(question);

		return quizquestion;
	}
}