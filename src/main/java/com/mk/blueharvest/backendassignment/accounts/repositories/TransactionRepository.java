package com.mk.blueharvest.backendassignment.accounts.repositories;

import com.mk.blueharvest.backendassignment.accounts.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
