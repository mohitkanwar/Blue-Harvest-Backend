package com.mk.blueharvest.backendassignment.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    private Customer customer;

    private static final long CUST_ID = 1;
    @Before
    public void setup(){
        customer = new Customer(CUST_ID);
    }
    @Test
    public void customerMustHaveACustomerId(){
        Assert.assertEquals(CUST_ID,customer.getId());
    }
}
