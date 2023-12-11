package com.ewa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewa.project.model.CategoryDto;
import com.ewa.project.service.CategoryService;

@RestController // The @RestController annotation indicates that this class is a spring MVC
				// controller responsible for handling HTTP requests and returning data as
				// response
@RequestMapping("/api/categories") // The @RequestMapping annotation sets the starting address ("/api/categories")
									// for all the operations this controller handle and any operations in this
@CrossOrigin("http://localhost:4200")					// class will be based on this address
public class CategoryController {

	@Autowired // Automatically inject an instance of CategoryService
	private CategoryService categoryService;

	// handling creating category request
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto createdCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}

	// handling selecting all categories request
	@GetMapping("/getAllCategories")
	public List<CategoryDto> getAllCategories() {
		return categoryService.getAllCategories();
	}

	// handling selecting category request
	@GetMapping("/{categoryId}")
	public CategoryDto getCategoryById(@PathVariable Long categoryId) {
		return categoryService.getCategoryById(categoryId);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto) {
	    CategoryDto updatedCategory = categoryService.updateCategory(categoryId, categoryDto);
	    if (updatedCategory != null) {
	        return ResponseEntity.ok(updatedCategory);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

//	// handling updating category request
//	@PutMapping("/{categoryId}")
//	public CategoryDto updateCategory(@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto) {
//		return categoryService.updateCategory(categoryId, categoryDto);
//	}

	// handling deleting category request
	@DeleteMapping("/{categoryId}")
	public String deleteCategory(@PathVariable Long categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
}
