package com.mk.blueharvest.backendassignment.customers.controllers;

import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.services.CustomerService;
import com.mk.blueharvest.backendassignment.customers.utils.PaginatedListResponse;
import com.mk.blueharvest.backendassignment.customers.utils.StatusResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        PaginatedListResponse<CustomerDTO> response = customerController.getCustomersList(0,20);
        assertEquals(StatusResponse.SUCCESS,response.getStatus());
        List<CustomerDTO> customers = response.getDataList();
        customers.forEach(customerDTO -> {
            System.out.println(customerDTO.getGivenName() + " " + customerDTO.getSurname());
        });
    }
}
