package com.ewa.project.service;

import com.ewa.project.model.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto getCustomerById(Long customerId);

    CustomerDto createCustomer(CustomerDto customerDto);
    
    CustomerDto authenticateCustomer(String email, String password);

    CustomerDto updateCustomer(Long customerId, CustomerDto customerDto);

    String deleteCustomer(Long customerId);

    List<CustomerDto> getAllCustomers();

	String deleteCustomerByEmail(String email);
}
