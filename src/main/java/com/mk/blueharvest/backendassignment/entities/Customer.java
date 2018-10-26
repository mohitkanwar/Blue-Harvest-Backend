package com.mk.blueharvest.backendassignment.entities;

import javax.persistence.Entity;

@Entity
public class Customer {
    private long id;
    private String givenName;

    public Customer(long id){
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
}
