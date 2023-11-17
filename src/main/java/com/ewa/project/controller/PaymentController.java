package com.ewa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewa.project.model.PaymentDto;
import com.ewa.project.service.PaymentService;

@RestController // The @RestController annotation indicates that this class is a spring MVC
				// controller responsible for handling HTTP requests and returning data as
				// response
@RequestMapping("/api/payments") // The @RequestMapping annotation sets the starting address ("/api/payments")
									// for all the operations this controller handle and any operations in this
									// class will be based on this address
public class PaymentController {

	@Autowired // automatically inject object of payment service
	private PaymentService paymentService;

	// handling create payment request
	@PostMapping("/createPayment")
	public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto) {
		PaymentDto createdPayment = paymentService.createPayment(paymentDto);
		return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
	}

	// handling select all payment request
	@GetMapping("/getAllPayments")
	public ResponseEntity<List<PaymentDto>> getAllPayments() {
		List<PaymentDto> payments = paymentService.getAllPayments();
		return ResponseEntity.ok(payments);
	}

	// handling select payment request
	@GetMapping("/{paymentId}")
	public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Long paymentId) {
		PaymentDto payment = paymentService.getPaymentById(paymentId);
		return ResponseEntity.ok(payment);
	}

	@PutMapping("/{paymentId}")
	public ResponseEntity<PaymentDto> updatePayment(@PathVariable Long paymentId, @RequestBody PaymentDto paymentDto) {
		PaymentDto updatedPayment = paymentService.updatePayment(paymentId, paymentDto);
		return ResponseEntity.ok(updatedPayment);
	}

	@DeleteMapping("/{paymentId}")
	public String deletePayment(@PathVariable Long paymentId) {
		return paymentService.deletePayment(paymentId);
	}

}
