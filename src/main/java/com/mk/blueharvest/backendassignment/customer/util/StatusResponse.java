package com.mk.blueharvest.backendassignment.customer.util;

public enum StatusResponse {
    SUCCESS("success"), FAILURE("failure");
    private String status;

    StatusResponse(String s) {
        this.status = s;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                '}';
    }
}
