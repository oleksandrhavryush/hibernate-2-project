package com.havriush.dao;

import com.havriush.model.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FilmDAO extends GenericDAO<Film> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getFirstAvailableFilmForRent() {
        Query<Film> hql = getCurrentSession().createQuery("from Film f " +
                "where f.id not in (select distinct film.id from Inventory)", Film.class);
        hql.setMaxResults(1);
        return hql.getSingleResult();
    }
}
