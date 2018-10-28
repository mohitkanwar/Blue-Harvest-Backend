package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountsDTO;

public interface TransactionService {
    void saveTransaction(AccountsDTO account, double amount);
}
