package com.mk.blueharvest.backendassignment.customers.adapters;

import com.mk.blueharvest.backendassignment.accounts.adapters.AccountAdapter;
import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerAdapterTest {

    @MockBean
    private AccountAdapter accountAdapter;
    @Autowired
    private CustomerAdapter customerAdapter;

    @Test
    public void getCustomerDTO() {
        Customer entity = new Customer();
        entity.setId(1);
        entity.setGivenName("GivenName");
        entity.setSurname("surname");
        List<Account> accounts = new ArrayList<>();
        entity.setAccounts(accounts);
        Account account = new Account();
        accounts.add(account);
        AccountDTO accountDTO = new AccountDTO();
        when(accountAdapter.getAccountsDTO(account)).thenReturn(accountDTO);
        CustomerDTO dto = customerAdapter.getCustomerDTO(entity);
        assertEquals(1,dto.getCustomerId());
        assertEquals("GivenName",dto.getGivenName());
        assertEquals("surname",dto.getSurname());
        List<AccountDTO> accountDTOS = new ArrayList<>();
        accountDTOS.add(accountDTO);
        assertEquals(accountDTOS,dto.getAccounts());
    }

    @Test
    public void getCustomerEntity() {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(10);
        dto.setGivenName("GN");
        dto.setSurname("SN");
        List<AccountDTO> accountDTOs = new ArrayList<>();
        AccountDTO accountDTO = new AccountDTO();
        accountDTOs.add(accountDTO);
        dto.setAccounts(accountDTOs);
        Account account = new Account();
        when(accountAdapter.getAccountsEntity(accountDTO)).thenReturn(account);
       Customer adaptedCustomer =  customerAdapter.getCustomerEntity(dto);
       List<Account> accountList = new ArrayList<>();
        accountList.add(account);
       assertEquals(10,adaptedCustomer.getId());
       assertEquals("GN",adaptedCustomer.getGivenName());
       assertEquals("SN",adaptedCustomer.getSurname());
       assertEquals(accountList,adaptedCustomer.getAccounts());
    }

    @Test
    public void testNullInputs() {
       assertNull(customerAdapter.getCustomerDTO(null));
       assertNull(customerAdapter.getCustomerEntity(null));
    }
}