package com.ewa.project.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ewa.project.entity.Cart;

public class CustomerDto {

	private Long customerId;

	@NotBlank(message = "Please enter customer first name")
	private String customerFirstName;

	@NotBlank(message = "Please enter customer last name")
	private String customerLastName;

	@NotBlank
	@Email(message = "Please enter valid email")
	private String customerEmail;

	@Size(min = 6, max = 20, message = "Password must be between 6 to 20 characters")
	@NotBlank(message = "Enter valid password")
	private String customerPassword;

	@NotBlank(message = "Please enter customer address")
	private String customerAddress;

	@NotBlank
	@Size(min = 10, max = 10, message = "Contact number must have exactly 10 characters.")
	private String customerPhoneNo;

	// Relationships
	private Cart cart;

	// getters and setters
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
