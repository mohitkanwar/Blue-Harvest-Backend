package com.mk.blueharvest.backendassignment.account.services;

import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;

public interface TransactionService {
    void saveTransaction(AccountsDTO account, double amount);
}
