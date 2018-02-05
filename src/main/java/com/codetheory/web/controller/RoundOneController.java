package com.codetheory.web.controller;


import java.util.ArrayList;
import java.util.List;
import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.model.QuizQuestion;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/RoundOne")
public class RoundOneController {

	@Autowired
	ChallengeDAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public String RoundOne(Model model) {
		return "roundone";
	}

	@RequestMapping ( value="/submit" ,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ModelAndView submitRoundOne (@RequestBody List<QuizQuestion> question ){
		
		ModelAndView model = new ModelAndView ("result");
		int marks=0;
		List <String> correctAnswer = new ArrayList<>();

		for (QuizQuestion var : question) {
			
			int selected = var.getSelected();
			int ans = dao.getAnswerById(var.getId());
			
			correctAnswer.add(var.getOptions()[ans]);
			
				if (ans == var.getSelected()){	
					marks += 10;
				} 
			}
		
		model.addObject ("question", question);
		model.addObject ("answer",correctAnswer);
		model.addObject ("marks", marks);
		model.addObject ("total", question.size()*10);

		return model;
	}	
}