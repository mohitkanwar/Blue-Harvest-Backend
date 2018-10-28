package com.mk.blueharvest.backendassignment.account.adapters;

import com.mk.blueharvest.backendassignment.account.dto.TransactionDTO;
import com.mk.blueharvest.backendassignment.account.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionAdapter {
    public TransactionDTO getTransactionDTO(Transaction transaction) {
        return new TransactionDTO(transaction.getId(), transaction.getAmount(), transaction.getCreateDate());
    }
}
