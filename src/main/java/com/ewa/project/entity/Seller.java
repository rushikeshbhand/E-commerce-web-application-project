package com.ewa.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Seller_Details")
public class Seller {
	@Id
	@Column(name = "seller_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerId;

	@NotBlank
	@Column(name = "seller_first_name")
	private String sellerFirstName;
	
	@NotBlank
	@Column(name = "seller_last_name")
	private String sellerLastName;

	@Email(message = "Please provide a valid email address")
	@Column(name = "seller_email")
	private String sellerEmail;
	
	@NotBlank
	@Size(min = 6, max = 20, message = "Password must be between 6 to 20 characters")
	@Column(name = "seller_password")
	private String sellerPassword;

	@Size(min = 10, max = 10, message = "Contact number must have exactly 10 Numbers")
	@Column(name = "seller_contact_number")
	private String sellerContact;

	@Column(name = "seller_address")
	private String sellerAddress;

	// All argument constructor

	public Seller(Long sellerId, @NotBlank String sellerFirstName, @NotBlank String sellerLastName,
			@Email(message = "Please provide a valid email address") String sellerEmail,
			@NotBlank @Size(min = 6, max = 20, message = "Password must be between 6 to 20 characters") String sellerPassword,
			@Size(min = 10, max = 10, message = "Contact number must have exactly 10 Numbers") String sellerContact,
			String sellerAddress) {
		super();
		this.sellerId = sellerId;
		this.sellerFirstName = sellerFirstName;
		this.sellerLastName = sellerLastName;
		this.sellerEmail = sellerEmail;
		this.sellerPassword = sellerPassword;
		this.sellerContact = sellerContact;
		this.sellerAddress = sellerAddress;
	}


	// No argument constructor
	public Seller() {
		super();
	}

	// getters and setters
	public String getSellerFirstName() {
		return sellerFirstName;
	}

	public void setSellerFirstName(String sellerFirstName) {
		this.sellerFirstName = sellerFirstName;
	}

	public String getSellerLastName() {
		return sellerLastName;
	}

	public void setSellerLastName(String sellerLastName) {
		this.sellerLastName = sellerLastName;
	}
	
	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerContact() {
		return sellerContact;
	}

	public void setSellerContact(String sellerContact) {
		this.sellerContact = sellerContact;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

}
