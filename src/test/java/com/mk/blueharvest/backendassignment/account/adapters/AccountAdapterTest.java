package com.mk.blueharvest.backendassignment.account.adapters;

import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;
import com.mk.blueharvest.backendassignment.account.entities.Account;
import com.mk.blueharvest.backendassignment.account.util.AccountType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountAdapterTest {
    @Autowired
    private AccountAdapter accountAdapter;

    @Test
    public void shouldReturnCorrectDTO() {
        Account account = new Account();
        account.setBalance(200.40);
        account.setAccountType(AccountType.CURRENT);
        account.setId(32);
        account.setTransactions(new ArrayList<>());
        AccountsDTO dto = accountAdapter.getAccountsDTO(account);
        assertEquals(AccountType.CURRENT, dto.getAccountType());
        assertEquals(200.40, dto.getBalance(), 0);
        assertEquals(32, dto.getId());
        assertEquals(new ArrayList<>(), dto.getTransactions());
    }

    @Test
    public void shouldReturnCorrectEntity() {
        AccountsDTO account = new AccountsDTO();
        account.setBalance(200.40);
        account.setAccountType(AccountType.CURRENT);
        account.setId(32);
        account.setTransactions(new ArrayList<>());
        Account entity = accountAdapter.getAccountsEntity(account);
        assertEquals(AccountType.CURRENT, entity.getAccountType());
        assertEquals(200.40, entity.getBalance(), 0);
        assertEquals(32, entity.getId());
        assertEquals(new ArrayList<>(), entity.getTransactions());
    }

}