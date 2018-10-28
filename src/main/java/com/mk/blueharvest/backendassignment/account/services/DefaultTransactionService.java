package com.mk.blueharvest.backendassignment.account.services;


import com.mk.blueharvest.backendassignment.account.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;
import com.mk.blueharvest.backendassignment.account.entities.Account;
import com.mk.blueharvest.backendassignment.account.entities.Transaction;
import com.mk.blueharvest.backendassignment.account.repositories.AccountRepository;
import com.mk.blueharvest.backendassignment.account.repositories.TransactionRepository;
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
    public void saveTransaction(AccountsDTO accountsDTO, double amount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setCreateDate(new Date());
        transaction = transactionRepository.save(transaction);
        Account account = accountAdapter.getAccountsEntity(accountsDTO);
        account.getTransactions().add(transaction);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }
}
