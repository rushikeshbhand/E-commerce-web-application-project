package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Category;
@Repository // Indicates that this interface is a Spring Data repository
public interface CategoryRepository extends JpaRepository<Category, Long> {// It provides methods for common CRUD operations

	Category findByCategoryId(Long categoryId);
	
}


