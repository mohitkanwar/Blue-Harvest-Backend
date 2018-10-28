package com.mk.blueharvest.backendassignment.accounts.services;


import com.mk.blueharvest.backendassignment.accounts.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.accounts.entities.Transaction;
import com.mk.blueharvest.backendassignment.accounts.repositories.AccountRepository;
import com.mk.blueharvest.backendassignment.accounts.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;


@Service
@Transactional
public class DefaultTransactionService implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final AccountAdapter accountAdapter;

    @Autowired
    public DefaultTransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository, AccountAdapter accountAdapter) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.accountAdapter = accountAdapter;
    }

    @Override
    public void saveTransaction(AccountDTO accountDTO, double amount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setCreateDate(new Date());
        transaction = transactionRepository.save(transaction);
        Account account = accountAdapter.getAccountsEntity(accountDTO);
        account.getTransactions().add(transaction);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }
}
