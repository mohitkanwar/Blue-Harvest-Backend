package com.mk.blueharvest.backendassignment.customers.errors;

public enum CustomerErrorCodes {
    CUSTOMER_PAGE_SIZE_LESS_THAN_ONE,CUSTOMER_PAGE_INDEX_LESS_THAN_ZERO;

    @Override
    public String toString() {
        return this.name().toUpperCase();
    }
}
