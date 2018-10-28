package com.mk.blueharvest.backendassignment.customer.repositories;

import com.mk.blueharvest.backendassignment.customer.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
