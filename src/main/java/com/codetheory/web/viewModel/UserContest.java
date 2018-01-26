package com.codetheory.web.viewModel;

import java.util.List;

public class UserContest{

	private List<RowContest> myContests;
	private String user;
    
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
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

}