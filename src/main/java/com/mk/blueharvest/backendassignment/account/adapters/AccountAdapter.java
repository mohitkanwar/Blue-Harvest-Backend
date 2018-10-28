package com.mk.blueharvest.backendassignment.account.adapters;

import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;
import com.mk.blueharvest.backendassignment.account.dto.TransactionDTO;
import com.mk.blueharvest.backendassignment.account.entities.Account;
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

    public AccountsDTO getAccountsDTO(Account account) {
        AccountsDTO accountsDTO = new AccountsDTO();
        accountsDTO.setAccountType(account.getAccountType());
        accountsDTO.setBalance(account.getBalance());
        accountsDTO.setId(account.getId());
        List<TransactionDTO> transactionDTOList =
                account.getTransactions().stream().map
                        (transactionAdapter::getTransactionDTO)
                        .collect(Collectors.toList());
        accountsDTO.setTransactions(transactionDTOList);
        return accountsDTO;
    }
}
