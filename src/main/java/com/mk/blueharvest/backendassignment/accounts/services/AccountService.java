package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;


public interface AccountService {


    AccountDTO addAccountToCustomer(CustomerDTO customerDTO, AccountDTO account);

}
