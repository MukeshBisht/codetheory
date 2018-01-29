package com.codetheory.web.model;

import com.codetheory.web.constant.ChallengeType;

public class ChallengeGroup{

    private String groupId;
    private String name;
    private String owner;
    private ChallengeType challengeType;

	
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
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the challengeType
	 */
	public ChallengeType getChallengeType() {
		return challengeType;
	}
	/**
	 * @param challengeType the challengeType to set
	 */
	public void setChallengeType(ChallengeType challengeType) {
		this.challengeType = challengeType;
	}
}