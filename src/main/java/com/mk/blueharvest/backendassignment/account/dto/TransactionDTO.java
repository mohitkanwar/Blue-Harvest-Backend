package com.mk.blueharvest.backendassignment.account.dto;

import javax.persistence.Column;
import java.util.Date;

public final class TransactionDTO {
    private final long id;
    private final double amount;
    private final Date createDate;

    public  TransactionDTO(long id, double amount, Date createDate) {
        this.id = id;
        this.amount = amount;
        this.createDate = (Date)createDate.clone();
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Date getCreateDate() {
        return (Date)createDate.clone();
    }
}
