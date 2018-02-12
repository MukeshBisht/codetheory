package com.codetheory.web.api;

import com.codetheory.web.model.CodeQuestion;
import java.util.List;

public class CodeQuestionData{

    private List<CodeQuestion> data;

	/**
	 * @return the data
	 */
	public List<CodeQuestion> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<CodeQuestion> data) {
		this.data = data;
	}
}