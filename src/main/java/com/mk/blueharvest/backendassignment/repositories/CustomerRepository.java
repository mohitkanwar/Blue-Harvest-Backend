package com.mk.blueharvest.backendassignment.repositories;

import com.mk.blueharvest.backendassignment.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
