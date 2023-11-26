package com.ewa.project.repotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ewa.project.dao.CategoryRepository;
import com.ewa.project.entity.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateCategory() {
        // Create and save a category
        Category category = new Category();
        category.setCategoryName("Electronics");

        Category savedCategory = categoryRepository.save(category);
        assertNotNull(savedCategory.getCategoryId());
    }

    @Test
    public void testGetAllCategories() {
        // Clear the database to ensure a clean state
        categoryRepository.deleteAll();

        // Create and save multiple category entities
        Category category1 = new Category(null, "Clothing", null);
        Category category2 = new Category(null, "Books", null);
        Category category3 = new Category(null, "Home Decor", null);

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        // Retrieve all categories from the database
        List<Category> allCategories = categoryRepository.findAll();

        // Assert that the list is not empty and contains the expected number of categories
        assertNotNull(allCategories);
        assertEquals(3, allCategories.size());
    }

    @Test
    public void testGetCategoryById() {
        // Create and save a category
        Category category = new Category(null, "Sports", null);
        category = categoryRepository.save(category);

        // Retrieve the category by ID
        Category retrievedCategory = categoryRepository.findById(category.getCategoryId()).orElse(null);

        // Assert that the retrieved category is not null and has the correct ID
        assertNotNull(retrievedCategory);
        assertEquals(category.getCategoryId(), retrievedCategory.getCategoryId());
        assertEquals("Sports", retrievedCategory.getCategoryName());
    }

    @Test
    public void testUpdateCategoryById() {
        // Create and save a category
        Category category = new Category(null, "Toys", null);
        category = categoryRepository.save(category);

        // Update the category's details
        Long categoryId = category.getCategoryId();
        Category updatedCategory = categoryRepository.findById(categoryId).orElse(null);
        assertNotNull(updatedCategory);

        // Modify the category's attributes
        updatedCategory.setCategoryName("Outdoor Toys"); // Update category name

        // Save the updated category
        updatedCategory = categoryRepository.save(updatedCategory);

        // Retrieve the updated category from the database
        Category retrievedCategory = categoryRepository.findById(categoryId).orElse(null);
        assertNotNull(retrievedCategory);

        // Assert that the attributes have been updated
        assertEquals("Outdoor Toys", retrievedCategory.getCategoryName());
    }

    @Test
    public void testDeleteCategoryById() {
        // Create and save a category
        Category category = new Category(null, "Furniture", null);
        category = categoryRepository.save(category);

        // Get the ID of the category to be deleted
        Long categoryId = category.getCategoryId();

        // Delete the category by ID
        categoryRepository.deleteById(categoryId);

        // Try to retrieve the deleted category by ID, and it should be null
        Category deletedCategory = categoryRepository.findById(categoryId).orElse(null);
        assertNull(deletedCategory);
    }
}
