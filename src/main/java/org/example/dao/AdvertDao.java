package org.example.dao;

import java.sql.SQLException;
import java.util.List;
import org.example.model.Advert;

public interface AdvertDao {

  boolean createAdvert(Advert advert) ;
  Advert deleteAdvert(long id);
  Advert getById(long id);
  List<Advert> getAll() ;
  List<Advert> getAdvertsByUser(long userId) throws SQLException;

}
