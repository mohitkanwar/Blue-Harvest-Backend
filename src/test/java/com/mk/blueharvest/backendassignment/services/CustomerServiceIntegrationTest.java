package com.mk.blueharvest.backendassignment.services;

import com.mk.blueharvest.backendassignment.entities.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceIntegrationTest {
    @Autowired
    private CustomerService customerService;

    @Test
    public void shouldBeAbleToStoreCustomer(){
        Customer customer = new Customer();
        customer.setGivenName("CustName");
        customer.setSurname("surname");
        customerService.save(customer);
        Assert.assertTrue(customerService.getAllCustomers().contains(customer));
    }
}
