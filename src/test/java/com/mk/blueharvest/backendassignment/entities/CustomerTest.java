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

    private static final long TEST_CUST_ID = 1;
    private static final String TEST_GIVEN_NAME = "Test Given Name";
    @Before
    public void setup(){
        customer = new Customer(TEST_CUST_ID);
    }
    @Test
    public void customerMustHaveACustomerId(){
        Assert.assertEquals(TEST_CUST_ID,customer.getId());
    }

    @Test
    public void customerCanHaveAGivenName(){
        customer.setGivenName(TEST_GIVEN_NAME);
        Assert.assertEquals(TEST_GIVEN_NAME,customer.getGivenName());
    }
}
