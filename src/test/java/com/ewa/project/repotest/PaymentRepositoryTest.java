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

import com.ewa.project.dao.PaymentRepository;
import com.ewa.project.entity.Payment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void testCreatePayment() {
        // Create and save a payment
        Payment payment = new Payment();
        payment.setPaymentAmount(150.0);
        payment.setPaymentStatus("Paid");
        payment.setPaymentMethod("Credit Card");

        Payment savedPayment = paymentRepository.save(payment);
        assertNotNull(savedPayment.getPaymentId());
    }

    @Test
    public void testGetAllPayments() {
        // Clear the database to ensure a clean state
        paymentRepository.deleteAll();

        // Create and save multiple payment entities
        Payment payment1 = new Payment(null, 200.0, "Pending", "PayPal", null);
        Payment payment2 = new Payment(null, 100.0, "Paid", "Credit Card", null);
        Payment payment3 = new Payment(null, 300.0, "Failed", "Bank Transfer", null);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
        paymentRepository.save(payment3);

        // Retrieve all payments from the database
        List<Payment> allPayments = paymentRepository.findAll();

        // Assert that the list is not empty and contains the expected number of payments
        assertNotNull(allPayments);
        assertEquals(3, allPayments.size());
    }

    @Test
    public void testGetPaymentById() {
        // Create and save a payment
        Payment payment = new Payment(null, 150.0, "Paid", "Credit Card", null);
        payment = paymentRepository.save(payment);

        // Retrieve the payment by ID
        Payment retrievedPayment = paymentRepository.findById(payment.getPaymentId()).orElse(null);

        // Assert that the retrieved payment is not null and has the correct ID
        assertNotNull(retrievedPayment);
        assertEquals(payment.getPaymentId(), retrievedPayment.getPaymentId());
        assertEquals(150.0, retrievedPayment.getPaymentAmount());
        assertEquals("Paid", retrievedPayment.getPaymentStatus());
        assertEquals("Credit Card", retrievedPayment.getPaymentMethod());
    }

    @Test
    public void testUpdatePaymentById() {
        // Create and save a payment
        Payment payment = new Payment(null, 120.0, "Pending", "PayPal", null);
        payment = paymentRepository.save(payment);

        // Update the payment's details
        Long paymentId = payment.getPaymentId();
        Payment updatedPayment = paymentRepository.findById(paymentId).orElse(null);
        assertNotNull(updatedPayment);

        // Modify the payment's attributes
        updatedPayment.setPaymentAmount(130.0); // Update payment amount
        updatedPayment.setPaymentStatus("Paid"); // Update payment status
        updatedPayment.setPaymentMethod("Credit Card"); // Update payment method

        // Save the updated payment
        updatedPayment = paymentRepository.save(updatedPayment);

        // Retrieve the updated payment from the database
        Payment retrievedPayment = paymentRepository.findById(paymentId).orElse(null);
        assertNotNull(retrievedPayment);

        // Assert that the attributes have been updated
        assertEquals(130.0, retrievedPayment.getPaymentAmount());
        assertEquals("Paid", retrievedPayment.getPaymentStatus());
        assertEquals("Credit Card", retrievedPayment.getPaymentMethod());
    }

    @Test
    public void testDeletePaymentById() {
        // Create and save a payment
        Payment payment = new Payment(null, 80.0, "Failed", "Bank Transfer", null);
        payment = paymentRepository.save(payment);

        // Get the ID of the payment to be deleted
        Long paymentId = payment.getPaymentId();

        // Delete the payment by ID
        paymentRepository.deleteById(paymentId);

        // Try to retrieve the deleted payment by ID, and it should be null
        Payment deletedPayment = paymentRepository.findById(paymentId).orElse(null);
        assertNull(deletedPayment);
    }
}

