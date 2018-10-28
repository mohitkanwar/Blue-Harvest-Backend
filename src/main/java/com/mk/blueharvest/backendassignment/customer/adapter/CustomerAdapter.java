package com.mk.blueharvest.backendassignment.customer.adapter;

import com.mk.blueharvest.backendassignment.account.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;
import com.mk.blueharvest.backendassignment.customer.dto.CustomerDTO;
import com.mk.blueharvest.backendassignment.customer.entities.Customer;
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
}
