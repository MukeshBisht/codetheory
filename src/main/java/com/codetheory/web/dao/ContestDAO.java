package com.codetheory.web.dao;

import com.codetheory.web.model.Contest;
import com.codetheory.web.model.Question;
import com.codetheory.web.model.Round;
import com.codetheory.web.model.UserContestMap;
import java.util.List;
import java.util.Date;

public interface ContestDAO {
    public void addContest(Contest con, String user);
    public void updateContest(Contest con);

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

    public void addChallengesToround(int[] ids, Round round);
    public void removeChallengesFromround(int[] ids, Round round);
    public List<Question> getChallengesByRound(Round round);
    public List<Integer> getAllRoundType (String contest);

    //contest realated methods
    public boolean isContestEnded (String contestName);
    public boolean isContestNotStarted (String contestName);
    public boolean isContestStarted (String contestName);

    // contest participation methods
    public int participate (String user , String contest);
    public boolean isParticipated (String user , String contest);
    public void removeParticipation (String username , String contest);
    public List<Contest> getUserParticipation (String username);
    public int getNumberOfParticipation (String contest);


    // ROUND related methods
    public Round getRoundById(String id);
    public List<Round> getAllRounds (String contest);
    public boolean roundTimelimit (String contest);

    //round submission related methods
    public void addSubmissionScore (String contestName, String roundName, String username ,double score);
    public boolean isUserAlreadySubmitted (String contestName, String roundName, String username);

    //code submission
    public void addUpdateCodeCheckPoint(String user,float max_exe_time,int roundid,Double score,String code,int languageid,int questionid);
    public String getSavedCode(String user, int roundid, int questionid);
    public boolean showResult (String contest, String round);
}