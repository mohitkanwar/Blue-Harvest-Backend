package com.mk.blueharvest.backendassignment.customer.services;


import com.mk.blueharvest.backendassignment.customer.entities.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    List<Customer> getAllCustomers();
}
