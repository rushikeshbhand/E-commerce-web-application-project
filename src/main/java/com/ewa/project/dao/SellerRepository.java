package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Seller;

@Repository // Indicates that this interface is a Spring Data repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
	Seller findBySellerEmailAndSellerPassword(String email, String password);// It provides methods for common CRUD operations

	Seller findBySellerEmail(String email);
}
