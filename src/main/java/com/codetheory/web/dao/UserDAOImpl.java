package com.codetheory.web.dao;

import com.codetheory.web.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public class UserDAOImpl implements UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addUser(User user) {
        String sql = "insert into User values(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[] {
                //employee.getId(), employee.getAge(), employee.getDept(), employee.getName()
        });
    }

    // Getting a particular Employee
    public User getUserById(int id) {
        String sql = "select * from User where id=?";
        return new User();
    }

    public void updateUser(User user) {

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
}
