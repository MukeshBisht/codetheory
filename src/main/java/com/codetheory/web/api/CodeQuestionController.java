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

import com.codetheory.web.model.CodeQuestion;

@RestController
public class CodeQuestionController {

	@Autowired
	ChallengeDAO dao;

	@RequestMapping(value = "/code", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public CodeQuestionData createCode() {
		List<CodeQuestion> codequestion = dao.getAllCodeQuestion();
		CodeQuestionData data = new CodeQuestionData();
		data.setData(codequestion);
		return data;
	}	
}