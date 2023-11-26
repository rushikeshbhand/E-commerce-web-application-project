package com.ewa.project.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ewa.project.entity.Product;
import com.ewa.project.model.ProductDto;

@Component // Indicates that this class is a Spring component
public class ProductConverter {

	// Convert from Entity to dto
	public ProductDto convertToProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		if (product != null) {
			BeanUtils.copyProperties(product, productDto);
		}
		return productDto;
	}

	// Convert from dto to Entity
	public Product convertToProductEntity(ProductDto productDto) {
		Product product = new Product();
		if (productDto != null) {
			BeanUtils.copyProperties(productDto, product);
		}
		return product;
	}

	public List<ProductDto> convertToProductDto(List<Product> products) {
		List<ProductDto> productDtos = new ArrayList<>();
		for (Product product : products) {
			ProductDto productDto = convertToProductDto(product);
			productDtos.add(productDto);
		}
		return productDtos;
	}
}
