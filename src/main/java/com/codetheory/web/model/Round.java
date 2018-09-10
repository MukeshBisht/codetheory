package com.codetheory.web.model;

import com.codetheory.web.constant.ChallengeType;
import java.util.Date;

public class Round{
    
	private int roundId;
    private String contest;
    private String name;
    private ChallengeType type;
	private Date startTime;
	private Date endTime;

	/**
	 * @return the roundId
	 */

	public Round (){
		startTime = new Date();
		endTime = new Date();
	}

	public Round (String name, ChallengeType type){
		this();
		this.name = name;
		this.type = type;
	}

	public int getRoundId() {
        return roundId;
	}
	/**
	 * @param roundId the roundId to set
	 */
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}
	/**
	 * @return the contest
	 */
	public String getContest() {
		return contest;
	}
	/**
	 * @param contest the contest to set
	 */
	public void setContest(String contest) {
		this.contest = contest;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public ChallengeType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ChallengeType type) {
		this.type = type;
	}

	public void setStartTime (Date startTime){
		this.startTime = startTime;
	}

	public Date getStartTime (){
		return startTime;
	}


	public void setEndTime (Date startTime){
		this.startTime = startTime;
	}

	public Date getEndTime (){
		return endTime;
	}

}