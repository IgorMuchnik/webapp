package org.example.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.dao.AdvertDao;
import org.example.model.Advert;
import org.example.util.ConnectionFactory;

public class AdvertDaoImpl implements AdvertDao {

  @Override
  public boolean createAdvert(Advert advert) {
    try (Connection cn = ConnectionFactory.getConnection();
         PreparedStatement ps = cn.prepareStatement("INSERT INTO adverts (user_id, title, body, category, phone) " +
                 "VALUES (?, ?, ?, ?, ?)")) {
      ps.setInt(1, advert.getUserId());
      ps.setString(2, advert.getTitle());
      ps.setString(3, advert.getBody());
      ps.setString(4, advert.getCategory());
      ps.setString(5, advert.getPhoneNumber());

      int i = ps.executeUpdate();

      if (i != 1) {
        throw new SQLException();
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return true;
  }

  @Override
  public Advert deleteAdvert(long advertId) {
    try (Connection cn = ConnectionFactory.getConnection();
         Statement st = cn.createStatement();
         PreparedStatement ps = cn.prepareStatement("DELETE FROM adverts WHERE id=?")) {

      ps.setLong(1, advertId);
      Advert advert = getAdvertById(advertId);

      int i = ps.executeUpdate();
      if (i == 1) {
        return advert;
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return null;
  }

  @Override
  public Advert getAdvertById(long advertId) {
    try {
      Connection cn = ConnectionFactory.getConnection();
      Statement st = cn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM adverts WHERE id=" + advertId);

      while (rs.next()) {
        return parseResultSet(rs);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return null;

  }

  @Override
  public List<Advert> getAdvertsByUserId(long userId) throws SQLException {
    Connection cn = ConnectionFactory.getConnection();
    Statement st = cn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM adverts WHERE user_id=" + userId);

    List<Advert> list = new ArrayList();
    while (rs.next()) {
      list.add(parseResultSet(rs));
    }

    return list;
  }

  private Advert parseResultSet(ResultSet rs) throws SQLException {
    Advert advert = new Advert();
      advert.setId(rs.getString("id"));
      advert.setUserId(rs.getInt("user_id"));
      advert.setTitle(rs.getString("title"));
      advert.setBody(rs.getString("body"));
      advert.setCategory(rs.getString("category"));
      advert.setPhoneNumber(rs.getString("phone"));
      advert.setCreated(rs.getDate("created"));
    return advert;
  }
}
