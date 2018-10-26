package com.mk.blueharvest.backendassignment.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * This class serves the purpose of customers of the application.
 */
@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;

    @Column(name = "GIVEN_NAME")
    private String givenName;
    @Column(name = "SURNAME")
    private String surname;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
