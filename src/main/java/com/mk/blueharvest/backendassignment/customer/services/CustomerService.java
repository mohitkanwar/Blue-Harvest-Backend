package com.mk.blueharvest.backendassignment.customer.services;


import com.mk.blueharvest.backendassignment.customer.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(long customerId);
}
