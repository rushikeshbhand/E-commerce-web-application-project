package com.ewa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewa.project.exception.AdminNotFoundException;
import com.ewa.project.model.AdminDto;
import com.ewa.project.service.AdminService;

@RestController // The @RestController annotation indicates that this class is a spring MVC
				// controller responsible for handling HTTP requests and returning data as
				// response
@RequestMapping("/admins") // The @RequestMapping annotation sets the starting address ("/admins") for all
							// the operations this controller handle and any operations in this class will
							// be based on this address
public class AdminController {

	@Autowired // injecting object automatically by using autowired
	private AdminService adminService;

	@PostMapping("/createAdmin") // controller to handled create admin request
	public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
		AdminDto createdAdmin = adminService.createAdmin(adminDto);
		return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
	}

	@GetMapping("/{adminId}") // contoller to handled selecting admin by its id request and if admin not found
								// then it will throw admin not found exception
	public ResponseEntity<AdminDto> getAdminById(@PathVariable Long adminId) {
		AdminDto adminDto = adminService.getAdminById(adminId);
		if (adminDto == null) {
			throw new AdminNotFoundException("Admin not found with ID: " + adminId);
		}
		return new ResponseEntity<>(adminDto, HttpStatus.OK);
	}

	@GetMapping("/getAllAdmins") // selecting all admins request handling method
	public ResponseEntity<List<AdminDto>> getAllAdmins() {
		List<AdminDto> admins = adminService.getAllAdmins();
		return new ResponseEntity<>(admins, HttpStatus.OK);
	}

	@PutMapping("/{adminId}") // handling admin updating request
	public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long adminId, @RequestBody AdminDto adminDto) {
		AdminDto updatedAdmin = adminService.updateAdmin(adminId, adminDto);
		return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
	}

	@DeleteMapping("/{adminId}") // handleling delete admin request
	public String deleteAdmin(@PathVariable Long adminId) {

		return adminService.deleteAdmin(adminId);
	}
}
