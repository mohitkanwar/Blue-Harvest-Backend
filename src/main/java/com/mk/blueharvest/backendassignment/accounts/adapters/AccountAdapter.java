package com.mk.blueharvest.backendassignment.accounts.adapters;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;
import com.mk.blueharvest.backendassignment.accounts.dtos.TransactionDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Account;
import com.mk.blueharvest.backendassignment.accounts.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountAdapter {
    private final TransactionAdapter transactionAdapter;

    @Autowired
    public AccountAdapter(TransactionAdapter transactionAdapter) {
        this.transactionAdapter = transactionAdapter;
    }

    public AccountDTO getAccountsDTO(Account account) {
        if (account == null) {
            return null;
        }
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountType(account.getAccountType());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setId(account.getId());
        List<TransactionDTO> transactionDTOList =
                account.getTransactions().stream().map
                        (transactionAdapter::getTransactionDTO)
                        .collect(Collectors.toList());
        accountDTO.setTransactions(transactionDTOList);
        return accountDTO;
    }

    public Account getAccountsEntity(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }
        Account account = new Account();
        account.setAccountType(accountDTO.getAccountType());
        account.setBalance(accountDTO.getBalance());
        if (accountDTO.getId() != 0) {
            account.setId(accountDTO.getId());
        }
        List<Transaction> transactionList =
                accountDTO.getTransactions().stream().map
                        (transactionAdapter::getTransactionEntity)
                        .collect(Collectors.toList());
        account.setTransactions(transactionList);
        return account;
    }
}
