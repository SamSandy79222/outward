package com.sahil.springjwt.service;

import java.util.List;
import java.util.Optional;

import com.sahil.springjwt.dto.ProductDto;

public interface ProductService {

	ProductDto createProduct(ProductDto productDto);
	List<ProductDto> getAllProducts();
	Optional<ProductDto> getProduct(long productId);
	public String deleteProduct(long productId);
	public ProductDto updateProduct(Long id,ProductDto productDto);
}
