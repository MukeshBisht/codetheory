package com.codetheory.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.codetheory.web.model.Contest;
import java.util.List;

public class ContestDAOImpl implements ContestDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public void addContest(Contest con, String user) {
		String sql = "insert into contests (contestName , orgType , orgName , startDate , endDate , creationDate) values (? , ? , ? , ? , ?, ?)";
        jdbcTemplate.update(sql , new Object[] {
            con.getContestname(), con.getOrgType().getValue(), con.getOrgName(), con.getStartDate(), con.getEndDate(), con.getCreationDate()
        });
        sql = "insert into User_contests (contest , user, role) values (? , ?, ?)";
        jdbcTemplate.update(sql , new Object[] {
            con.getContestname(), user, "owner"
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
}