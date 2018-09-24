package com.codetheory.web.dao;
import com.codetheory.web.model.User;
import com.codetheory.web.viewModel.Register;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;


public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;
    
    public void addUser(User user) {
        String sql = "insert into User values(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[] {
                //employee.getId(), employee.getAge(), employee.getDept(), employee.getName()
        });
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Getting a particular user
    public User getUserById(int id) {
        String sql = "select * from User where id=?";
        return new User();
    }

    public User getUserByUsername(String username) {    
        try{
            String sql = "select * from Users where username=?";
            return jdbcTemplate.queryForObject(sql, new String[]{username}, new UserMapper());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }


    public void updateUser(User user) {

        String sql = "UPDATE users SET email=? , name=? WHERE username=?";
        jdbcTemplate.update (sql, new Object[] {
            user.getEmail(), 
            user.getName() ,
            user.getUsername()
        });
    }

    public int updateUser(String pass , String newpass , String username){

        String sql = "update users set password = if (password = ? , ?, password ) where username = ?";
        int status =jdbcTemplate.update (sql , new Object[]{
           pass , newpass , username 
        });
        return status;
    }


    public void deleteUser(int id) {

    }

    public boolean userExist(String username){
        String sql = "select * from Users where username=?";
        return (jdbcTemplate.queryForList(sql, username).size() > 0);
    }

    public List<User> getAllUsers() {
        return null;
    }

    //@Transactional(rollbackFor = Exception.class)
    public void registerUser (Register reg) {      
        String sql = "insert into users (username , password , enabled , name , email) values (? , ? , ? , ? , ?)";
        jdbcTemplate.update(sql , new Object[] {
            reg.getusername() , reg.getpassword() , 1 , reg.getname() , reg.getemail() 
        });
        sql = "insert into user_roles (username , role) values (? , ?)";
        jdbcTemplate.update(sql , new Object[] {
            reg.getusername() , "USER" 
        });
    
    }

    public List<String> suggest(String name) {
        String sql = "select username from Users where username like ?";
        return (List<String>)jdbcTemplate.queryForList(sql, new String[]{ name +'%' }, String.class);
    }

    @Override
    public User findUserByEmail(String userEmail) {
        try{
        String sql = "select * from Users where email=?";
        return jdbcTemplate.queryForObject(sql, new String[]{userEmail}, new UserMapper());
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public int changePassword(String password, String username) {
        String sql = "update users set password = ? where username = ?";
        int status =jdbcTemplate.update (sql , new Object[]{
           password, username 
        });
        return status;
    }
}