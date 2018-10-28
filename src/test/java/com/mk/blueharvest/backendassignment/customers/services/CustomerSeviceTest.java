package com.mk.blueharvest.backendassignment.customers.services;

import com.mk.blueharvest.backendassignment.customers.adapters.CustomerAdapter;
import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.entities.Customer;
import com.mk.blueharvest.backendassignment.customers.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerSeviceTest {
    @Autowired
    private CustomerService customerService;
    @MockBean
    private CustomerRepository customerRepository;
    @MockBean
    private CustomerAdapter customerAdapter;

    @Test
    public void save() {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer customer = new Customer();
        when(customerAdapter.getCustomerEntity(customerDTO)).thenReturn(customer);
        when(customerAdapter.getCustomerDTO(customer)).thenReturn(customerDTO);
        when(customerRepository.save(customer)).thenReturn(customer);
        CustomerDTO customerDTOFromDb = customerService.save(customerDTO);
        assertEquals(customerDTOFromDb, customerDTO);
    }

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        CustomerDTO customerDTO = new CustomerDTO();
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        when(customerRepository.findAll()).thenReturn(customers);
        when(customerAdapter.getCustomerDTO(customer)).thenReturn(customerDTO);
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        assertEquals(1, customerDTOS.size());
    }

    @Test
    public void getCustomerById() {
        long customerId = 10;
        Customer customer = new Customer();
        CustomerDTO customerDTO = new CustomerDTO();
        Optional<Customer> optional = Optional.of(customer);
        when(customerAdapter.getCustomerDTO(customer)).thenReturn(customerDTO);
        when(customerRepository.findById(customerId)).thenReturn(optional);
        Optional<CustomerDTO> output = customerService.getCustomerById(customerId);
        assertEquals(Optional.of(customerDTO), output);
    }

    @Test
    public void testNoCustomerFoundById() {
        long customerId = 10;
        Customer customer = new Customer();
        CustomerDTO customerDTO = new CustomerDTO();

        when(customerAdapter.getCustomerDTO(customer)).thenReturn(customerDTO);
        when(customerRepository.findById(customerId)).thenReturn(Optional.ofNullable(null));
        Optional<CustomerDTO> output = customerService.getCustomerById(customerId);
        assertEquals(Optional.ofNullable(null), output);
    }
}