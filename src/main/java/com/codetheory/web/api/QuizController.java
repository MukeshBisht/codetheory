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
import com.codetheory.web.model.QuizQuestion;
import com.codetheory.web.model.Status;
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
										 @PathVariable ("round") String round  ) {

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
		ObjectMapper mapper = new ObjectMapper();
		JudgeOutput output = new JudgeOutput();
		JudgeData payload = new JudgeData(input);
		HttpClient httpClient;
		String postUrl = "https://api.judge0.com/submissions?wait=true";
		try {
			if (input.getcode().trim() == "") {
				//throw new Exception("Empty Code");
				output.setStatus(new Status(6, "Empty Code"));
			}
			StringEntity entity = new StringEntity(mapper.writeValueAsString(payload));
			httpClient = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(postUrl);
			request.setEntity(entity);
			request.setHeader("Content-type", "application/json");
			HttpResponse response = httpClient.execute(request);
			String _out = EntityUtils.toString(response.getEntity());
			output = mapper.readValue(_out, JudgeOutput.class);
		} catch (UnknownHostException uhe) {
			output.setStatus(new Status(6, "Can't compile at the moment, retry in a while"));
		} catch (Exception exp) {
			output.setStatus(new Status(6, exp.toString()));
		}
		return output;
	}
	
}