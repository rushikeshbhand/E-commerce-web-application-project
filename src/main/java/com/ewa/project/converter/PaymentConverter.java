package com.ewa.project.converter;

import com.ewa.project.entity.Payment;
import com.ewa.project.model.PaymentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component // Indicates that this class is a Spring component
public class PaymentConverter {

    // Convert from dto to Entity
    public Payment convertToPaymentEntity(PaymentDto paymentDto) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDto, payment);
        return payment;
    }

    // Convert from Entity to dto
    public PaymentDto convertToPaymentDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        BeanUtils.copyProperties(payment, paymentDto);
        return paymentDto;
    }
}
