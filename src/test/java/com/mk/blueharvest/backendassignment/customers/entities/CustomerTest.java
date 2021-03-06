package com.mk.blueharvest.backendassignment.customers.entities;

import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    private static final String TEST_GIVEN_NAME = "Test Given Name";
    private static final String TEST_SURNAME = "Test Sur Name";
    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer();
    }


    @Test
    public void customerCanHaveAGivenName() {
        customer.setGivenName(TEST_GIVEN_NAME);
        Assert.assertEquals(TEST_GIVEN_NAME, customer.getGivenName());
    }

    @Test
    public void customerCanHaveASurname() {
        customer.setSurname(TEST_SURNAME);
        Assert.assertEquals(TEST_SURNAME, customer.getSurname());
    }

    @Test
    public void testCustomerEqualityBasedOnId() {
        final long ID = 10;
        Customer customer = new Customer();
        customer.setId(ID);
        Customer customer1 = new Customer();
        customer1.setId(ID);
        Assert.assertTrue(customer.equals(customer1));
    }

    @Test
    public void testCustomerHashcodeBasedOnId() {
        final long ID = 10;
        Customer customer = new Customer();
        customer.setId(ID);

        Assert.assertEquals(customer.hashCode(), Objects.hash(ID));
    }

    @Test
    public void customerCanHaveAccounts() {
        Account account1 = new Account();
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        customer.setAccounts(accounts);
        Assert.assertEquals(accounts, customer.getAccounts());
    }
}
