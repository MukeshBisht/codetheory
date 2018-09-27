package com.codetheory.web.util;

import java.util.ArrayList;
import java.util.List;

import com.codetheory.web.model.Code;
import com.codetheory.web.model.Test;

import java.io.IOException;
import com.codetheory.web.model.JudgeData;
import com.codetheory.web.model.JudgeOutput;
import org.codehaus.jackson.map.ObjectMapper;
import org.apache.http.entity.StringEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.apache.http.impl.client.HttpClientBuilder;

public class Judge0 implements OnlineJudge {

    private final String postUrl = "https://api.judge0.com/submissions?wait=true";
    ObjectMapper mapper = new ObjectMapper();

	@Override
	public JudgeResult judge(Code code, List<Test> tests, float timelimit, int memorylimit) throws IOException{

        HttpClient httpClient = HttpClientBuilder.create().build();
        JudgeResult result = new JudgeResult();  
        double total = 0.0;
        double points = 0.0;
        for (Test test : tests) {
			JudgeData payload = new JudgeData(code);
            
            payload.setStdin(test.getInput());            
            payload.setExpected_output(test.getOutput());
            payload.setCpu_time_limit(timelimit + "");
            payload.setMemory_limit(memorylimit + "");

			StringEntity entity = new StringEntity(mapper.writeValueAsString(payload));
			HttpPost request = new HttpPost(postUrl);
			request.setEntity(entity);
			request.setHeader("Content-type", "application/json");
			HttpResponse response = httpClient.execute(request);
			String _out = EntityUtils.toString(response.getEntity());
            JudgeOutput _output = mapper.readValue(_out, JudgeOutput.class);
            if(_output.getStatus().getId() == 3)
                points += (double)test.getPoints();
            total += (double)test.getPoints();
            result.addResult(_output);
        }
        result.setScore(points/total);
        return result;
    }
}