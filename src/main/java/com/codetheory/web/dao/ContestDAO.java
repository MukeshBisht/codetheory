package com.codetheory.web.dao;

import com.codetheory.web.model.Contest;
import com.codetheory.web.model.Round;
import com.codetheory.web.model.UserContestMap;
import java.util.List;

public interface ContestDAO {
    public void addContest(Contest con, String user);
    public void addModerators(String con, String user);
    public List<UserContestMap> getContestsEditors(String contest);
    public List<Contest> getAllContest();
    public Contest getContestById(String id);
    public boolean contestExist(String name);
    public boolean validUserContest(String user, String contest);
    public Contest getContestByContestName(String contestName);
    public List<Contest> getContestsByUser(String username);
    public void removeEditor(String user, String contest);
    public void addRound(Round round);
    public List<Round> getRounds(String contest);
}