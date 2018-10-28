package com.mk.blueharvest.backendassignment.accounts.adapters;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.accounts.utils.AccountType;
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
        AccountDTO dto = accountAdapter.getAccountsDTO(account);
        assertEquals(AccountType.CURRENT, dto.getAccountType());
        assertEquals(200.40, dto.getBalance(), 0);
        assertEquals(32, dto.getId());
        assertEquals(new ArrayList<>(), dto.getTransactions());
    }

    @Test
    public void shouldReturnCorrectEntity() {
        AccountDTO account = new AccountDTO();
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