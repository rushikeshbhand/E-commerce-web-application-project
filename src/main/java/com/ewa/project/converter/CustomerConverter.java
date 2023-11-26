package com.ewa.project.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ewa.project.entity.Customer;
import com.ewa.project.model.CustomerDto;

@Component // Indicates that this class is a Spring component
public class CustomerConverter {

    // Convert from dto to Entity
    public Customer convertToCustomerEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        if (customerDto != null) {
            BeanUtils.copyProperties(customerDto, customer);
        }
        return customer;
    }

    // Convert from Entity to dto
    public CustomerDto convertToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        if (customer != null) {
            BeanUtils.copyProperties(customer, customerDto);
        }
        return customerDto;
    }
}
