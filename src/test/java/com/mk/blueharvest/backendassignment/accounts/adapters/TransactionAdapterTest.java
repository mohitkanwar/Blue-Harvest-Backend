package com.mk.blueharvest.backendassignment.accounts.adapters;

import com.mk.blueharvest.backendassignment.accounts.dtos.TransactionDTO;
import com.mk.blueharvest.backendassignment.accounts.entities.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionAdapterTest {
    @Autowired
    private TransactionAdapter adapter;

    @Test
    public void shouldReturnCorrectDTO() {
        Transaction transaction = new Transaction();
        Date createDate = new Date();
        transaction.setCreateDate(createDate);
        double amount = 20.05;
        transaction.setAmount(amount);
        long id = 20000;
        transaction.setId(id);
        TransactionDTO dto = adapter.getTransactionDTO(transaction);
        assertEquals(id, dto.getId());
        assertEquals(amount, dto.getAmount(), 0);
        assertEquals(createDate, dto.getCreateDate());
    }
    @Test
    public void shouldReturnCorrectEntity() {
        long id = 2000;
        double amount = 20.05;
        Date createDate = new Date();
        TransactionDTO dto = new TransactionDTO(id,amount,createDate);
        Transaction entity = adapter.getTransactionEntity(dto);
        assertEquals(id, entity.getId());
        assertEquals(amount, entity.getAmount(), 0);
        assertEquals(createDate, entity.getCreateDate());
    }

}