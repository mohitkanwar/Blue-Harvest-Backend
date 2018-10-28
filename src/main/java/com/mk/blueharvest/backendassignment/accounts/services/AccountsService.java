package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountsDTO;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;

import java.util.List;

public interface AccountsService {


    AccountsDTO addAccountToCustomer(CustomerDTO customerDTO, AccountsDTO account);

    List<AccountsDTO> getAllAccountsForCustomer(CustomerDTO customerDTO);
}
