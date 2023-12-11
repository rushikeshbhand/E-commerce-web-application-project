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

import com.ewa.project.dao.ProductRepository;
import com.ewa.project.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreateProduct() {
        // Create and save a product
        Product product = createSampleProduct();
        product.setProductId(5l);
        product.setProductName("chair");
        product.setProductDescription("It is a wheel chair");
        product.setProductPrice(2000.2);
        product.setProductImage("product.jpg");
        product.setProductSpecification("white color");
        product.setProductBrand("tata");

        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct.getProductId());
    }
    
    @Test
    public void testGetAllProducts() {
        // Clear the database to ensure a clean state
        productRepository.deleteAll();

        // Create and save multiple product entities
        Product product1 = createSampleProduct("Phone", "Smartphone", 500.0, "phone.jpg", "6GB RAM, 128GB Storage", "Samsung");
        Product product2 = createSampleProduct("Camera", "Digital Camera", 300.0, "camera.jpg", "20MP, Full HD", "Canon");
        Product product3 = createSampleProduct("Headphones", "Wireless Headphones", 80.0, "headphones.jpg", "Bluetooth, Noise Cancelling", "Sony");

        productRepository.saveAll(List.of(product1, product2, product3));

        // Retrieve all products from the database
        List<Product> allProducts = productRepository.findAll();

        // Assert that the list is not empty and contains the expected number of products
        assertNotNull(allProducts);
        assertEquals(3, allProducts.size());
    }

    @Test
    public void testGetProductById() {
        // Create and save a product
        Product product = createSampleProduct();
        product = productRepository.save(product);

        // Retrieve the product by ID
        Product retrievedProduct = productRepository.findById(product.getProductId()).orElse(null);

        // Assert that the retrieved product is not null and has the correct ID
        assertNotNull(retrievedProduct);
        assertEquals(product.getProductId(), retrievedProduct.getProductId());
        assertProductEquals(product, retrievedProduct);
    }

    @Test
    public void testUpdateProductById() {
        // Create and save a product
        Product product = createSampleProduct();
        product = productRepository.save(product);

        // Update the product's details
        Long productId = product.getProductId();
        Product updatedProduct = productRepository.findById(productId).orElse(null);
        assertNotNull(updatedProduct);

        // Modify the product's attributes
        updatedProduct.setProductPrice(120.0); // Update product price
        updatedProduct.setProductDescription("Fitness and sleep tracker"); // Update product description
        updatedProduct.setProductImage("updated_smartwatch.jpg"); // Update product image

        // Save the updated product
        updatedProduct = productRepository.save(updatedProduct);

        // Retrieve the updated product from the database
        Product retrievedProduct = productRepository.findById(productId).orElse(null);
        assertNotNull(retrievedProduct);

        // Assert that the attributes have been updated
        assertEquals(120.0, retrievedProduct.getProductPrice());
        assertEquals("Fitness and sleep tracker", retrievedProduct.getProductDescription());
        assertEquals("updated_smartwatch.jpg", retrievedProduct.getProductImage());
    }

    @Test
    public void testDeleteProductById() {
        // Create and save a product
        Product product = createSampleProduct();
        product = productRepository.save(product);

        // Get the ID of the product to be deleted
        Long productId = product.getProductId();

        // Delete the product by ID
        productRepository.deleteById(productId);

        // Try to retrieve the deleted product by ID, and it should be null
        Product deletedProduct = productRepository.findById(productId).orElse(null);
        assertNull(deletedProduct);
    }

    // Helper methods for creating sample products

    private Product createSampleProduct() {
        return createSampleProduct("Laptop", "High-performance laptop", 1200.0, "laptop.jpg", "8GB RAM, 256GB SSD", "Dell");
    }

    private Product createSampleProduct(String name, String description, double price, String image, String specification, String brand) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductDescription(description);
        product.setProductPrice(price);
        product.setProductImage(image);
        product.setProductSpecification(specification);
        product.setProductBrand(brand);
        return product;
    }

    private void assertProductEquals(Product expected, Product actual) {
        assertEquals(expected.getProductName(), actual.getProductName());
        assertEquals(expected.getProductDescription(), actual.getProductDescription());
        assertEquals(expected.getProductPrice(), actual.getProductPrice());
        assertEquals(expected.getProductImage(), actual.getProductImage());
        assertEquals(expected.getProductSpecification(), actual.getProductSpecification());
        assertEquals(expected.getProductBrand(), actual.getProductBrand());
    }
}

