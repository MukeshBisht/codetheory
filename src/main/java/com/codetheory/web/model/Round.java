package com.codetheory.web.model;

import com.codetheory.web.constant.ChallengeType;

public class Round{
    
    private int roundId;
    private String contest;
    private String name;
    private int length;
    private ChallengeType type;

	/**
	 * @return the roundId
	 */
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
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
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
}