package com.codetheory.web.viewModel;

import com.codetheory.web.model.Contest;

public class RowContest extends Contest{

	//Contest
	// private String contestname;
	// private Date startDate;
	// private Date endDate;
	// private Date creationDate;
	// private String orgName;
	// private OrganizationType orgType;

	public RowContest(){
		super.setContestname("Java9");
		status = "not started";
	}
	public RowContest(Contest con){
		super(con);
		status = "not started";
	}

    private String status;
	private int participants;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the participants
	 */
	public int getParticipants() {
		return participants;
	}
	/**
	 * @param participants the participants to set
	 */
	public void setParticipants(int participants) {
		this.participants = participants;
	}
}