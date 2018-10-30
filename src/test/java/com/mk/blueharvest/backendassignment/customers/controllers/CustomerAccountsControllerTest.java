package com.mk.blueharvest.backendassignment.customers.controllers;

import com.mk.blueharvest.backendassignment.customers.errors.CustomerErrorCodes;
import com.mk.blueharvest.backendassignment.customers.utils.SimpleResponse;
import com.mk.blueharvest.backendassignment.customers.utils.StatusResponse;
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
        CreateAccountRequest request = new CreateAccountRequest();
        request.setCustomerId(customerId);
        request.setInitialCredit(initialCredit);
        customerAccountsController.createCurrentAccount(request);
    }

    @Test
    public void shouldReturnFalseIfUserDoesntExists() {
        long customerId = -20000L;
        double initialCredit = 200;
        CreateAccountRequest request = new CreateAccountRequest();
        request.setCustomerId(customerId);
        request.setInitialCredit(initialCredit);
        SimpleResponse response = customerAccountsController.createCurrentAccount(request);
        assertEquals(StatusResponse.FAILURE,response.getStatus());
        assertEquals(CustomerErrorCodes.CUSTOMER_NOT_FOUND.toString(),response.getError().getErrorCode());
    }

    @Test
    public void shouldCreateAccountIfUserExists() {
        long customerId = 1;
        double initialCredit = 200;
        CreateAccountRequest request = new CreateAccountRequest();
        request.setCustomerId(customerId);
        request.setInitialCredit(initialCredit);
        SimpleResponse response = customerAccountsController.createCurrentAccount(request);
        assertEquals(StatusResponse.SUCCESS,response.getStatus());

    }
}
