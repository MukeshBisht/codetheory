package com.codetheory.web.viewModel;

import com.codetheory.web.model.Contest;
import java.util.List;

public class CreateContest{

    private Contest contest;
    private List<RowContest> myContests;
    
	/**
	 * @return the contest
	 */
	public Contest getContest() {
		return contest;
	}
	/**
	 * @param contest the contest to set
	 */
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	/**
	 * @return the myContests
	 */
	public List<RowContest> getMyContests() {
		return myContests;
	}
	/**
	 * @param myContests the myContests to set
	 */
	public void setMyContests(List<RowContest> myContests) {
		this.myContests = myContests;
	}

}