package com.mk.blueharvest.backendassignment.accounts.adapters;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.dtos.TransactionDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.accounts.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Account Adapter converts Account entity to and from Account DTO
 */
@Component
public class AccountAdapter {
    private final TransactionAdapter transactionAdapter;

    @Autowired
    public AccountAdapter(TransactionAdapter transactionAdapter) {
        this.transactionAdapter = transactionAdapter;
    }

    /**
     * Convert AccountEntity to AccountDTO
     * It invokes transaction adapter
     * internally to convert TransactionEntity List to Transaction DTO List
     * if null input is provided, it returns a null
     * @param entity :Account
     * @return accountDTO
     */
    public AccountDTO getAccountsDTO(Account entity) {
        if (entity == null) {
            return null;
        }
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountType(entity.getAccountType());
        accountDTO.setBalance(entity.getBalance());
        accountDTO.setId(entity.getId());
        List<TransactionDTO> transactionDTOList =
                entity.getTransactions().stream().map
                        (transactionAdapter::getTransactionDTO)
                        .collect(Collectors.toList());
        accountDTO.setTransactions(transactionDTOList);
        return accountDTO;
    }

    /**
     * Converts Account DTO to Entity. Also converts the transaction DTO to entity if present
     * Returns null if null input is provided
     * @param accountDTO : AccountDTO
     * @return Account
     */
    public Account getAccountsEntity(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }
        Account accountEntity = new Account();
        accountEntity.setAccountType(accountDTO.getAccountType());
        accountEntity.setBalance(accountDTO.getBalance());
        if (accountDTO.getId() != 0) {
            accountEntity.setId(accountDTO.getId());
        }
        List<Transaction> transactionList =
                accountDTO.getTransactions().stream().map
                        (transactionAdapter::getTransactionEntity)
                        .collect(Collectors.toList());
        accountEntity.setTransactions(transactionList);
        return accountEntity;
    }
}
