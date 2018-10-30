package com.mk.blueharvest.backendassignment.customers.services;

import com.mk.blueharvest.backendassignment.customers.adapters.CustomerAdapter;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.entities.Customer;
import com.mk.blueharvest.backendassignment.customers.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultCustomerSevice implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerAdapter customerAdapter;

    @Autowired
    public DefaultCustomerSevice(CustomerRepository customerRepository, CustomerAdapter customerAdapter) {
        this.customerRepository = customerRepository;
        this.customerAdapter = customerAdapter;
    }

    @Override
    public CustomerDTO save(CustomerDTO customer) {
        return customerAdapter.getCustomerDTO(customerRepository.save(customerAdapter.getCustomerEntity(customer)));
    }

    @Override
    public List<CustomerDTO> getAllCustomers(int pageNumber, int pageSize) {
        List<CustomerDTO> customers = new ArrayList<>();
        int firstRecord = pageNumber*pageSize;
        int maxRecord = (pageNumber+1)*pageSize -1;
        customerRepository.findAll(PageRequest.of(firstRecord,maxRecord, Sort.by("id"))).forEach(customer -> {
            customers.add(customerAdapter.getCustomerDTO(customer));
        });
        return customers;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return Optional.ofNullable(customerAdapter.getCustomerDTO(customer.orElse(null)));
    }
}
