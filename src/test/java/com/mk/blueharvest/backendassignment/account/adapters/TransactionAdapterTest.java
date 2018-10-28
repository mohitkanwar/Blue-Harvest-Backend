package com.mk.blueharvest.backendassignment.account.adapters;

import com.mk.blueharvest.backendassignment.account.dto.TransactionDTO;
import com.mk.blueharvest.backendassignment.account.entities.Transaction;
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

}