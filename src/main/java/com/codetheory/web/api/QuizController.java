package com.codetheory.web.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.model.Code;
import com.codetheory.web.model.CodeQuestion;
import com.codetheory.web.model.QuizQuestion;
import com.codetheory.web.model.Status;
import com.codetheory.web.model.Test;
import com.codetheory.web.util.Judge0;
import com.codetheory.web.util.OnlineJudge;
import com.codetheory.web.model.JudgeOutput;
import com.codetheory.web.model.OnlineJudgeResult;
import java.security.Principal;
import com.codetheory.web.dao.ContestDAO;

@RestController
public class QuizController {

	@Autowired
	ChallengeDAO dao;
	@Autowired
	ContestDAO cdao;
	
	@RequestMapping(value = "/quiz/question/{contestname}/{round}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<QuizQuestion> createQuiz(@PathVariable ("contestname") String contestName ,
										 @PathVariable ("round") String roundName  ) {

		List<QuizQuestion> quizquestion;
		
		if (contestName.equals("practice"))
			quizquestion = dao.getAllQuestion();
		
		else {
			quizquestion = dao.getQuizQuestionByRound (contestName, roundName);		//contestname and round_number
		}
		return quizquestion;
	}


	@RequestMapping(value = "/api/execode", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public OnlineJudgeResult executeCode(@RequestBody Code input, Principal principal) {
		OnlineJudgeResult result = new OnlineJudgeResult();
		ArrayList<Status> status = new ArrayList<Status>();
		if (input.getcode().trim() == "") {
			result.setStderr("Empty code");
			return result;
		}

		OnlineJudge judge = new Judge0();
		CodeQuestion question = dao.getCodeQuestionById(input.getquestionid());
		ArrayList<Test> tests = question.getTests();
		float max_exe_time=0.0f;
		Double score=0.0;

		try {
			List<JudgeOutput> results = judge.judge(input, tests, question.getTimeLimit(), question.getMemoryLimit(), score);
			
			for (JudgeOutput _output : results) {
				max_exe_time = (_output.getTime() > max_exe_time)?_output.getTime():max_exe_time;				
				status.add(_output.getStatus());
			}		

			//save code check point if user logged in
			addUpdateCheckPoint(principal, input, max_exe_time, score);
		}catch (IOException uhe) {
			result.setStderr("Can't compile at the moment, retry in a while");
		}

		result.setStatus(status);
		return result; 
	}

	private void addUpdateCheckPoint(Principal p, Code code, float max_exe_time, Double score){
		if(p == null) return;

		String user = p.getName();
		int languageid = Integer.parseInt(code.getlanguageid());
		cdao.addUpdateCodeCheckPoint(user, max_exe_time, code.getroundid(), score, code.getcode(), languageid, code.getquestionid());
	}
}