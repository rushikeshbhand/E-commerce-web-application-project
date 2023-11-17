package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Customer;
@Repository // Indicates that this interface is a Spring Data repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {// It provides methods for common CRUD operations

    Customer findByCustomerId(Long customerId);
}
