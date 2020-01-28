package org.example.service.impl;

import java.sql.SQLException;
import java.util.List;
import org.example.dao.AdvertDao;
import org.example.dao.UserDao;
import org.example.dao.impl.AdvertDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.model.Advert;
import org.example.model.User;
import org.example.service.UserService;

public class UserServiceImpl implements UserService {

  private UserDao userDaoImpl = new UserDaoImpl();

  @Override
  public void createUser(User user) {
    //logging
    userDaoImpl.createUser(user);
  }

  @Override
  public User deleteUser(long userId) {
    return userDaoImpl.deleteUser(userId);
  }

  @Override
  public User getById(long userId) {
    return userDaoImpl.getUserById(userId);
  }

  @Override
  public List<User> getAll() {
    return userDaoImpl.getAllUsers();
  }
}
