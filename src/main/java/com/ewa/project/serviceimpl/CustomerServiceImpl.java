package com.ewa.project.serviceimpl;

import com.ewa.project.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewa.project.converter.CustomerConverter;
import com.ewa.project.dao.CustomerRepository;
import com.ewa.project.entity.Customer;
import com.ewa.project.model.CustomerDto;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired //Autowired is used to inject object automatically
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override //creating cusotmer
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = customerConverter.convertToCustomerEntity(customerDto);
        customer = customerRepository.save(customer);
        return customerConverter.convertToCustomerDto(customer);
    }

    @Override //selecting customer by its id
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
        return customerConverter.convertToCustomerDto(customer);
    }

    @Override //updating cutomer by passing cusotmer id as input
    public CustomerDto updateCustomer(Long customerId, CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findByCustomerId(customerId);
        if (existingCustomer == null) {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }

       
        Customer updatedCustomer = customerConverter.convertToCustomerEntity(customerDto);
        updatedCustomer.setCustomerId(customerId);

      
        customerRepository.save(updatedCustomer);

        return customerConverter.convertToCustomerDto(updatedCustomer);
    }

    
    @Override 
    public String deleteCustomer(Long customerId) { //deleting customer by passing his id 
        Customer customer = customerRepository.findByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }
        customerRepository.delete(customer);
        return "Customer with ID " + customerId + " has been deleted successfully.";
    }

    @Override
    public List<CustomerDto> getAllCustomers() { //selecting all customers
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> dtoList = new ArrayList<>();
        for (Customer c : customers) {
            dtoList.add(customerConverter.convertToCustomerDto(c));
        }
        return dtoList;
    }
}
