package com.mk.blueharvest.backendassignment.customers.utils;

public enum StatusResponse {
    SUCCESS("success"), FAILURE("failure");
    private String status;

    StatusResponse(String s) {
        this.status = s;
    }

    @Override
    public String toString() {
        return "{" +
                "status:'" + status + '\'' +
                '}';
    }
}
