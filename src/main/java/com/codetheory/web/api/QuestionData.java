package com.codetheory.web.api;

import com.codetheory.web.model.QuizQuestion;
import java.util.List;

public class QuestionData{

    private List<QuizQuestion> data;

	/**
	 * @return the data
	 */
	public List<QuizQuestion> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<QuizQuestion> data) {
		this.data = data;
	}
}