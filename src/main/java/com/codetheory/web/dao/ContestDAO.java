package com.codetheory.web.dao;

import com.codetheory.web.model.Contest;
import com.codetheory.web.model.Question;
import com.codetheory.web.model.Round;
import com.codetheory.web.model.UserContestMap;
import java.util.List;
import java.util.Date;

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
    public boolean roundExist(Round round);
    public void deleteRound(Round round);
    public List<Round> getRounds(String contest);
    public Round getRoundById(String id);
    public Round getRoundByDate (String contest, Date currentDate);
    public void addChallengesToround(int[] ids, Round round);
    public void removeChallengesFromround(int[] ids, Round round);
    public List<Question> getChallengesByRound(Round round);
    public List<Integer> getAllRoundType (String contest);

    // contest participation methods
    public int participate (String user , String contest);
    public boolean isParticipated (String user , String contest);
    public void removeParticipation (String username , String contest);
    public List<Contest> getUserParticipation (String username);


    public Round getNextRound (String contest,Date date);

    //round submission related methods
    public void addSubmissionScore (String contestName, String roundName, String username ,double score);
    public boolean isUserAlreadySubmitted (String contestName, String roundName, String username);

}