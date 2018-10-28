package com.mk.blueharvest.backendassignment.customers.dtos;

import com.mk.blueharvest.backendassignment.accounts.dtos.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private long customerId;

    private String givenName;
    private String surname;
    private List<AccountDTO> accounts;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<AccountDTO> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
