package com.mk.blueharvest.backendassignment.customer.controllers;

import com.mk.blueharvest.backendassignment.customer.util.StatusResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerAccountsControllerTest {
    @Autowired
    private CustomerAccountsController customerAccountsController;

    @Test
    public void shouldHaveAPISignature() {
        long customerId = 1;
        double initialCredit = 200;
        customerAccountsController.createCurrentAccount(customerId, initialCredit);
    }

    @Test
    public void shouldReturnFalseIfUserDoesntExists() {
        long customerId = -20000L;
        double initialCredit = 200;
        assertEquals(StatusResponse.FAILURE.toString(),
                customerAccountsController.createCurrentAccount(customerId, initialCredit));
    }

    @Test
    public void shouldCreateAccountIfUserExists() {
        long customerId = 1;
        double initialCredit = 200;
        assertEquals(StatusResponse.SUCCESS.toString(),
                customerAccountsController.createCurrentAccount(customerId, initialCredit));
    }
}
