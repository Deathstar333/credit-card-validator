package com.wipro.app.service;

import com.wipro.app.dao.CreditScoreDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class CreditScoreServiceImpl {

    @Autowired
    CreditScoreDaoImpl dao;

    public CreditScoreDaoImpl getDao() {
        return dao;
    }

    public void setDao(CreditScoreDaoImpl dao) {
        this.dao = dao;
    }

    public boolean isEligible(String panNumber) {
        double score = dao.getCreditScoreByPanNumber(panNumber);
        if(score >= 5.0) return true;
        return false;
    }

    public boolean isValid(String panNumber) {
        int count = dao.getCount(panNumber);
        if(count == 0) return false;
        return true;
    }
}
