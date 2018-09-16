package com.codetheory.web.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.codetheory.web.constant.OrganizationType;
import com.codetheory.web.model.Contest;
import com.codetheory.web.constant.ContestStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContestMapper implements RowMapper<Contest> {

    @Autowired
    ContestDAO dao;

    @Override
    public Contest mapRow(ResultSet rs, int rowNum) throws SQLException {
        //2018-02-09 09:00:00 / 2018-01-26 08:54:22

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Contest con = new Contest();
        con.setContestname(rs.getString("contestname"));
        con.setinfo(rs.getString("info"));
        OrganizationType ot = OrganizationType.values()[Integer.parseInt(rs.getString("orgType")) - 1];
        con.setOrgType(ot);
        con.setOrgName(rs.getString("orgName"));
        con.sethasTimeLimit(rs.getBoolean ("roundTimelimit"));
        con.setIsOpen(rs.getBoolean("openPractice"));
        
        /* contest status 

        if (dao.isContestEnded (con.getContestname())) {
            con.setStatus (ContestStatus.ENDED);
        }
        
        else if (dao.isContestNotStarted (con.getContestname())){
            con.setStatus (ContestStatus.NOTSTARTED);
        }

        else if (dao.isContestStarted (con.getContestname())){
            con.setStatus (ContestStatus.RUNNING);
        }
        else {
            con.setStatus (null);
        }

         */
        con.setStatus (ContestStatus.RUNNING);
        
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