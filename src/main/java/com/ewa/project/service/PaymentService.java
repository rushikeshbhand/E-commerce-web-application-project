package com.ewa.project.service;

import java.util.List;

import com.ewa.project.model.PaymentDto;

public interface PaymentService {

    PaymentDto getPaymentById(Long paymentId);
    
    List<PaymentDto> getAllPayments();

    PaymentDto createPayment(PaymentDto paymentDto);

    PaymentDto updatePayment(Long paymentId, PaymentDto paymentDto);

    String deletePayment(Long paymentId);
}
