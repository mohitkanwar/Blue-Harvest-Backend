package com.mk.blueharvest.backendassignment.account.entities;

import com.mk.blueharvest.backendassignment.account.util.AccountType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private long id;
    @Column(name = "ACCOUNTTYPE")
    private AccountType accountType;
    @Column(name = "BALANCE")
    private double balance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return getId() == account.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
