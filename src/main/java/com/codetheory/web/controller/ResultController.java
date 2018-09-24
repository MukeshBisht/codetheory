package com.codetheory.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.QuizQuestion;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value ="/{contestname}/{round}")
public class ResultController {

    @Autowired
	ChallengeDAO dao;

	@Autowired
	ContestDAO contestDao;

    @RequestMapping (method=RequestMethod.GET, value="/result" )
    public String showResult(Model model){
        
        return "result";
    }


	@RequestMapping ( value="/submit" ,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ModelAndView submitRoundOne (@PathVariable("contestname") String contestName,
										@PathVariable ("round") String roundName,
										@RequestBody List<QuizQuestion> question,
										Principal principal ){
		
		ModelAndView model;

        /*************************** CALCULATING SCORE ***************************/
        float score = 0; int marks = 0;
		List <String> correctAnswer = new ArrayList<>();

		for (QuizQuestion ques : question) {
			
            int ans = dao.getAnswerById(ques.getId());
			correctAnswer.add(ques.getOptions()[ans]);
			
				if (ans == ques.getSelected()){	
					marks += 1;
				} 
			}
        
            if (question.size() > 0)
                score = marks/question.size()*100;

        /*********************************************************************************/

		//user's score will not be saved in practice contests
		
		
		if (contestName.equals("practice")){
			model = new ModelAndView ("result");		
			model.addObject("nextround", "/contest/practice/codinground");
			model.addObject ("question", question);
			model.addObject ("answer",correctAnswer);
			model.addObject ("marks", marks);
			model.addObject ("total", question.size());
			return model;
		}
		
		else {
			int roundId = contestDao.getRoundIdByName (roundName, contestName);

			if (contestDao.contestExist(contestName)) {
				contestDao.addSubmissionScore (roundId, principal.getName(), contestName, score);
			}
			
			if (!contestDao.showResult (roundId, contestName)) {
				return null;
			}
	
		}
		
		model = new ModelAndView ("result");
		
		model.addObject ("question", question);
		model.addObject ("answer",correctAnswer);
		model.addObject ("marks", marks);
		model.addObject ("total", question.size()*10);
		
        //user's score is saved
		return model;
    }
    
}