package com.mk.blueharvest.backendassignment.customers.services;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountsDTO;
import com.mk.blueharvest.backendassignment.accounts.utils.AccountType;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
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
    public void shouldBeAbleToStoreCustomer() {
        CustomerDTO customer = new CustomerDTO();
        customer.setGivenName("CustName");
        customer.setSurname("surname");
        AccountsDTO account = new AccountsDTO();
        account.setAccountType(AccountType.CURRENT);
        account.setBalance(200);
        List<AccountsDTO> accounts = new ArrayList<>(1);
        accounts.add(account);
        customer.setAccounts(accounts);
        CustomerDTO customerDTOFromDB = customerService.save(customer);
        Assert.assertNotEquals(0, customerDTOFromDB.getCustomerId());
        Assert.assertNotNull(customerDTOFromDB.getAccounts());
        Assert.assertEquals(1, customerDTOFromDB.getAccounts().size());
        Assert.assertNotEquals(0, customerDTOFromDB.getAccounts().get(0).getId());
    }
}
