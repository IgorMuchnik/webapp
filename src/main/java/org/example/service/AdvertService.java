package org.example.service;

import org.example.model.Advert;
import org.example.model.User;

import java.sql.SQLException;
import java.util.List;

public interface AdvertService {
    void createAdvert(Advert advert) ;
    Advert deleteAdvert(long advertId);
    Advert getAdvertById(long advertId);
    List<Advert> getAdvertsByUser(long userId) throws SQLException;
}
