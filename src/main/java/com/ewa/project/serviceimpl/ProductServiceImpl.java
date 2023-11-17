package com.ewa.project.serviceimpl;

import com.ewa.project.converter.ProductConverter;
import com.ewa.project.dao.ProductRepository;
import com.ewa.project.model.ProductDto;
import com.ewa.project.service.ProductService;
import com.ewa.project.exception.ProductNotFoundException;
import com.ewa.project.entity.Product;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired //Autowired is used to inject object automatically
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;

	@Override //selecting product by passing his id as input 
	public ProductDto getProductById(Long productId) {
		Product product = productRepository.findByProductId(productId);
		if (product == null) {
			// handle the product not found exception
			throw new ProductNotFoundException("Product not found with productId: " + productId);
		}
		return productConverter.convertToProductDto(product);
	}

	@Override //creating product and returning product dto 
	public ProductDto createProduct(ProductDto productDto) {
		Product product = productConverter.convertToProductEntity(productDto);
		product = productRepository.save(product);
		return productConverter.convertToProductDto(product);
	}

	@Override //updating the product
	public ProductDto updateProduct(Long productId, ProductDto productDto) {
		Product existingProduct = productRepository.findByProductId(productId);
		if (existingProduct == null) {
			// handle the product not found exception
			throw new ProductNotFoundException("Product not found with productId: " + productId);
		}

		// update product fields from productDto
		BeanUtils.copyProperties(productDto, existingProduct);

		Product updatedProduct = productRepository.save(existingProduct);
		return productConverter.convertToProductDto(updatedProduct);
	}

	@Override //deleting the product
	public String deleteProduct(Long productId) {
		Product product = productRepository.findByProductId(productId);
		if (product == null) {
			// handle the product not found exception
			throw new ProductNotFoundException("Product not found with productId: " + productId);
		}
		productRepository.delete(product);
		return "Product with ID"  + productId + "has been deleted successfully.";
	}

	@Override //selecting all products
	public List<ProductDto> getAllProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDto> productDtos = productConverter.convertToProductDto(products);
		return productDtos;
	}

}
