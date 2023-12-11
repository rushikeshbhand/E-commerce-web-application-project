package com.ewa.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payment_Details")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long paymentId;

//	@Column(name = "payment_date")
//	private Date paymentDate;

	@Column(name = "payment_amount")
	private double paymentAmount;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "payment_method")
	private String paymentMethod;

	// relationships

	@OneToOne(mappedBy = "payment", cascade= CascadeType.ALL) // payment refers to the field Order entity
	private Order order;
	
	// All argument constructor
	
	public Payment(Long paymentId, double paymentAmount, String paymentStatus, String paymentMethod, Order order) {
		super();
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.order = order;
	}
	
	// No argument constructor
		public Payment() {
			super();
		}

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
}
