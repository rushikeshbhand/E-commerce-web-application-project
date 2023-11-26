package com.ewa.project.repotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ewa.project.dao.CustomerRepository;
import com.ewa.project.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        // Create and save a customer
        Customer customer = new Customer();
        customer.setCustomerFirstName("rushi");
        customer.setCustomerLastName("bhand");
        customer.setCustomerEmail("rushi.bhand@gmail.com");
        customer.setCustomerPassword("password");
        customer.setCustomerAddress("ahmednagar");
        customer.setCustomerPhoneNo("7720917206");

        Customer savedCustomer = customerRepository.save(customer);
        assertNotNull(savedCustomer.getCustomerId());
    }

    @Test
    public void testGetAllCustomers() {
        // Clear the database to ensure a clean state
        customerRepository.deleteAll();

        // Create and save multiple customer entities
        Customer customer1 = new Customer(null, "ravi", "bhand", "ravi.bhand@gmail.com", "password", "ahmednagar", "9876543210", null);
        Customer customer2 = new Customer(null, "tushar", "alhat", "tushar.alhat@gmail.com", "password", "pimpalgaon", "8765432109", null);
        Customer customer3 = new Customer(null, "yash", "bhale", "yash.bhale@gmail.com", "password", "jalna", "7654321098", null);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        // Retrieve all customers from the database
        List<Customer> allCustomers = customerRepository.findAll();

        // Assert that the list is not empty and contains the expected number of customers
        assertNotNull(allCustomers);
        assertEquals(3, allCustomers.size());
    }

    @Test
    public void testGetCustomerById() {
        // Create and save a customer
        Customer customer = new Customer(null, "David", "Miller", "david.miller@gmail.com", "password", "sa", "6543210987", null);
        customer = customerRepository.save(customer);

        // Retrieve the customer by ID
        Customer retrievedCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);

        // Assert that the retrieved customer is not null and has the correct ID
        assertNotNull(retrievedCustomer);
        assertEquals(customer.getCustomerId(), retrievedCustomer.getCustomerId());
        assertEquals("David", retrievedCustomer.getCustomerFirstName());
        assertEquals("Miller", retrievedCustomer.getCustomerLastName());
        assertEquals("david.miller@gmail.com", retrievedCustomer.getCustomerEmail());
        assertEquals("password", retrievedCustomer.getCustomerPassword());
        assertEquals("sa", retrievedCustomer.getCustomerAddress());
        assertEquals("6543210987", retrievedCustomer.getCustomerPhoneNo());
    }

    @Test
    public void testUpdateCustomerById() {
        // Create and save a customer
        Customer customer = new Customer(null, "David", "Miller", "david.miller@gmail.com", "password", "sa", "6543210987", null);
        customer = customerRepository.save(customer);

        // Update the customer's details
        Long customerId = customer.getCustomerId();
        Customer updatedCustomer = customerRepository.findById(customerId).orElse(null);
        assertNotNull(updatedCustomer);

        // Modify the customer's attributes
        updatedCustomer.setCustomerFirstName("rohit"); // Update first name
        updatedCustomer.setCustomerLastName("nagarkar"); // Update last name
        updatedCustomer.setCustomerEmail("rohitnagarkar@gmail.com"); // Update email
        updatedCustomer.setCustomerPassword("newpassword"); // Update password
        updatedCustomer.setCustomerAddress("pipline road"); // Update address
        updatedCustomer.setCustomerPhoneNo("9876543210"); // Update phone number

        // Save the updated customer
        updatedCustomer = customerRepository.save(updatedCustomer);

        // Retrieve the updated customer from the database
        Customer retrievedCustomer = customerRepository.findById(customerId).orElse(null);
        assertNotNull(retrievedCustomer);

        // Assert that the attributes have been updated
        assertEquals("rohit", retrievedCustomer.getCustomerFirstName());
        assertEquals("nagarkar", retrievedCustomer.getCustomerLastName());
        assertEquals("rohitnagarkar@gmail.com", retrievedCustomer.getCustomerEmail());
        assertEquals("newpassword", retrievedCustomer.getCustomerPassword());
        assertEquals("pipline road", retrievedCustomer.getCustomerAddress());
        assertEquals("9876543210", retrievedCustomer.getCustomerPhoneNo());
    }


    @Test
    public void testDeleteCustomerById() {
        // Create and save a customer
        Customer customer = new Customer(null, "pranil", "arawade", "pranil.arawade@gmail.com", "password", "walki", "8765432101", null);
        customer = customerRepository.save(customer);

        // Get the ID of the customer to be deleted
        Long customerId = customer.getCustomerId();

        // Delete the customer by ID
        customerRepository.deleteById(customerId);

        // Try to retrieve the deleted customer by ID, and it should be null
        Customer deletedCustomer = customerRepository.findById(customerId).orElse(null);
        assertNull(deletedCustomer);
    }
}

