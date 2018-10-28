package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;

public interface TransactionService {
    void saveTransaction(AccountDTO account, double amount);
}
