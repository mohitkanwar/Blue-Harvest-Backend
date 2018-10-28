package com.mk.blueharvest.backendassignment.customers.adapters;

import com.mk.blueharvest.backendassignment.accounts.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.accounts.dtos.AccountsDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerAdapter {
    private final AccountAdapter accountAdapter;

    @Autowired
    public CustomerAdapter(AccountAdapter accountAdapter) {
        this.accountAdapter = accountAdapter;
    }

    public CustomerDTO getCustomerDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(customer.getId());
        dto.setGivenName(customer.getGivenName());
        dto.setSurname(customer.getSurname());
        List<AccountsDTO> accountsDTOS = customer.getAccounts()
                .stream()
                .map(accountAdapter::getAccountsDTO)
                .collect(Collectors.toList());
        dto.setAccounts(accountsDTOS);
        return dto;
    }

    public Customer getCustomerEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        Customer entity = new Customer();
        entity.setId(dto.getCustomerId());
        entity.setGivenName(dto.getGivenName());
        entity.setSurname(dto.getSurname());
        List<Account> accountsEntityList = dto.getAccounts()
                .stream()
                .map(accountAdapter::getAccountsEntity)
                .collect(Collectors.toList());
        entity.setAccounts(accountsEntityList);
        return entity;
    }
}
