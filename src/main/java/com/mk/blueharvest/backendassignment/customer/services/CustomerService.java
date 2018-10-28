package com.mk.blueharvest.backendassignment.customer.services;


import com.mk.blueharvest.backendassignment.customer.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customer);

    List<CustomerDTO> getAllCustomers();

    Optional<CustomerDTO> getCustomerById(long customerId);
}
