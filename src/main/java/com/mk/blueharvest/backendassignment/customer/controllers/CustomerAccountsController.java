package com.mk.blueharvest.backendassignment.customer.controllers;

import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;
import com.mk.blueharvest.backendassignment.account.services.AccountsService;
import com.mk.blueharvest.backendassignment.account.services.TransactionService;
import com.mk.blueharvest.backendassignment.account.util.AccountType;
import com.mk.blueharvest.backendassignment.customer.dto.CustomerDTO;
import com.mk.blueharvest.backendassignment.customer.services.CustomerService;
import com.mk.blueharvest.backendassignment.customer.util.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/customer-account")
public class CustomerAccountsController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountsService accountsService;
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/current")
    public String createCurrentAccount(long customerId, double initialCredit) {
        StatusResponse statusResponse = StatusResponse.FAILURE;
        Optional<CustomerDTO> customer = customerService.getCustomerById(customerId);
        try {
            if (customer.isPresent()) {
                CustomerDTO customer1 = customer.get();
                AccountsDTO account = new AccountsDTO();
                account.setAccountType(AccountType.CURRENT);
                account = accountsService.addAccountToCustomer(customer1, account);
                if (initialCredit != 0) {
                    transactionService.saveTransaction(account, initialCredit);
                }
                statusResponse = StatusResponse.SUCCESS;
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return statusResponse.toString();
    }
}
