package com.codetheory.web.api;

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
    public QuizQuestion createQuiz() {
		QuizQuestion question = new QuizQuestion();
		question.setQuestion("What is JAVA?");
		question.setCorrect("JAVA IS AN OOP LANGUAGE");
			String options[] = new String[4];
			options[0] = "JAVA IS AN OOP LANGUAGE";
			options[1] = "JAVA IS AN OOD LANGUAGE";
			options[2] = "JAVA IS AN OOA LANGUAGE";
			options[3] = "JAVA IS AN OBP LANGUAGE";
		question.setOptions(options);
		return question;
	}
}