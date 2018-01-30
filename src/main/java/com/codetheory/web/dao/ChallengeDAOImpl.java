package com.codetheory.web.dao;

import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.model.QuizQuestion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate; 

public class ChallengeDAOImpl implements ChallengeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addQuestion(QuizQuestion ques) {
        String sql = "insert into User values(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[] {
                //employee.getId(), employee.getAge(), employee.getDept(), employee.getName()
        });
    }

    // Getting a particular Quesiton
    public QuizQuestion getQuestionById(int id) {
        String sql = "select * from quiz_question where id=?";
        QuizQuestion question = new QuizQuestion();
        return jdbcTemplate.queryForObject (sql , new Object[]{id} , new QuizQuestionMapper());
    }

    public List<QuizQuestion> getAllQuestion() {
        String sql = "select * from quiz_question order by rand() limit 50";
        return jdbcTemplate.query(sql, new QuizQuestionMapper());
        
    }

	@Override
	public void addChallengeGroup(ChallengeGroup cg) {
		String sql = "insert into challengegroup(name, owner, type) values(?,?,?)";
        jdbcTemplate.update(sql, new Object[] {
            cg.getName(), cg.getOwner(), cg.getChallengeType().getValue()
        });
	}

	@Override
	public List<ChallengeGroup> getChallengeGroups(String user) {
		return jdbcTemplate.query("select * from challengegroup",new RowMapper<ChallengeGroup>(){  
            @Override  
            public ChallengeGroup mapRow(ResultSet rs, int rownumber) throws SQLException {  
                ChallengeGroup cg=new ChallengeGroup();  
                cg.setGroupId(rs.getString("challengegroupid"));
                int i = Integer.parseInt(rs.getString("type"))-1;
                cg.setChallengeType(ChallengeType.values()[i]);
                cg.setOwner(rs.getString("owner"));
                cg.setName(rs.getString("name"));
                return cg;
            }  
        });  
	}

	@Override
	public boolean challengeGroupExist(String name, String user) {
		String sql = "select (1) as Flag from challengegroup A inner join user_challengegroup_map B on A.ChallengeGroupId = B.challengegroupid where A.Name = ? and B.user = ?";
        return (jdbcTemplate.queryForList(sql, name, user).size() > 0);
	}
}