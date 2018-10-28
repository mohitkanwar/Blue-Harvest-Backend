package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.accounts.dtos.AccountsDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.accounts.repositories.AccountRepository;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DefaultAccountsService implements AccountsService {
    private final AccountRepository accountRepository;
    private final AccountAdapter accountAdapter;
    private final CustomerService customerService;

    @Autowired
    public DefaultAccountsService(AccountRepository accountRepository,
                                  AccountAdapter accountAdapter,
                                  CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.accountAdapter = accountAdapter;
        this.customerService = customerService;
    }

    @Override
    public AccountsDTO addAccountToCustomer(CustomerDTO customerDTO, AccountsDTO accountDTO) {

        Account account = accountRepository.save(accountAdapter.getAccountsEntity(accountDTO));
        customerDTO.getAccounts().add(accountAdapter.getAccountsDTO(account));
        customerService.save(customerDTO);
        return accountAdapter.getAccountsDTO(account);
    }

    @Override
    public List<AccountsDTO> getAllAccountsForCustomer(CustomerDTO customerDTO) {
        List<AccountsDTO> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(account -> {
            accounts.add(accountAdapter.getAccountsDTO(account));
        });
        return accounts;
    }

}
