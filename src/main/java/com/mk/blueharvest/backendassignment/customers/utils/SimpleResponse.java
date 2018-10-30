package com.mk.blueharvest.backendassignment.customers.utils;

public class SimpleResponse {
    private StatusResponse status;

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    private ErrorResponse error;
}
