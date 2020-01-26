package org.example.dao;

import java.sql.SQLException;
import org.example.model.User;
import java.util.List;

public interface UserDao {
    void createUser(User user) ;
    User deleteUser(long userId);
    User getById(long userId) ;
    List<User> getAll() ;
}
