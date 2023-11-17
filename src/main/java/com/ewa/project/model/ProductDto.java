package com.ewa.project.model;

import javax.validation.constraints.NotBlank;

import com.ewa.project.entity.Cart;
import com.ewa.project.entity.Seller;

public class ProductDto {

	private Long productId;

	@NotBlank
	private String productName;

	@NotBlank
	private String productDescription;

	@NotBlank
	private double productPrice;

	@NotBlank
	private String productImage;

	@NotBlank
	private String productSpecification;

	@NotBlank
	private String productBrand;

	// Relationships
	private Cart cart;
	private Seller seller;
	
	// getter and setter
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

}
