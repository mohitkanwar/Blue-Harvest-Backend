package com.mk.blueharvest.backendassignment.customers.services;


import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customer);

    Optional<CustomerDTO> getCustomerById(long customerId);

    List<CustomerDTO> getAllCustomers(int pagenumber, int pagesize);

    long getCustomersCount();
}
