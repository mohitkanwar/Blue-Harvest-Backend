package com.mk.blueharvest.backendassignment.account.services;

import com.mk.blueharvest.backendassignment.account.entities.Account;

public interface TransactionService {
    void saveTransaction(Account account,  double amount);
}
