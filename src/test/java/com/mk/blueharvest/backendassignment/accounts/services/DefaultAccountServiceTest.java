package com.mk.blueharvest.backendassignment.accounts.services;

import com.mk.blueharvest.backendassignment.accounts.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.accounts.repositories.AccountRepository;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultAccountServiceTest {

    @MockBean
    private AccountRepository accountRepository;
    @MockBean
    private AccountAdapter accountAdapter;
    @MockBean
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @Test
    public void addAccountToCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
        AccountDTO accountDTO = new AccountDTO();
        Account accountFromDB = new Account();
        accountFromDB.setId(20);
        AccountDTO adaptedAccountDTO = new AccountDTO();
        adaptedAccountDTO.setId(20);
        Account mockEntity = new Account();
        when(accountAdapter.getAccountsEntity(accountDTO)).thenReturn(mockEntity);
        when(accountRepository.save(mockEntity)).thenReturn(accountFromDB);
        when(customerService.save(customerDTO)).thenReturn(customerDTO);
        when(accountAdapter.getAccountsDTO(accountFromDB)).thenReturn(adaptedAccountDTO);
        AccountDTO accountDTOFromDB = accountService.addAccountToCustomer(customerDTO, accountDTO);
        assertEquals(20, accountDTOFromDB.getId());
    }


}