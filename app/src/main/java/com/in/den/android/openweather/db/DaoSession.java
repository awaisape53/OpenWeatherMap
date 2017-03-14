package com.in.den.android.openweather.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.in.den.android.openweather.db.Location;
import com.in.den.android.openweather.db.Weather;

import com.in.den.android.openweather.db.LocationDao;
import com.in.den.android.openweather.db.WeatherDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig locationDaoConfig;
    private final DaoConfig weatherDaoConfig;

    private final LocationDao locationDao;
    private final WeatherDao weatherDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        locationDaoConfig = daoConfigMap.get(LocationDao.class).clone();
        locationDaoConfig.initIdentityScope(type);

        weatherDaoConfig = daoConfigMap.get(WeatherDao.class).clone();
        weatherDaoConfig.initIdentityScope(type);

        locationDao = new LocationDao(locationDaoConfig, this);
        weatherDao = new WeatherDao(weatherDaoConfig, this);

        registerDao(Location.class, locationDao);
        registerDao(Weather.class, weatherDao);
    }
    
    public void clear() {
        locationDaoConfig.clearIdentityScope();
        weatherDaoConfig.clearIdentityScope();
    }

    public LocationDao getLocationDao() {
        return locationDao;
    }

    public WeatherDao getWeatherDao() {
        return weatherDao;
    }

}
