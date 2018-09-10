package com.codetheory.web.api;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.net.UnknownHostException;
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
import com.codetheory.web.model.JudgeData;
import com.codetheory.web.model.JudgeOutput;

import org.codehaus.jackson.map.ObjectMapper;
import org.apache.http.HttpResponse;

import org.springframework.ui.Model;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.HttpClientBuilder;

import com.codetheory.web.model.Round;
import com.codetheory.web.dao.ContestDAO;

@RestController
public class QuizController {

	@Autowired
	ChallengeDAO dao;
	@Autowired
	ContestDAO cdao;
	

	@RequestMapping(value = "/quiz/question/{contestname}/{round}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<QuizQuestion> createQuiz(@PathVariable ("contestname") String cname ,
										 @PathVariable ("round") String round ) {

		List<QuizQuestion> quizquestion;
		if (cname.equals("practice"))
			quizquestion = dao.getAllQuestion();
		
		else {
			int r = Integer.parseInt(round);
			Round _round = cdao.getRounds(cname).get(r-1);
						
			quizquestion = dao.getQuizQuestionByRound(_round);		//contestname and round_number
		}
		return quizquestion;
	}

	@RequestMapping(value = "/api/execode", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public JudgeOutput executeCode(@RequestBody Code input) {
		String postUrl = "https://api.judge0.com/submissions?wait=true";
		JudgeOutput output = new JudgeOutput();
		if (input.getcode().trim() == "") {
			//throw new Exception("Empty Code");
			output.setStatus(new Status(6, "Empty Code"));
			return output;
		}

		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Test> tests = dao.getCodeQuestionById(input.getquestionid()).getTests();
		
		Status status = new Status();
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			for (Test test : tests) {
				JudgeData payload = new JudgeData(input);
				payload.setStdin(test.getInput());
				payload.setExpected_output(test.getOutput());

				StringEntity entity = new StringEntity(mapper.writeValueAsString(payload));
				HttpPost request = new HttpPost(postUrl);
				request.setEntity(entity);
				request.setHeader("Content-type", "application/json");
				HttpResponse response = httpClient.execute(request);
				String _out = EntityUtils.toString(response.getEntity());
				JudgeOutput _output = mapper.readValue(_out, JudgeOutput.class);

				if(status.getId() < _output.getStatus().getId()){
					status.setId(_output.getStatus().getId());
					status.setDescription(_output.getStatus().getDescription());

					output.setStderr(_output.getStderr());
					output.setCompile_output(_output.getCompile_output());
					output.setStdout(_output.getStdout());
				}
			}
		} catch (IOException uhe) {
			output.setStatus(new Status(6, "Can't compile at the moment, retry in a while"));
		} 
		
		output.setStatus(status);
		return output;
	}
	
}