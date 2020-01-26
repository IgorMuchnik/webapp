package org.example.service;

import java.sql.SQLException;
import java.util.List;
import org.example.model.User;
import org.example.model.Advert;

public interface UserService {
  void createUser(User user) ;
  User deleteUser(long userId);
  User getById(long userId);
  List<User> getAll();
  List<Advert> getAdvertsByUser(long userId) throws SQLException;
}
