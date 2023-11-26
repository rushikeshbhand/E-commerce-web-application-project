package com.ewa.project.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewa.project.converter.PaymentConverter;
import com.ewa.project.dao.PaymentRepository;
import com.ewa.project.entity.Payment;
import com.ewa.project.exception.PaymentNotFoundException;
import com.ewa.project.model.PaymentDto;
import com.ewa.project.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired //Autowired is used to inject object automatically
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentConverter paymentConverter;

    @Override //seleting payment by its id 
    public PaymentDto getPaymentById(Long paymentId) {
        Payment payment = paymentRepository.findByPaymentId(paymentId);
        if (payment == null) {
            throw new PaymentNotFoundException("Payment not found with ID: " + paymentId);
        }
        return paymentConverter.convertToPaymentDto(payment);
    }
    
    @Override //selecting all payments
    public List<PaymentDto> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentDto> paymentDtos = new ArrayList<>();

        for (Payment payment : payments) {
            paymentDtos.add(paymentConverter.convertToPaymentDto(payment));
        }

        return paymentDtos;
    }

    @Override //creating payment and if exception is occur then failed to create the payment will print 
    public PaymentDto createPayment(PaymentDto paymentDto) {
        if (paymentDto == null) {
            throw new IllegalArgumentException("PaymentDto cannot be null");
        }

        Payment payment = paymentConverter.convertToPaymentEntity(paymentDto);
        
        payment = paymentRepository.save(payment);

        if (payment == null) {
            throw new RuntimeException("Failed to create the payment");
        }

        return paymentConverter.convertToPaymentDto(payment);
    }

  
    @Override //updating payment
    public PaymentDto updatePayment(Long paymentId, PaymentDto paymentDto) {
        Payment existingPayment = paymentRepository.findByPaymentId(paymentId);
        if (existingPayment == null) {
            throw new PaymentNotFoundException("Payment not found with ID: " + paymentId);
        }

        Payment updatedPayment = paymentConverter.convertToPaymentEntity(paymentDto);

        updatedPayment.setPaymentId(paymentId);

        existingPayment = paymentRepository.save(updatedPayment);

        return paymentConverter.convertToPaymentDto(existingPayment);
    }


    @Override //deleting payment by passing paymentId
    public String deletePayment(Long paymentId) {
        Payment payment = paymentRepository.findByPaymentId(paymentId);
        if (payment == null) {
            throw new PaymentNotFoundException("Payment not found with ID: " + paymentId);
        }
        paymentRepository.delete(payment);
        return "Payment with ID " + paymentId + " has been deleted successfully.";
    }

}
