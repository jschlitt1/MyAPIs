package edu.wctc.dao;

import edu.wctc.rest.entity.Legend;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class LegendDAOImp implements LegendDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Legend> getLegends() {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Get list of donuts from query
        List<Legend> legendList = session.createQuery("from Legend", Legend.class).getResultList();

        // Return results
        return legendList;
    }

    @Override
    public Legend getLegend(int theId) {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        return session.get(Legend.class, theId);
    }
}
