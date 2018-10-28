package com.mk.blueharvest.backendassignment.customer.services;

import com.mk.blueharvest.backendassignment.customer.entities.Customer;
import com.mk.blueharvest.backendassignment.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultCustomerSevice implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> {customers.add(customer);});
        return customers;
    }

    @Override
    public Optional<Customer> getCustomerById(long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        System.out.println("Status for customer with id :"+customerId+" = "+customer.isPresent());
        return customer;
    }
}
