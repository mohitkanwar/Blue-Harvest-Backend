package com.mk.blueharvest.backendassignment.accounts.repositories;

import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
