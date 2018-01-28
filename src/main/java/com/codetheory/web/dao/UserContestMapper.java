package com.codetheory.web.dao;

import org.springframework.jdbc.core.RowMapper;
import com.codetheory.web.model.UserContestMap;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserContestMapper implements RowMapper<UserContestMap> {

    @Override
    public UserContestMap mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserContestMap con = new UserContestMap();
        con.setContest(rs.getString("contest"));
        con.setRole(rs.getString("role"));
        con.setUser(rs.getString("user"));
        return con;
    }

}