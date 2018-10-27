package com.mk.blueharvest.backendassignment.account.services;

import com.mk.blueharvest.backendassignment.account.entities.Account;
import com.mk.blueharvest.backendassignment.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultAccountsService implements AccountsService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
         accountRepository.findAll().forEach(accounts::add);
         return accounts;
    }
}
