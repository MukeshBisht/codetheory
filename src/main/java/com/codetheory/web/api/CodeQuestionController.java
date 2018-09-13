package com.codetheory.web.api;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.codetheory.web.dao.ChallengeDAO;
import com.codetheory.web.dao.ContestDAO;
import com.codetheory.web.model.CodeQuestion;

@RestController
public class CodeQuestionController {

	@Autowired
	ChallengeDAO dao;

	@Autowired
	ContestDAO con_dao;

	@RequestMapping(value = "codinground/{roundid}/question", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<CodeQuestion> getCodeQuestion(@PathVariable String roundid) {
		List<CodeQuestion> questions = dao.getCodeQuestionByRound(roundid);
		return questions;
	}	


	@RequestMapping(value = "/code/{grpid}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public CodeQuestionData createCode(@PathVariable int grpid) {
		List<CodeQuestion> codequestion = dao.getAllCodeQuestionByGroup(grpid);
		CodeQuestionData data = new CodeQuestionData();
		data.setData(codequestion);
		return data;
	}	

	@RequestMapping(value = "codinground/{roundid}/{questionid}", method = RequestMethod.GET)
	@ResponseBody
	public String getCodeFromCheckPoint(@PathVariable int roundid, @PathVariable int questionid, Principal principal){
		String uname = principal.getName();
		String code = con_dao.getSavedCode(uname, roundid, questionid);		
		if(code=="") code = "//write your first code";
		return code;
	}
}