package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.accounts.entities.Transaction;
import com.mk.blueharvest.backendassignment.accounts.repositories.AccountRepository;
import com.mk.blueharvest.backendassignment.accounts.repositories.TransactionRepository;
import com.mk.blueharvest.backendassignment.accounts.utils.AccountType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultTransactionServiceTest {
    @MockBean
    private  TransactionRepository transactionRepository;
    @MockBean
    private  AccountRepository accountRepository;
    @MockBean
    private  AccountAdapter accountAdapter;

    @Test
    public void saveTransaction() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(20);
        accountDTO.setAccountType(AccountType.CURRENT);
        accountDTO.setBalance(200);
        Transaction transaction = new Transaction();
        transaction.setAmount(20);
        transaction.setId(20);
        transaction.setCreateDate(new Date());
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        when(transactionRepository.save(transaction)).thenReturn(transaction);
        Account account = new Account();
        account.setId(20);
        account.setBalance(200);
        account.setTransactions(transactions);
        when(accountAdapter.getAccountsEntity(accountDTO)).thenReturn(account);
        when(accountRepository.save(account)).thenReturn(account);
    }
}