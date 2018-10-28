package com.mk.blueharvest.backendassignment.accounts.adapters;

import com.mk.blueharvest.backendassignment.accounts.dtos.TransactionDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionAdapter {
    public TransactionDTO getTransactionDTO(Transaction transaction) {
        return new TransactionDTO(transaction.getId(), transaction.getAmount(), transaction.getCreateDate());
    }

    public Transaction getTransactionEntity(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setId(transactionDTO.getId());
        transaction.setCreateDate(transactionDTO.getCreateDate());
        return transaction;
    }
}
