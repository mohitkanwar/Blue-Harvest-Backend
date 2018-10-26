package com.mk.blueharvest.backendassignment.entities;

import javax.persistence.Entity;

@Entity
public class Customer {
    private long id;

    public Customer(long id){
        this.id = id;
    }
    public long getId() {
        return id;
    }
}
