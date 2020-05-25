package com.wipro.app.model;

import javax.persistence.*;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditScore {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PAN_NUMBER")
    String panNumber;

    @Column(name = "CREDIT_SCORE")
    Float creditScore;

    public CreditScore() {
    }

    public CreditScore(String panNumber, Float creditScore) {
        this.panNumber = panNumber;
        this.creditScore = creditScore;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public Float getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Float creditScore) {
        this.creditScore = creditScore;
    }
}
