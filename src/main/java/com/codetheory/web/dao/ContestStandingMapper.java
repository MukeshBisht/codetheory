package com.codetheory.web.dao;

import org.springframework.jdbc.core.RowMapper;
import com.codetheory.web.model.ContestStandingMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContestStandingMapper implements RowMapper<ContestStandingMap> {

    @Override
    public ContestStandingMap mapRow(ResultSet rs, int rowNum) throws SQLException {

        ContestStandingMap standing = new ContestStandingMap();
        
        standing.setUsername (rs.getString("username"));
        standing.setContestName (rs.getString ("contest"));
        standing.setScore (rs.getFloat ("score"));

        return standing;

    }
}