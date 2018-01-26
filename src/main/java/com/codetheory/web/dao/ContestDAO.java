package com.codetheory.web.dao;

import com.codetheory.web.model.Contest;
import java.util.List;

public interface ContestDAO {
    public void addContest(Contest con, String user);
    public Contest getContestById(String id);
    public boolean contestExist(String name);
    public boolean validUserContest(String user, String contest);
    public List<Contest> getContestsByUser(String username);
}