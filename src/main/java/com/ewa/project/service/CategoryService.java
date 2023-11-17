package com.ewa.project.service;

import java.util.List;
import com.ewa.project.model.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    
    List<CategoryDto> getAllCategories();
    
    CategoryDto getCategoryById(Long categoryId);
    
    CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);
    
    String deleteCategory(Long categoryId);
}
