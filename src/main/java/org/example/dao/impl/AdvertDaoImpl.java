package org.example.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.example.dao.AdvertDao;
import org.example.model.Advert;
import org.example.util.ConnectionFactory;

public class AdvertDaoImpl implements AdvertDao {

  @Override
  public boolean createAdvert(Advert advert) {
    return false;
  }

  @Override
  public Advert deleteAdvert(long id) {
    return null;
  }

  @Override
  public Advert getById(long advertId) {
    return null;
  }

  @Override
  public List<Advert> getAll() {
    return null;
  }

  @Override
  public List<Advert> getAdvertsByUser(long userId) throws SQLException {
    Connection cn = ConnectionFactory.getConnection();
    Statement st = cn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM adverts WHERE id=" + userId);

    List<Advert> list = new ArrayList();
    while (rs.next()) {
      list.add(parseResultSet(rs));
    }

    return list;
  }

  private Advert parseResultSet(ResultSet rs) {
    Advert advert = new Advert();
//      user.setId(rs.getLong("id"));
//      user.setName(rs.getString("name"));
//      user.setSurname(rs.getString("surname"));
//      user.setEmail(rs.getString("email"));
//      user.setCategory(Category.valueOf(rs.getString("category")));
    return advert;
  }
}
