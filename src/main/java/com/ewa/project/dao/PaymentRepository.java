package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Payment;
@Repository // Indicates that this interface is a Spring Data repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {// It provides methods for common CRUD operations

    Payment findByPaymentId(Long paymentId);
}
