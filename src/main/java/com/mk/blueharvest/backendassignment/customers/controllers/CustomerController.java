package com.mk.blueharvest.backendassignment.customers.controllers;


import com.mk.blueharvest.backendassignment.customers.dtos.CustomerDTO;
import com.mk.blueharvest.backendassignment.customers.errors.CustomerErrorCodes;
import com.mk.blueharvest.backendassignment.customers.services.CustomerService;
import com.mk.blueharvest.backendassignment.customers.utils.ErrorResponse;
import com.mk.blueharvest.backendassignment.customers.utils.PaginatedListResponse;
import com.mk.blueharvest.backendassignment.customers.utils.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/list")
    public PaginatedListResponse<CustomerDTO> getCustomersList(@RequestParam(required = false, defaultValue = "0") int pagenumber, @RequestParam(required = false,defaultValue = "10") int pagesize) {
        PaginatedListResponse<CustomerDTO> response = new PaginatedListResponse<>();
        if (pagesize<1){
            response.setStatus(StatusResponse.FAILURE);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setAdditionalInfo("Page size must not be less than one!");
            errorResponse.setErrorCode(CustomerErrorCodes.CUSTOMER_PAGE_SIZE_LESS_THAN_ONE.toString());
            response.setError(errorResponse);
        }
        else if(pagenumber<0){

            response.setStatus(StatusResponse.FAILURE);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setAdditionalInfo("Page index must not be less than zero!");
            errorResponse.setErrorCode(CustomerErrorCodes.CUSTOMER_PAGE_INDEX_LESS_THAN_ZERO.toString());
            response.setError(errorResponse);
        }
        else{
            response.setDataList( customerService.getAllCustomers(pagenumber,pagesize));
            response.setTotalCount(customerService.getCustomersCount());
            response.setStatus(StatusResponse.SUCCESS);
        }

        response.setPageNumber(pagenumber);
        response.setPageSize(pagesize);

        return response;
    }


}
