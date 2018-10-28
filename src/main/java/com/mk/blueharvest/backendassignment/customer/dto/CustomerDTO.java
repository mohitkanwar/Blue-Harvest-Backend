package com.mk.blueharvest.backendassignment.customer.dto;

import com.mk.blueharvest.backendassignment.account.dto.AccountsDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private long customerId;

    private String givenName;
    private String surname;
    private List<AccountsDTO> accounts;

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

    public List<AccountsDTO> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        return accounts;
    }

    public void setAccounts(List<AccountsDTO> accounts) {
        this.accounts = accounts;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
