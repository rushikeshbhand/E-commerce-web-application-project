package com.ewa.project.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ewa.project.entity.Product;

public class CategoryDto {

	private Long categoryId;

	@NotBlank
	private String categoryName;
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	private List<Product> product;


	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
