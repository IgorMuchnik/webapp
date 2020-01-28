package org.example.service.impl;

import org.example.dao.impl.AdvertDaoImpl;
import org.example.model.Advert;
import org.example.service.AdvertService;

import java.sql.SQLException;
import java.util.List;

public class AdvertServiceImpl implements AdvertService {

    private AdvertDaoImpl advertDao = new AdvertDaoImpl();

    @Override
    public void createAdvert(Advert advert) {
        advertDao.createAdvert(advert);
    }

    @Override
    public Advert deleteAdvert(long advertId) {
        return advertDao.deleteAdvert(advertId);
    }

    @Override
    public Advert getAdvertById(long advertId) {
        return advertDao.getAdvertById(advertId);
    }

    @Override
    public List<Advert> getAdvertsByUser(long userId) throws SQLException {
        return advertDao.getAdvertsByUserId(userId);
    }
}
