package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Product;
@Repository // Indicates that this interface is a Spring Data repository
public interface ProductRepository extends JpaRepository<Product, Long> {// It provides methods for common CRUD operations

	Product findByProductId(Long productId);
    
}