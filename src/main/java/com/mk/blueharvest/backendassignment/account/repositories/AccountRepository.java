package com.mk.blueharvest.backendassignment.account.repositories;

import com.mk.blueharvest.backendassignment.account.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
}
