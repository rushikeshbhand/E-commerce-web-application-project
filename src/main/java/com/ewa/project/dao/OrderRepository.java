package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Order;
@Repository // Indicates that this interface is a Spring Data repository
public interface OrderRepository extends JpaRepository<Order, Long> {// It provides methods for common CRUD operations

	Order findByOrderId(Long OrderId);
    
}
