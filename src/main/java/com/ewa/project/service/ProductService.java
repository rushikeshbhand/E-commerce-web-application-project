package com.ewa.project.service;

import com.ewa.project.model.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(Long productId);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long productId, ProductDto productDto);

    String deleteProduct(Long productId);

    List<ProductDto> getAllProducts();
}
