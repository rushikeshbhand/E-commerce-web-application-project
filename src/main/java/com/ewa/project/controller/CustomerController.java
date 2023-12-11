package com.ewa.project.controller;

import com.ewa.project.config.AuthResponse;
import com.ewa.project.config.JwtUtil;
import com.ewa.project.model.CustomerDto;
import com.ewa.project.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // The @RestController annotation indicates that this class is a spring MVC
				// controller responsible for handling HTTP requests and returning data as
				// response
@RequestMapping("/api/customers") // The @RequestMapping annotation sets the starting address ("/api/customers")
									// for all the operations this controller handle and any operations in this
@CrossOrigin("http://localhost:4200")									// class will be based on this address
public class CustomerController {

	@Autowired // automatically inject object of customer service
	private CustomerService customerService;

	// handling create customer request
	@PostMapping("/createCustomer")
	public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
		CustomerDto createdCustomer = customerService.createCustomer(customerDto);
		return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
	}
	
	@PostMapping("/signup")
    public ResponseEntity<CustomerDto> signup(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody CustomerDto customerDto) {
        String email = customerDto.getCustomerEmail();
        String password = customerDto.getCustomerPassword();

        CustomerDto authenticatedCustomer = customerService.authenticateCustomer(email, password);
        String token = JwtUtil.generateToken(authenticatedCustomer.getCustomerEmail());

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);

        return ResponseEntity.ok(authResponse);
    }
 
	// handling select all customer request
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<CustomerDto>> getAllCustomers() {
		List<CustomerDto> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}

	// handling select customer request
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long customerId) {
		CustomerDto customer = customerService.getCustomerById(customerId);
		return ResponseEntity.ok(customer);
	}

	// handling update customer request
	@PutMapping("/{customerId}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long customerId,
			@RequestBody CustomerDto customerDto) {
		CustomerDto updatedCustomer = customerService.updateCustomer(customerId, customerDto);
		return ResponseEntity.ok(updatedCustomer);
	}

	// handling delete customer request
//	@DeleteMapping("/{customerId}")
//	public String deleteCustomer(@PathVariable Long customerId) {
//		return customerService.deleteCustomer(customerId);
//	}
	
	@DeleteMapping("/{email}")
	public String deleteCustomerByEmail(@PathVariable String email) {
	    return customerService.deleteCustomerByEmail(email);
	}
}
