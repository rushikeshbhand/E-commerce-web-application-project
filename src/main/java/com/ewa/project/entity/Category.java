package com.ewa.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

<<<<<<< HEAD
=======
import lombok.NoArgsConstructor;

@NoArgsConstructor
>>>>>>> origin/main
@Entity
@Table(name = "Category_Details")
public class Category {

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;

	@NotBlank
	@Column(name = "category_name")
	private String categoryName;

	// Relationships
	@OneToMany(mappedBy = "category")
	private List<Product> product;
<<<<<<< HEAD

	// All argument constructor
	public Category(Long categoryId, @NotBlank String categoryName, List<Product> product) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.product = product;
	}

	// No argument constructor
	public Category() {
		super();
	}

	// getter and setter
=======
	
	// getter and setter


>>>>>>> origin/main
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
