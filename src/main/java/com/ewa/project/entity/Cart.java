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

@Entity
@Table(name = "Cart_Details")
public class Cart {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@Column(name = "product_quantity")
	private int quantity;

	@Column(name = "total_price")
	private double totalPrice;

	// Relationships

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id") // This is the foreign key column in the carts table
	private Payment payment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id") // This is the foreign key column in the carts table
	private Customer customer;
	
	//All argument constructor
	public Cart(Long cartId, int quantity, double totalPrice, Order order, Payment payment, Customer customer) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.order = order;
		this.payment = payment;
		this.customer = customer;
	}

	//No argument constructor
	public Cart() {
		super();
	}

	// getter and setter

	public Payment getPayment() {
		return payment;
	}

	

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
