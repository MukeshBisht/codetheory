package com.codetheory.web.dao;

import org.apache.http.impl.conn.tsccm.RouteSpecificPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.model.Contest;
import com.codetheory.web.model.Question;
import com.codetheory.web.model.Round;
import com.codetheory.web.model.UserContestMap;
import com.codetheory.web.model.ContestStandingMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

public class ContestDAOImpl implements ContestDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public void addContest(Contest con, String user) {
		String sql = "insert into contests (contestName , orgType , orgName , startDate , endDate , creationDate,info, roundTimelimit, openPractice) values (? ,? , ? , ? , ? , ?, ?, ?, ?)";
        jdbcTemplate.update(sql , new Object[] {
            con.getContestname(), con.getOrgType().getValue(), con.getOrgName(), con.getStartDate(), con.getEndDate(), con.getCreationDate(), con.getinfo(), con.gethasTimeLimit(), con.getIsOpen()
        });
        sql = "insert into User_contests (contest , user, role) values (? , ?, ?)";
        jdbcTemplate.update(sql , new Object[] {
            con.getContestname(), user, "owner"
        });
	}


	@Override
	public void addRound(Round round) {
		String sql = "INSERT INTO round (contest, Name, Type, startTime, endTime) values (? ,? ,? ,?, ?)";
        jdbcTemplate.update(sql , new Object[] {
           round.getContest(), round.getName(), round.getType().getValue(), round.getStartTime(), round.getEndTime()
        });
	}

	@Override
	public Contest getContestById(String id) {
		String sql = "SELECT * FROM contests C inner join user_contests UC on C.contestName = UC.contest where UC.contest = ?";
		List<Contest> cons = jdbcTemplate.query(sql, new String[] { id }, new ContestMapper());
		if (cons.size() > 0)
			return cons.get(0);
		return null;
	}

	@Override
	public List<Contest> getAllContest(){
		String sql = "SELECT * FROM contests";
		return jdbcTemplate.query(sql , new ContestMapper());	
	}

	public boolean validUserContest(String user, String contest){
		String sql = "SELECT (1) as Flag FROM contests C inner join user_contests UC on C.contestName = UC.contest where UC.user = ? and UC.contest = ?";
        return (jdbcTemplate.queryForList(sql, user, contest).size() > 0);
	}

	@Override
	public boolean contestExist(String name) {
        String sql = "select (1) as Flag from Contests where contestname=?";
        return (jdbcTemplate.queryForList(sql, name).size() > 0);
	}

	@Override
	public List<Contest> getContestsByUser(String username){
		String sql = "SELECT * FROM contests C inner join user_contests UC on C.contestName = UC.contest where UC.user = ?";
		return jdbcTemplate.query(sql, new String[]{username}, new ContestMapper());
	}

	@Override
	public Contest getContestByName(String contestName) {
		String sql = "SELECT * FROM contests where contestName=?";
		return jdbcTemplate.queryForObject(sql, new String[]{contestName},new ContestMapper());
	}
	
	@Override
	public void addModerators(String con, String user) {		
        String sql = "insert into User_contests (contest , user, role) values (? , ?, ?)";
        jdbcTemplate.update(sql , new Object[] {
            con, user, "moderator"
        });
	}

	@Override
	public List<UserContestMap> getContestsEditors(String contest) {
		String sql = "select * from User_contests where contest = ?";
		return jdbcTemplate.query(sql, new String[]{contest}, new UserContestMapper());
	}

	@Override
	public void removeEditor(String user, String contest) {
		String sql = "delete from User_contests where user = ? and contest = ? and role = ?";
        jdbcTemplate.update(sql , new Object[] {
            user, contest, "moderator"
        });
	}


	@Override
	public List<Round> getRounds(String contest) {
		String sql = "select * from round where contest = ?";
		return jdbcTemplate.query(sql, new String[]{contest}, new RoundMapper());
	}


	@Override
	public boolean roundExist(Round round) {
		String sql = "select (1) as Flag from round where Name=? AND contest = ?";
        return (jdbcTemplate.queryForList(sql, round.getName(), round.getContest()).size() > 0);
	}


	@Override
	public void deleteRound(Round round) {
		String sql = "delete from round where roundid=?";
        jdbcTemplate.update(sql , new Object[] {
		   round.getRoundId()
        });
	}


	@Override
	public Round getRoundById(String id) {
		String sql = "select * from round where Roundid = ?";
		return jdbcTemplate.queryForObject(sql, new String[]{id}, new RoundMapper());
	}


	@Override
	public void addChallengesToround(int[] ids, Round round) {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
		String sql = "insert ignore into round_challenges_map (roundid, questionid)";
			   sql += "select :r as Roundid, id from"; 
		if(round.getType() == ChallengeType.MCQ)
			sql += " quiz_question ";
		if(round.getType() == ChallengeType.Code)
			sql += " code_question ";
		sql += "where id in (:ids);";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Integer> IDs = new ArrayList<Integer>();
		for(int i=0;i<ids.length;i++)
			IDs.add(ids[i]);
		params.put("ids", IDs);
		params.put("r", round.getRoundId());
		template.update(sql, params);
	}


	@Override
	public List<Question> getChallengesByRound(Round round) {		
		String sql = "select q.id, q.question, q.level from";
		if(round.getType() == ChallengeType.Code)
			sql += " code_question q ";
		if(round.getType() == ChallengeType.MCQ)
			sql += " quiz_question q ";
		sql += "where q.id in (select questionid from round_challenges_map where roundid = ?);";
		return jdbcTemplate.query(sql, new Integer[]{round.getRoundId()}, new QuestionMapper());
	}


	@Override
	public void removeChallengesFromround(int[] ids, Round round) {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
		String sql = "delete from round_challenges_map ";
			   sql += "where Roundid = :r and questionid in (:ids);";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Integer> IDs = new ArrayList<Integer>();
		for(int i=0;i<ids.length;i++)
			IDs.add(ids[i]);
		params.put("ids", IDs);
		params.put("r", round.getRoundId());
		template.update(sql, params);
	}

	@Override
	public int participate (String user, String contest){
		
		String sql = "insert into contest_participation (contest_id , user_id) values (? , ?);";
		return jdbcTemplate.update (sql , new Object[]{contest , user});
		
	}

	@Override
	public boolean isParticipated (String user , String contest){
		String sql = "select (1) from contest_participation where user_id=? and contest_id=?";
		return 
			(jdbcTemplate.queryForList(sql, user , contest).size() > 0);
	}

	@Override
	public void removeParticipation (String username , String contest){
		String sql = "DELETE FROM contest_participation WHERE user_id=? and contest_id=?";
		jdbcTemplate.update(sql , username , contest);
	}

	@Override
	public List<Contest> getUserParticipation (String username){
		String sql = "select * from contests where contestName in (select contest_id from contest_participation where user_id=?)";
		
		return jdbcTemplate.query(sql ,new String[]{username} , new ContestMapper());
	}

	@Override
	public List<Integer> getAllRoundType (String contest){
		String sql = "select Type from round where contest = ?";

		return null;
	}


	@Override
	public void addSubmissionScore (int roundId, String username, String contestName, double score) {
		String sql  = "insert into round_submission (contest , username, score, round_id) values (?, ?, ? ,?)";
		jdbcTemplate.update(sql, new Object[] {
			contestName, username, score, roundId,
		});
	}

	@Override
	public void addSubmissionFromCodeSubmission(String roundid, String user){
		String sql  = "insert into round_submission (username, score, round_id, contest) ";
			sql += "select user, sum(score), ?, (select contest from round where roundid = ?) from code_submission where user=?;";
			jdbcTemplate.update(sql, new Object[] {
				roundid, roundid, user
			});
	}

	@Override
	public boolean isUserAlreadySubmitted (int roundId, String username, String contestName) {

		String sql = "select (1) from round_submission where contest = ? and username = ? and round_id = ?";
		return jdbcTemplate.queryForList (sql, new Object[] {
			contestName, username, roundId
		}).size()>0;
	}


	@Override
	public void updateContest(Contest con) {
		String sql = "update contests set orgType=?, orgName=?, startDate=?, endDate=?, info=?, roundTimelimit=?, openPractice=? where contestName =?"; 
        jdbcTemplate.update(sql, new Object[] {           
            con.getOrgType().getValue(), con.getOrgName(), con.getStartDate(), con.getEndDate(), con.getinfo(), con.gethasTimeLimit(), con.getIsOpen(), con.getContestname()
		});
	}

	@Override
	public boolean isContestStarted (String contestName) {

		Date current = new Date();
		String sql = "select (1) from contests where contestName = ? and startDate < ? and endDate > ?";

		return jdbcTemplate.queryForList (sql, new Object[]{contestName, current, current}).size()>0;
	}


	@Override
	public boolean isContestNotStarted (String contestName) {
		
		Date current = new Date();
		String sql = "select (1) from contests where contestName = ? and startDate > ?";
		
		return jdbcTemplate.queryForList (sql, new Object[]{contestName, current}).size()>0;
	}


	@Override
	public boolean isContestEnded (String contestName) {
		Date current = new Date();
		String sql = "select (1) from contests where contestName = ? and endDate < ?";
		return jdbcTemplate.queryForList (sql, new Object[]{contestName, current}).size() > 0;
	}


	@Override
	public List<Round> getAllRounds (String contest) {

		String sql = "select * from round where contest = ?";
		return jdbcTemplate.query (sql, new Object[]{contest}, new RoundMapper());
	}


	@Override
	public void addUpdateCodeCheckPoint(String user,float max_exe_time,int roundid,Double score,String code,int languageid,int questionid) {
		String sql = "replace into code_submission ( user, max_exe_time, roundid, score, code, languageid, questionid)";
			sql += "values (?, ?, ?, ?, ?, ?, ?);";
		//values ('user', 3, 12, 50, 'void main(){return0;}', 11, 14)
		jdbcTemplate.update(sql, new Object[] {           
            user,max_exe_time, roundid, score, code, languageid, questionid
		});
	}


	@Override
	public String getSavedCode(String user, int roundid, int questionid) {
		String sql = "select code from code_submission where roundid=? and questionid=? and user=?;";
		try{
		return jdbcTemplate.queryForObject(sql, new Object[]{roundid, questionid, user}, String.class);
		}catch(org.springframework.dao.EmptyResultDataAccessException e){
			System.out.println("no previous checkpoint");
			return "";
		}
	}


	@Override
	public boolean showResult (int roundId, String contestName) {
		String sql = "select showResult from round where contest = ? and roundid = ?";
		
		return jdbcTemplate.queryForObject (sql, new Object[]{contestName, roundId}, Integer.class) == 0;
		
	}


	@Override
	public boolean roundHasTimelimit (String contestName) {
		String sql = "select roundTimelimit from contests where contestName = ?";
		
		return jdbcTemplate.queryForObject (sql, new Object[] {contestName}, Boolean.class);
		
	}

	@Override
	public int getNumberOfParticipants (String contest) {
		String sql = "select count(1) from contest_participation where contest_id = ?";
		return jdbcTemplate.queryForObject (sql, new Object[] {contest}, Integer.class );
	}

	@Override
	public List<ContestStandingMap> getContestStandings (String contestName){

		String sql = "select contest, username, sum(score) from round_submission where contest = ? group by (username)";
		return jdbcTemplate.query (sql, new Object[]{contestName}, new ContestStandingMapper());
	}

	@Override
	public int getRoundIdByName (String name, String contest) {
		String sql = "select roundid from round where name = ? and contest = ?";
		return jdbcTemplate.queryForObject (sql, new Object[]{name, contest}, Integer.class);
	}
}
