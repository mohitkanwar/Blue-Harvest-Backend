package com.mk.blueharvest.backendassignment.customers.repositories;

import com.mk.blueharvest.backendassignment.customers.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
