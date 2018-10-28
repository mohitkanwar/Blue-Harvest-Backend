package com.mk.blueharvest.backendassignment.accounts.adapters;

import com.mk.blueharvest.backendassignment.accounts.dtos.TransactionDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Transaction;
import org.springframework.stereotype.Component;

/**
 * Convverts Transaction Entity to and from DTO
 */
@Component
public class TransactionAdapter {
    /**
     * Converts Transaction Entity to Transaction DTO.
     * @param transactionEntity : Transaction
     * @return TransactionDTO
     */
    TransactionDTO getTransactionDTO(Transaction transactionEntity) {
        return new TransactionDTO(transactionEntity.getId(), transactionEntity.getAmount(), transactionEntity.getCreateDate());
    }

    Transaction getTransactionEntity(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setId(transactionDTO.getId());
        transaction.setCreateDate(transactionDTO.getCreateDate());
        return transaction;
    }
}
