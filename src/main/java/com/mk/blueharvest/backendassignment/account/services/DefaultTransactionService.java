package com.mk.blueharvest.backendassignment.account.services;


import com.mk.blueharvest.backendassignment.account.entities.Account;
import com.mk.blueharvest.backendassignment.account.entities.Transaction;
import com.mk.blueharvest.backendassignment.account.repositories.AccountRepository;
import com.mk.blueharvest.backendassignment.account.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class DefaultTransactionService implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void saveTransaction(Account account,  double amount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setCreateDate(new Date());
        transaction = transactionRepository.save(transaction);
        account.getTransactions().add(transaction);
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
    }
}
