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
@Table(name = "Admin_Details")
public class Admin {
	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long adminId;

	@NotBlank
	@Column(name = "admin_username")
	private String adminUsername;

	@NotBlank
	@Size(min = 6, max = 20, message = "Password must be between 6 to 20 characters")
	@Column(name = "admin_password")
	private String adminPassword;

	@Email(message = "Please provide a valid email address")
	@Column(name = "admin_email")
	private String adminEmail;

	@Size(min = 10, max = 10, message = "Contact number must have exactly 10 Numbers")
	@Column(name = "admin_contact_number")
	private String adminContact;
	
    //All argument constructor
	public Admin(Long adminId, @NotBlank String adminUsername,
			@NotBlank @Size(min = 6, max = 20, message = "Password must be between 6 to 20 characters") String adminPassword,
			@Email(message = "Please provide a valid email address") String adminEmail,
			@Size(min = 10, max = 10, message = "Contact number must have exactly 10 Numbers") String adminContact) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
		this.adminContact = adminContact;
	}
	
    //No argument constructor
	public Admin() {
		super();
	}

	// getter and setter
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
