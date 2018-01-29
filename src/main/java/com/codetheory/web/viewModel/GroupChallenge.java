package com.codetheory.web.viewModel;

import com.codetheory.web.model.ChallengeGroup;
import java.util.List;

public class GroupChallenge{

    private List<ChallengeGroup> mcqGroups;
	private List<ChallengeGroup> codeGroups;
	private int mcqCount;
	private int codeCount;

    
	/**
	 * @return the mcqGroups
	 */
	public List<ChallengeGroup> getMcqGroups() {
		return mcqGroups;
	}
	/**
	 * @param mcqGroups the mcqGroups to set
	 */
	public void setMcqGroups(List<ChallengeGroup> mcqGroups) {
		this.mcqGroups = mcqGroups;
		//this.setMcqCount(mcqGroups.size());
	}
	/**
	 * @return the codeGroups
	 */
	public List<ChallengeGroup> getCodeGroups() {
		return codeGroups;
	}
	/**
	 * @param codeGroups the codeGroups to set
	 */
	public void setCodeGroups(List<ChallengeGroup> codeGroups) {
		this.codeGroups = codeGroups;
		//this.setCodeCount(codeGroups.size());
	}
	/**
	 * @return the codeCount
	 */
	public int getCodeCount() {
		return codeCount;
	}
	/**
	 * @param codeCount the codeCount to set
	 */
	public void setCodeCount(int codeCount) {
		this.codeCount = codeCount;
	}
	/**
	 * @return the mcqCount
	 */
	public int getMcqCount() {
		return mcqCount;
	}
	/**
	 * @param mcqCount the mcqCount to set
	 */
	public void setMcqCount(int mcqCount) {
		this.mcqCount = mcqCount;
	}
    
}