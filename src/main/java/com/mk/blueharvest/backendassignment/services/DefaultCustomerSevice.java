package com.mk.blueharvest.backendassignment.services;

import com.mk.blueharvest.backendassignment.entities.Customer;
import com.mk.blueharvest.backendassignment.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCustomerSevice implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> {customers.add(customer);});
        return customers;
    }
}
