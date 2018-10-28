package com.mk.blueharvest.backendassignment.account.repositories;

import com.mk.blueharvest.backendassignment.account.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {
}
