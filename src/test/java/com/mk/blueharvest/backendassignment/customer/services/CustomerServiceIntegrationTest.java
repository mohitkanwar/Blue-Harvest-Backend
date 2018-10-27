package com.mk.blueharvest.backendassignment.customer.services;

import com.mk.blueharvest.backendassignment.account.entities.Account;
import com.mk.blueharvest.backendassignment.account.util.AccountType;
import com.mk.blueharvest.backendassignment.customer.entities.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        Account account = new Account();
        account.setAccountType(AccountType.CURRENT);
        account.setBalance(200);
        List<Account> accounts = new ArrayList<>(1);
        accounts.add(account);
        customer.setAccounts(accounts);
        customerService.save(customer);
        final List<Customer> allCustomers = customerService.getAllCustomers();
        Assert.assertTrue(allCustomers.contains(customer));
        int index = allCustomers.indexOf(customer);
        Customer customerFromDB = allCustomers.get(index);
        Assert.assertNotEquals(0,customerFromDB.getId());
        Assert.assertNotNull(customerFromDB.getAccounts());
        Assert.assertEquals(1,customerFromDB.getAccounts().size());
        Assert.assertNotEquals(0,customerFromDB.getAccounts().get(0).getId());
    }
}
