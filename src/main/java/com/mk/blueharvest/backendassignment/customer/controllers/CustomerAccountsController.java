package com.mk.blueharvest.backendassignment.customer.controllers;

import com.mk.blueharvest.backendassignment.account.entities.Account;
import com.mk.blueharvest.backendassignment.account.services.AccountsService;
import com.mk.blueharvest.backendassignment.account.services.TransactionService;
import com.mk.blueharvest.backendassignment.account.util.AccountType;
import com.mk.blueharvest.backendassignment.customer.entities.Customer;
import com.mk.blueharvest.backendassignment.customer.services.CustomerService;
import com.mk.blueharvest.backendassignment.customer.util.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        try {
            if (customer.isPresent()) {
                Customer customer1 = customer.get();
                Account account = new Account();
                account.setAccountType(AccountType.CURRENT);
                account = accountsService.save(account);
                List<Account> accountList = customer1.getAccounts();
                accountList.add(account);
                customerService.save(customer1);
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
