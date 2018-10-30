package com.mk.blueharvest.backendassignment.customers.repositories;

import com.mk.blueharvest.backendassignment.customers.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
