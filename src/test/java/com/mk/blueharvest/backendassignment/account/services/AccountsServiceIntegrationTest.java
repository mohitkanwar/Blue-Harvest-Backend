package com.mk.blueharvest.backendassignment.account.services;

import com.mk.blueharvest.backendassignment.account.entities.Account;
import com.mk.blueharvest.backendassignment.account.util.AccountType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountsServiceIntegrationTest {
    @Autowired
    private AccountsService accountsService;
    @Test
    public void testAccountSaving(){
        Account account = new Account();
        account.setBalance(200);
        account.setAccountType(AccountType.CURRENT);
        accountsService.save(account);
        List<Account> accountList = accountsService.getAllAccounts();
        Assert.assertTrue(accountList.contains(account));

    }
}
