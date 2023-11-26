package com.ewa.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

<<<<<<< HEAD
=======
import lombok.NoArgsConstructor;

@NoArgsConstructor
>>>>>>> origin/main
@Entity
@Table(name = "order_details")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@NotBlank
	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "order_quantity")
	private int orderQuantity;

	@Column(name = "order_total_price")
	private double orderTotalPrice;
<<<<<<< HEAD

	// Relationships

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
=======
	
	// Relationships
	
	@OneToOne(mappedBy = "order", cascade= CascadeType.ALL)
>>>>>>> origin/main
	private Cart cart;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "payment_id") // Name of the foreign key column in the order table
	private Payment payment;
<<<<<<< HEAD

	@OneToOne
	@JoinColumn(name = "customer_id") // Name of the foreign key column in the order table
	private Customer customer;

	// All argument constructor

	public Order(Long orderId, @NotBlank String orderStatus, int orderQuantity, double orderTotalPrice, Cart cart,
			Payment payment, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderQuantity = orderQuantity;
		this.orderTotalPrice = orderTotalPrice;
		this.cart = cart;
		this.payment = payment;
		this.customer = customer;
	}
	
	// No argument constructor
	public Order() {
		super();
	}

	// getter and setter

=======
	
	@OneToOne
	@JoinColumn(name = "customer_id") // Name of the foreign key column in the order table
	private Customer customer;
	
>>>>>>> origin/main
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
<<<<<<< HEAD
=======
	
	// getter and setter
>>>>>>> origin/main

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
