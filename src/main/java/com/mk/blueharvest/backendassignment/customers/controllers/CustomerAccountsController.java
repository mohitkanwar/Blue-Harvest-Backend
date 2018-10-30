package com.mk.blueharvest.backendassignment.customers.controllers;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.services.AccountService;
import com.mk.blueharvest.backendassignment.accounts.services.TransactionService;
import com.mk.blueharvest.backendassignment.accounts.utils.AccountType;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.errors.CustomerErrorCodes;
import com.mk.blueharvest.backendassignment.customers.services.CustomerService;
import com.mk.blueharvest.backendassignment.customers.utils.ErrorResponse;
import com.mk.blueharvest.backendassignment.customers.utils.SimpleResponse;
import com.mk.blueharvest.backendassignment.customers.utils.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public SimpleResponse createCurrentAccount(@RequestBody CreateAccountRequest requestBody) {
        SimpleResponse response = new SimpleResponse();
        response.setStatus(StatusResponse.FAILURE);
        Optional<CustomerDTO> customer = customerService.getCustomerById(requestBody.getCustomerId());
        if (customer.isPresent()) {
            CustomerDTO customer1 = customer.get();
            AccountDTO account = new AccountDTO();
            account.setAccountType(AccountType.CURRENT);
            account = accountService.addAccountToCustomer(customer1, account);
            if (requestBody.getInitialCredit() != 0) {
                transactionService.saveTransaction(account, requestBody.getInitialCredit());
            }
            response.setStatus(StatusResponse.SUCCESS);
        }
        else{
            ErrorResponse errorResponse = new ErrorResponse();
            // Although a potentiol security bug
            errorResponse.setErrorCode(CustomerErrorCodes.CUSTOMER_NOT_FOUND.toString());
            errorResponse.setAdditionalInfo("The customer with ID ["+requestBody.getCustomerId()+"] was not found!");
        }
        return response;
    }
}
