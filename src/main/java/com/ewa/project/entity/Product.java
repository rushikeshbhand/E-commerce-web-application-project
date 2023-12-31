package com.ewa.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Product_Details")
public class Product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@NotBlank(message="product name should not be blank")
	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_description")
	private String productDescription;

	@NotNull(message="product price should not be null")
	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "product_specification")
	private String productSpecification;

	@Column(name = "product_brand")
	private String productBrand;

	// relationships
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id") // This is the foreign key column in the products table
	private Cart cart;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id") // This is the foreign key column in the products table
	private Category category;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seller_id") // This is the foreign key column in the products table
	private Seller seller;

	// All argument constructor
	public Product(Long productId, @NotBlank(message = "product name should not be blank") String productName,
			String productDescription, @NotNull(message = "product price should not be null") double productPrice,
			String productImage, String productSpecification, String productBrand, Cart cart, Category category,
			Seller seller) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.productSpecification = productSpecification;
		this.productBrand = productBrand;
		this.cart = cart;
		this.category = category;
		this.seller = seller;
	}


	// No argument constructor
	public Product() {
		super();
	}

	// getter and setter

	public Cart getCart() {
		return cart;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Long getProductId() {
		return productId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
