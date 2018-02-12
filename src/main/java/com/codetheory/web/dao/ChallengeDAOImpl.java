package com.codetheory.web.dao;

import com.codetheory.web.model.CodeQuestion;
import com.codetheory.web.constant.ChallengeType;
import com.codetheory.web.model.ChallengeGroup;
import com.codetheory.web.model.QuizQuestion;
import com.codetheory.web.model.Test;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.JdbcTemplate;

public class ChallengeDAOImpl implements ChallengeDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // JdbcTemplate setter
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addQuestion(QuizQuestion ques, String user, int group) {
        BaseStoredProcedure sp = new BaseStoredProcedure(jdbcTemplate, "addQuestion");
        String[] opt = ques.getOptions();
        SqlParameter params[] = new SqlParameter[] { new SqlParameter("ques", Types.VARCHAR),
                new SqlParameter("op1", Types.VARCHAR), new SqlParameter("op2", Types.VARCHAR),
                new SqlParameter("op3", Types.VARCHAR), new SqlParameter("op4", Types.VARCHAR),
                new SqlParameter("lvl", Types.INTEGER), new SqlParameter("ans", Types.INTEGER),
                new SqlParameter("grp", Types.INTEGER), new SqlParameter("usr", Types.VARCHAR), };
        sp.setParameters(params);
        sp.compile();
        sp.execute(ques.getQuestion(), opt[0], opt[1], opt[2], opt[3], ques.getLevel(), ques.getSelected(), group, user);
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

        String query = "select C.ChallengeGroupId, C.Name, C.Owner, C.Type, count(QM.Id) as Challenges, CM.user from challengegroup C ";
        query += "inner join user_challengegroup_map CM ";
        query += "on C.ChallengeGroupId = CM.challengegroupid ";
        query += "left join question_challengegrp_map QM ";
        query += "on C.ChallengeGroupId = QM.ChallengeGrpId ";
        query += "group by CM.challengegroupid ";
        query += "having CM.user=?; ";
        return jdbcTemplate.query(query,new String[]{user},new RowMapper<ChallengeGroup>(){  
            @Override  
            public ChallengeGroup mapRow(ResultSet rs, int rownumber) throws SQLException {  
                ChallengeGroup cg=new ChallengeGroup();  
                cg.setGroupId(rs.getString("challengegroupid"));
                int i = Integer.parseInt(rs.getString("type"))-1;
                cg.setChallengeType(ChallengeType.values()[i]);
                cg.setOwner(rs.getString("owner"));
                cg.setName(rs.getString("name"));
                cg.setChallengeCount(rs.getInt("Challenges"));
                return cg;
            }  
        });  
	}

	@Override
	public boolean challengeGroupExist(String name, String user) {
		String sql = "select (1) as Flag from challengegroup A inner join user_challengegroup_map B on A.ChallengeGroupId = B.challengegroupid where A.Name = ? and B.user = ?";
        return (jdbcTemplate.queryForList(sql, name, user).size() > 0);
	}
    @Override
    public ChallengeGroup getChallengeById(String id) {
        String sql = "select challengegroupid, type, owner, name from challengegroup where challengegroupid=?";
        return jdbcTemplate.queryForObject(sql, new String[] { id }, new ChallengeMapper());
    }

    @Override
    public List<QuizQuestion> getAllQuestion(String groupid) {
        String sql = "SELECT Q.Id, Q.question, Q.option1, Q.option2, Q.option3, Q.option4, Q.answer, Q.level FROM quiz_question Q ";
        sql += "inner join question_challengegrp_map M on Q.id = M.QuestionId ";
        sql += "where M.ChallengeGrpId = ? ";
        return jdbcTemplate.query(sql, new String[] { groupid },  new QuizQuestionMapper()); 
    }

    @Override
    public Boolean checkAnswerById (int id , int selected){
        String sql = "select (1) from quiz_question where id=? and answer=?";
        Boolean result = (jdbcTemplate.queryForList(sql, new Object[]{id,selected}).size() > 0);
        return result;
    }

    @Override
    public int getAnswerById(int id) {
        String sql = "select answer from quiz_question where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},Integer.class);
    }

	@Override
	public boolean isUsersQuestion(int qid, String userid) {
		String sql = "select 1 as flag from question_challengegrp_map where QuestionId = ? and userid = ?";
        return (jdbcTemplate.queryForList(sql, qid, userid).size() > 0);
	}

	@Override
	public void deleteQuestion(QuizQuestion question) {
		String sql = "delete from quiz_question where id=?";
        jdbcTemplate.update(sql, new Object[] {
            question.getId()
        });
	}

	@Override
	public void updateQuestion(QuizQuestion question) {
		String sql = "update quiz_question set question=?, option1=?, option2=?, option3=?, option4=?, answer=?, level=? where id =?";
        String ops[] = question.getOptions();
        jdbcTemplate.update(sql, new Object[] {           
            question.getQuestion(), ops[0], ops[1], ops[2], ops[3], question.getSelected(), question.getLevel(), question.getId()
        });
    }
    
    // Code Question methods implementation
    
    
    public void addCodeQuestion(CodeQuestion ques, String user, int group) {
        BaseStoredProcedure sp = new BaseStoredProcedure(jdbcTemplate, "addCodeQuestion");

      /*  JSONPObject test = new JSONPObject(ques.getTests());
       *  -- Serialization --
       */

      // TESTING
        String test = "[{ id: 1,input: \"world\",output: \"hello world\", points:10 },{id: 2,input: \"sam\", output: \"hello sam\",points:20}]";
        SqlParameter params[] = new SqlParameter[] { new SqlParameter("ques", Types.VARCHAR),
                new SqlParameter("detail", Types.VARCHAR), new SqlParameter("lvl", Types.INTEGER),
                new SqlParameter("test", Types.VARCHAR), };
        sp.setParameters(params);
        sp.compile();
        sp.execute(ques.getQuestion(), ques.getDetails(), ques.getLevel(), test);
    }

    @Override
    public CodeQuestion getCodeQuestionById(int id){
        String sql = "select * from code_question where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CodeQuestionMapper());   
    }

    @Override
    public List<CodeQuestion> getAllCodeQuestion(){
        String sql = "select * from code_question ";//inner join test_case on code_question.id = test_case.id";
        return jdbcTemplate.query(sql, new CodeQuestionMapper());
        
    }
}