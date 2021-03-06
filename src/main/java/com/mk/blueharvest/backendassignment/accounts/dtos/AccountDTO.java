package com.mk.blueharvest.backendassignment.accounts.dtos;

import com.mk.blueharvest.backendassignment.accounts.utils.AccountType;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of Account as viewed in Controllers and outside world
 */

public class AccountDTO {
    private long id;
    private AccountType accountType;
    private double balance;
    private List<TransactionDTO> transactions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<TransactionDTO> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}
