package com.codetheory.web.model;

public class UserContestMap{

    private String user;
    private String contest;
    private String role;
    
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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
}