package com.codetheory.web.controller;


import java.util.ArrayList;
import java.util.List;
import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.model.QuizQuestion;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/{contestname}/quiz/Round/{round}")
public class RoundOneController {

	@Autowired
	ChallengeDAO dao;

	@RequestMapping(method = RequestMethod.GET)
	public String roundOne(@PathVariable("contestname") String contestName, 
						@PathVariable("round") String rno, Model model) {
	//	rno = Integer.toString(Integer.parseInt(rno)+1);

		model.addAttribute("contestname", contestName);
		model.addAttribute("round" , rno);

		return "roundone";
	}

	@RequestMapping ( value="/submit" ,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ModelAndView submitRoundOne (@PathVariable("contestname") String contestName, 
										@PathVariable("round") String rno,
										@RequestBody List<QuizQuestion> question ){
		
		ModelAndView model = new ModelAndView ("result");
		int marks=0;
		List <String> correctAnswer = new ArrayList<>();
		rno = Integer.toString( Integer.parseInt(rno)+1);
		for (QuizQuestion var : question) {
			
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

		if (contestName.equals("practice"))
			model.addObject("nextround", "/RoundThree");
		else
			model.addObject("nextround", "/Round/"+contestName+"/"+rno);

		return model;
	}	
}