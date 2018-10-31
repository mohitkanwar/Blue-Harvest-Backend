package com.mk.blueharvest.backendassignment.customers.utils;


import org.springframework.data.domain.PageRequest;

import java.util.List;

public class PaginatedListResponse<T> {
    private List<T> dataList;
    private long totalCount;
    private StatusResponse status;
    private ErrorResponse error;
    private int pageNumber;
    private int pageSize;


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public List<T> getDataList() {
        return dataList;
    }

    public long getTotalCount() {
        return totalCount;
    }

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

    public void setDataList(final List<T> dataList) {
        this.dataList =  dataList;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
