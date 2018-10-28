package com.mk.blueharvest.backendassignment.customer.controllers;

import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;
import com.mk.blueharvest.backendassignment.account.dto.TransactionDTO;
import com.mk.blueharvest.backendassignment.customer.dto.CustomerDTO;
import com.mk.blueharvest.backendassignment.customer.entities.Customer;
import com.mk.blueharvest.backendassignment.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/list")
    public List<CustomerDTO> getCustomersList() {
        List<CustomerDTO> response = new ArrayList<>();
        List<Customer> customers = customerService.getAllCustomers();
        customers.forEach(customer -> {
            CustomerDTO dto = new CustomerDTO();
            dto.setCustomerId(customer.getId());
            dto.setGivenName(customer.getGivenName());
            dto.setSurname(customer.getSurname());
            List<AccountsDTO> accountsDTOS = new ArrayList<>();
            customer.getAccounts().forEach(account -> {
                AccountsDTO accountsDTO = new AccountsDTO();
                accountsDTO.setAccountType(account.getAccountType());
                accountsDTO.setBalance(account.getBalance());
                accountsDTO.setId(account.getId());
                List<TransactionDTO> transactionDTOList = new ArrayList<>();
                account.getTransactions().forEach(transaction -> {
                    transactionDTOList.add(new TransactionDTO(transaction.getId(),transaction.getAmount(),transaction.getCreateDate()));
                });
                accountsDTO.setTransactions(transactionDTOList);
                accountsDTOS.add(accountsDTO);
            });
            dto.setAccounts(accountsDTOS);
            response.add(dto);
        });
        return response;
    }
}
