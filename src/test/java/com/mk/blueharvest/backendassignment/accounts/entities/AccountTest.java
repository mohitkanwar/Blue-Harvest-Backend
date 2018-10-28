package com.mk.blueharvest.backendassignment.accounts.entities;

import com.mk.blueharvest.backendassignment.accounts.utils.AccountType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

    private static final long ID = 10;
    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void accountCanHaveanId() {
        account.setId(ID);
        assertEquals(ID, account.getId());
    }

    @Test
    public void testAccountType() {
        account.setAccountType(AccountType.CURRENT);
        assertEquals(AccountType.CURRENT, account.getAccountType());
    }

    @Test
    public void testBalance() {
        account.setBalance(200);
        assertEquals(200, account.getBalance(), 0);
    }

    @Test
    public void equals() {
        Account account1 = new Account();
        account1.setId(200);
        Account account2 = new Account();
        account2.setId(200);
        assertEquals(account1, account2);
    }

    @Test
    public void testHashCode() {
        account.setId(ID);
        assertEquals(account.hashCode(), Objects.hash(ID));
    }
}