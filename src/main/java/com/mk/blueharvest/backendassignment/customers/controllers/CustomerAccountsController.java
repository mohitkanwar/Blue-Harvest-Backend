package com.mk.blueharvest.backendassignment.customers.controllers;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.services.AccountService;
import com.mk.blueharvest.backendassignment.accounts.services.TransactionService;
import com.mk.blueharvest.backendassignment.accounts.utils.AccountType;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.services.CustomerService;
import com.mk.blueharvest.backendassignment.customers.utils.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/customer-account")
public class CustomerAccountsController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/current")
    public String createCurrentAccount(long customerId, double initialCredit) {
        StatusResponse statusResponse = StatusResponse.FAILURE;
        Optional<CustomerDTO> customer = customerService.getCustomerById(customerId);
        if (customer.isPresent()) {
            CustomerDTO customer1 = customer.get();
            AccountDTO account = new AccountDTO();
            account.setAccountType(AccountType.CURRENT);
            account = accountService.addAccountToCustomer(customer1, account);
            if (initialCredit != 0) {
                transactionService.saveTransaction(account, initialCredit);
            }
            statusResponse = StatusResponse.SUCCESS;
        }
        return statusResponse.toString();
    }
}
