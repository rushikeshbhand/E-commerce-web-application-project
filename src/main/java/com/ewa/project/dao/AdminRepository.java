package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Admin;
@Repository // Indicates that this interface is a Spring Data repository
public interface AdminRepository extends JpaRepository<Admin, Long> {// It provides methods for common CRUD operations
    Admin findByAdminEmailAndAdminPassword(String email, String password);
}
