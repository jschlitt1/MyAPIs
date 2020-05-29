package edu.wctc.dao;

import edu.wctc.rest.entity.Resturant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ResturantDAOImp implements ResturantDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Resturant> getResturants() {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Get list of donuts from query
        List<Resturant> resturantList = session.createQuery("from Resturant", Resturant.class).getResultList();

        // Return results
        return resturantList;
    }

    @Override
    public Resturant getResturant(int theId) {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        return session.get(Resturant.class, theId);
    }
}
