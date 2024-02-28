package com.havriush.dao;

import com.havriush.model.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDAO extends GenericDAO<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getAnyUnreturnedRental() {
        Query<Rental> hql = getCurrentSession().createQuery("from Rental r where r.returnDate is null ", Rental.class);
        hql.setMaxResults(1);
        return hql.getSingleResult();
    }
}
