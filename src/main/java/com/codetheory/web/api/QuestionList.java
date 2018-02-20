package com.codetheory.web.api;

import com.codetheory.web.model.Question;
import java.util.List;

public class QuestionList{
	private List<Question> qList;

	/**
	 * @return the qList
	 */
	public List<Question> getqList() {
        return qList;
	}

	/**
	 * @param qList the qList to set
	 */
	public void setqList(List<Question> qList) {
		this.qList = qList;
	}
}