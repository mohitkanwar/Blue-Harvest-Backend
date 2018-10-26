package com.mk.blueharvest.backendassignment.services;

import com.mk.blueharvest.backendassignment.entities.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    List<Customer> getAllCustomers();
}
