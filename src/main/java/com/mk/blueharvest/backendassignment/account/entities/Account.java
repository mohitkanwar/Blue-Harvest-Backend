package com.mk.blueharvest.backendassignment.account.entities;

import com.mk.blueharvest.backendassignment.account.util.AccountType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ACCOUNTTYPE")
    private AccountType accountType;
    @Column(name = "BALANCE")
    private double balance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ACCOUNT_TRANSACTIONS",
            joinColumns = {@JoinColumn(name = "ACCOUNT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TRANSACTION_ID")}
    )
    private List<Transaction> transactions;

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

    public List<Transaction> getTransactions() {
        if(transactions==null){
            transactions = new ArrayList<>();
        }
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
