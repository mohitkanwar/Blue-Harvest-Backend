package com.mk.blueharvest.backendassignment.customers.controllers;

public class CreateAccountRequest {
    private long customerId;
    private double initialCredit;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(double initialCredit) {
        this.initialCredit = initialCredit;
    }
}
