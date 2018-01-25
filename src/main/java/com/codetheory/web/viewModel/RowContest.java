package com.codetheory.web.viewModel;

import java.util.Date;

public class RowContest {

    private String contestid;
    private String contestName;
    private Date startingDate;
    private Date creationDate;
    private String status;
    private int participants;

	/**
	 * @return the contestName
	 */
	public String getContestName() {
		return contestName;
	}
	/**
	 * @param contestName the contestName to set
	 */
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}
	/**
	 * @return the startingDate
	 */
	public Date getStartingDate() {
		return startingDate;
	}
	/**
	 * @param startingDate the startingDate to set
	 */
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
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
	/**
	 * @return the contestid
	 */
	public String getContestid() {
		return contestid;
	}
	/**
	 * @param contestid the contestid to set
	 */
	public void setContestid(String contestid) {
		this.contestid = contestid;
	}
}