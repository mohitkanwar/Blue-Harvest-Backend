package com.mk.blueharvest.backendassignment.customer.controllers;

import com.mk.blueharvest.backendassignment.customer.adapter.CustomerAdapter;
import com.mk.blueharvest.backendassignment.customer.dto.CustomerDTO;
import com.mk.blueharvest.backendassignment.customer.entities.Customer;
import com.mk.blueharvest.backendassignment.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerAdapter customerAdapter;

    @GetMapping("/list")
    public List<CustomerDTO> getCustomersList() {
        List<CustomerDTO> response = new ArrayList<>();
        List<Customer> customers = customerService.getAllCustomers();
        customers.forEach(customer -> {
            CustomerDTO dto = customerAdapter.getCustomerDTO(customer);
            response.add(dto);
        });
        return response;
    }


}
