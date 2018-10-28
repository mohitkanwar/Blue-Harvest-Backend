package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.accounts.repositories.AccountRepository;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DefaultAccountService implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountAdapter accountAdapter;
    private final CustomerService customerService;

    @Autowired
    public DefaultAccountService(AccountRepository accountRepository,
                                 AccountAdapter accountAdapter,
                                 CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.accountAdapter = accountAdapter;
        this.customerService = customerService;
    }

    @Override
    public AccountDTO addAccountToCustomer(CustomerDTO customerDTO, AccountDTO accountDTO) {

        Account account = accountRepository.save(accountAdapter.getAccountsEntity(accountDTO));
        customerDTO.getAccounts().add(accountAdapter.getAccountsDTO(account));
        customerService.save(customerDTO);
        return accountAdapter.getAccountsDTO(account);
    }


}
