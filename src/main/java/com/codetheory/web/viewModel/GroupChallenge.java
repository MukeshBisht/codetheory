package com.codetheory.web.viewModel;

import com.codetheory.web.model.ChallengeGroup;
import java.util.List;

public class GroupChallenge{

    private List<ChallengeGroup> mcqGroups;
	private List<ChallengeGroup> codeGroups;

    
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
}