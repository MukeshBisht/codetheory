package com.codetheory.web.viewModel;

import com.codetheory.web.model.Contest;
import  com.codetheory.web.constant.ContestStatus;

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
		status = ContestStatus.NOTSTARTED;
	}
	public RowContest(Contest con){
		super(con);
		status = ContestStatus.NOTSTARTED;
	}

    private ContestStatus status;
	private int participants;
	
	/**
	 * @return the status
	 */
	public ContestStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(ContestStatus status) {
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