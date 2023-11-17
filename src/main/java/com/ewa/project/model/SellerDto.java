package com.ewa.project.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SellerDto {

    private Long sellerId;

    @NotBlank
    @Column(name = "seller_username")
    private String sellerUsername;

    @NotBlank
    @Size(min = 6, max = 20, message = "Password must be between 6 to 20 characters")
    @Column(name = "seller_password")
    private String sellerPassword;

    @Email(message = "Please provide a valid email address")
    @Column(name = "seller_email")
    private String sellerEmail;

    @Size(min = 10, max = 10, message = "Contact number must have exactly 10 Numbers")
    @Column(name = "seller_contact_number")
    private String sellerContact;
    
    @Column(name = "seller_address")
    private String sellerAddress;

    //getter and setter
	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerUsername() {
		return sellerUsername;
	}

	public void setSellerUsername(String sellerUsername) {
		this.sellerUsername = sellerUsername;
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
