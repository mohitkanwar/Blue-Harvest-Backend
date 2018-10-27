package com.mk.blueharvest.backendassignment.account.services;

import com.mk.blueharvest.backendassignment.account.entities.Account;

import java.util.List;

public interface AccountsService {

    Account save(Account account);

    List<Account> getAllAccounts();
}
