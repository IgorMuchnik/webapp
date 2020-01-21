package org.example.dao;

import org.example.model.User;
import java.util.List;

public interface UserDaoInterface {
    boolean createUser(User user) ;
    User deleteUser(long id);
    User getById(Long id);
    List<User> getAll() ;
}
