package com.ewa.project.converter;

import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

import com.ewa.project.entity.Category;
import com.ewa.project.model.CategoryDto;

@Component // Indicates that this class is a Spring component
public class CategoryConverter {

    // Convert from Entity to dto
    public CategoryDto entityToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category, categoryDto);
        return categoryDto;
    }

    // Convert from dto to Entity
    public Category dtoToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return category;
    }
}
