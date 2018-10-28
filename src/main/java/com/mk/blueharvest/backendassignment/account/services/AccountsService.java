package com.mk.blueharvest.backendassignment.account.services;

import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;
import com.mk.blueharvest.backendassignment.customer.dto.CustomerDTO;

import java.util.List;

public interface AccountsService {


    AccountsDTO addAccountToCustomer(CustomerDTO customerDTO, AccountsDTO account);

    List<AccountsDTO> getAllAccountsForCustomer(CustomerDTO customerDTO);
}
