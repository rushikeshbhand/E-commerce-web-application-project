package com.ewa.project.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ewa.project.entity.Order;

public class PaymentDto {

	private Long paymentId;

//	private Date paymentDate;

	@NotNull
	private double paymentAmount;

	@NotBlank
	private String paymentStatus;

	@NotBlank
	private String paymentMethod;

	// Relationships
	private Order order;	
	// getter and setter
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

//	public Date getPaymentDate() {
//		return paymentDate;
//	}
//
//	public void setPaymentDate(Date paymentDate) {
//		this.paymentDate = paymentDate;
//	}

}
