package com.codetheory.web.dao;

import org.springframework.jdbc.core.RowMapper;
import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.model.ChallengeGroup;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChallengeMapper implements RowMapper<ChallengeGroup> {

    @Override
    public ChallengeGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
        ChallengeGroup cg = new ChallengeGroup();
        cg.setGroupId(rs.getString("challengegroupid"));
        int i = Integer.parseInt(rs.getString("type")) - 1;
        cg.setChallengeType(ChallengeType.values()[i]);
        cg.setOwner(rs.getString("owner"));
        cg.setName(rs.getString("name"));
        return cg;
    }

}