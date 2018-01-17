package com.codetheory.web.dao;

import com.codetheory.web.model.User;
import java.util.List;

public interface UserDAO {
    public void addUser(User user);
    public User getUserById(int id);
    public void updateUser(User user);
    public void deleteUser(int id);
    public boolean userExist(String username);
    public List<User> getAllUsers();
}