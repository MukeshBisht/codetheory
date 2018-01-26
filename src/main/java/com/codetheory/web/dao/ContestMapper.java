package com.codetheory.web.dao;

import org.springframework.jdbc.core.RowMapper;

import com.codetheory.web.constant.OrganizationType;
import com.codetheory.web.model.Contest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContestMapper implements RowMapper<Contest> {

    @Override
    public Contest mapRow(ResultSet rs, int rowNum) throws SQLException {
        //2018-02-09 09:00:00 / 2018-01-26 08:54:22
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Contest con = new Contest();
        con.setContestname(rs.getString("contestname"));
        OrganizationType ot = OrganizationType.values()[Integer.parseInt(rs.getString("orgType")) - 1];
        con.setOrgType(ot);
        con.setOrgName(rs.getString("orgName"));
        try {
            con.setStartDate(formatter.parse(rs.getString("startDate")));
            con.setEndDate(formatter.parse(rs.getString("endDate")));
            con.setCreationDate(formatter.parse(rs.getString("creationDate")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return con;
    }

}