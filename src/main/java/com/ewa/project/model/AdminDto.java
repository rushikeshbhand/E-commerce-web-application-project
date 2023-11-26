package com.ewa.project.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdminDto {

	private Long adminId;

	@NotBlank(message = "Enter admins username")
	private String adminUsername;

	@NotBlank(message = "Enter valid password")
	private String adminPassword;

	@NotBlank
	@Email(message = "Please enter valid email")
	private String adminEmail;

	@NotBlank
	@Size(min = 10, max = 10, message = "Contact number must have exactly 10 characters.")
	private String adminContact;
	
    //getter and setter

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

}
