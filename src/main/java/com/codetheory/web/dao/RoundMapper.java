package com.codetheory.web.dao;


import org.springframework.jdbc.core.RowMapper;
import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.model.Round;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoundMapper implements RowMapper<Round> {

    @Override
    public Round mapRow(ResultSet rs, int rowNum) throws SQLException {
        Round round = new Round();
        round.setContest(rs.getString("contest"));
        round.setLength(rs.getInt("length"));
        round.setName(rs.getString("name"));
        round.setType(ChallengeType.values()[rs.getInt("type")-1]);
        round.setRoundId(rs.getInt("roundid"));
        return round;
    }
}