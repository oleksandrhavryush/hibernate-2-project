package com.havriush.dao;

import com.havriush.model.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CityDAO extends GenericDAO<City> {
    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getByName(String name) {
        Query<City> hql = getCurrentSession().createQuery("from City c where c.city = :NAME", City.class);
        hql.setParameter("NAME", name);

        return hql.getSingleResult();
    }
}
