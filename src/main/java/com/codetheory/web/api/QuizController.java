package com.codetheory.web.api;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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


@RestController
public class QuizController {

	@Autowired
	ChallengeDAO dao;

	@RequestMapping(value = "/quiz", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<QuizQuestion> createQuiz() {
		List<QuizQuestion> quizquestion = dao.getAllQuestion();
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
				throw new Exception("Empty Code");
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
	
	@RequestMapping ( value="/roundOne/submit" ,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Object[] submitRoundOne (@RequestBody List<QuizQuestion> question , Model model){
		
		String html = "";

		int marks=0, qno=0;

		for (QuizQuestion var : question) {
			
				html += "<tr>" ;
				html += "<td>" + ++qno + "</td>";
				html += "<td>" + var.getQuestion() + "</td>";
			
			int selected = var.getSelected();
			int ans = dao.getAnswerById(var.getId());
				html += "<td class=\"text-success\">" + var.getOptions()[ans] +"</td>";
				
			if (var.getSelected() != -1) {
				if (ans == selected)
					html += "<td class=\"text-success\">" + var.getOptions()[selected] +"</td>";
				else
					html += "<td class=\"text-danger\">" + var.getOptions()[selected] +"</td>";
				
				if (ans == var.getSelected()){	
					marks += 10;
						html += "<td class=\"text-success\"> +10 </td>";
				} else
						html += "<td class=\"text-danger\"> 0 </td>";
			} else{
				
				html += "<td class=\"text-danger\"> Not attempted </td>";
				html += "<td class=\"text-danger\"> Not attempted </td>";
			}

			html += "</tr>";
		}
		
		return new Object[]{html , marks ,(question.size()*10)};
	}
}