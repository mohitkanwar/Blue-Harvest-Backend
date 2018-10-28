package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;

import java.util.List;

public interface AccountService {


    AccountDTO addAccountToCustomer(CustomerDTO customerDTO, AccountDTO account);

    List<AccountDTO> getAllAccountsForCustomer(CustomerDTO customerDTO);
}
