package com.ewa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewa.project.model.ProductDto;
import com.ewa.project.service.ProductService;

@RestController // The @RestController annotation indicates that this class is a spring MVC
				// controller responsible for handling HTTP requests and returning data as
				// response
@RequestMapping("/api/products") // The @RequestMapping annotation sets the starting address ("/api/products")
									// for all the operations this controller handle and any operations in this
									// class will be based on this address
public class ProductController {

	@Autowired // automatically inject object of product service
	private ProductService productService;

	// handling create product request
	@PostMapping("/createProduct")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
		ProductDto createdProduct = productService.createProduct(productDto);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	// handling select all product request
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	// handling select product request
	@GetMapping("/{productId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) {
		ProductDto product = productService.getProductById(productId);
		return ResponseEntity.ok(product);
	}

	// handling update product request
	@PutMapping("/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {
		ProductDto updatedProduct = productService.updateProduct(productId, productDto);
		return ResponseEntity.ok(updatedProduct);
	}

	// handling delete product request
	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.noContent().build();
	}

}
