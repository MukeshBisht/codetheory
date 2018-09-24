package com.codetheory.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.codetheory.web.model.User;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

    @Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
		return user;
	}


}