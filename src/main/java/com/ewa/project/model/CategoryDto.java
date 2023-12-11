package com.ewa.project.model;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

	private Long categoryId;

	@NotBlank
	private String categoryName;
	
	//getters and setters
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
