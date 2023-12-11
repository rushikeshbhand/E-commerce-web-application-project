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

import com.ewa.project.dao.AdminRepository;
import com.ewa.project.entity.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    public void testCreateAdmin() {
        // Create and save an admin
        Admin admin = new Admin();
        admin.setAdminPassword("password123");
        admin.setAdminEmail("rushi@gmail.com");
        admin.setAdminContact("7720917260");

        Admin savedAdmin = adminRepository.save(admin);
        assertNotNull(savedAdmin.getAdminId());
    }

    @Test
    public void testGetAllAdmins() {
        
        adminRepository.deleteAll();

        // Create and save multiple admin entities
        Admin admin1 = new Admin(null, "rushi", "password1", "rushi@gmail.com", "7720917260");
        Admin admin2 = new Admin(null, "yash", "password2", "yash@gmail.com", "1234567890");
        Admin admin3 = new Admin(null, "rohit", "password3", "rohit@gmail.com", "1234567890");

        adminRepository.save(admin1);
        adminRepository.save(admin2);
        adminRepository.save(admin3);

        // Retrieve all admins from the database
        List<Admin> allAdmins = adminRepository.findAll();

        // Assert that the list is not empty and contains the expected number of admins
        assertNotNull(allAdmins);
        assertEquals(3, allAdmins.size());
    }

    @Test
    public void testGetAdminById() {
        // Create and save an admin
        Admin admin = new Admin(null, "rohit", "password3", "rohit@gmail.com", "1234567890");
        admin = adminRepository.save(admin);

        // Retrieve the admin by ID
        Admin retrievedAdmin = adminRepository.findById(admin.getAdminId()).orElse(null);

        // Assert that the retrieved admin is not null and has the correct ID
        assertNotNull(retrievedAdmin);
        assertEquals(admin.getAdminId(), retrievedAdmin.getAdminId());
        assertEquals("password3", retrievedAdmin.getAdminPassword());
        assertEquals("rohit@gmail.com", retrievedAdmin.getAdminEmail());
        assertEquals("1234567890", retrievedAdmin.getAdminContact());
    }

    @Test
    public void testUpdateAdminById() {
        // Create and save an admin
        Admin admin = new Admin(null, "admin1", "password1", "rohit@gmail.com", "1234567890");
        admin = adminRepository.save(admin);

        // Update the admin's details
        Long adminId = admin.getAdminId();
        Admin updatedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNotNull(updatedAdmin);

        // Modify the admin's attributes
        updatedAdmin.setAdminPassword("newPassword1"); // Update password
        updatedAdmin.setAdminEmail("vishal@gmail.com"); // Update email
        updatedAdmin.setAdminContact("9876543210"); // Update contact number

        // Save the updated admin
        updatedAdmin = adminRepository.save(updatedAdmin);

        // Retrieve the updated admin from the database
        Admin retrievedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNotNull(retrievedAdmin);

        // Assert that the attributes have been updated
        assertEquals("newPassword1", retrievedAdmin.getAdminPassword());
        assertEquals("vishal@gmail.com", retrievedAdmin.getAdminEmail());
        assertEquals("9876543210", retrievedAdmin.getAdminContact());
    }

    @Test
    public void testDeleteAdminById() {
        // Create and save an admin
        Admin admin = new Admin(null, "yash", "password2", "yash@gmail.com", "1234567890");
        admin = adminRepository.save(admin);

        // Get the ID of the admin to be deleted
        Long adminId = admin.getAdminId();

        // Delete the admin by ID
        adminRepository.deleteById(adminId);

        // Try to retrieve the deleted admin by ID, and it should be null
        Admin deletedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNull(deletedAdmin);
    }
}

