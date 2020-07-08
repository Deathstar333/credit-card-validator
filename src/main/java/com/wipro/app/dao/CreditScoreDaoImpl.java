package com.wipro.app.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditScoreDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int getCount(String panNumber) {
        panNumber = panNumber.toUpperCase();
        String hql = "select count(*) from CreditScore CS where CS.panNumber = :pan_number";
        Query query =  getSessionFactory().openSession().createQuery(hql);
        query.setParameter("pan_number", panNumber);
        Object result = query.uniqueResult();
        if(result == null) return 0;
        return ((Long) result).intValue();
    }

    public double getCreditScoreByPanNumber(String panNumber) {
        panNumber = panNumber.toUpperCase();
        String hql = "select creditScore from CreditScore CS where CS.panNumber = :pan_number";
        Query query = getSessionFactory().openSession().createQuery(hql);
        query.setParameter("pan_number", panNumber);
        return ((Float) query.uniqueResult()).doubleValue();
    }
}
