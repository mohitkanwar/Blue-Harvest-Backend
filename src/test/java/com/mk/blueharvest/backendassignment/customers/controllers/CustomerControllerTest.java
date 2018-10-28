package com.mk.blueharvest.backendassignment.customers.controllers;

import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;
    @Autowired
    private CustomerService customerService;

    @Test
    public void getAllCustomers() {
        CustomerDTO customer = new CustomerDTO();
        customer.setGivenName("Mohit");
        customer.setSurname("Kanwar");
        customerService.save(customer);
        List<CustomerDTO> customers = customerController.getCustomersList();
        customers.forEach(customerDTO -> {
            System.out.println(customerDTO.getGivenName() + " " + customerDTO.getSurname());
        });
    }
}
