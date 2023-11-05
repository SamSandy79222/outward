package com.sahil.springjwt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.sahil.springjwt.dto.ProductDto;
import com.sahil.springjwt.models.Product;

@Configuration
@Component
public class ProductMapper {

	@Autowired
	Mapper mapper;
	
	public Product toEntity(ProductDto productDto) {
		return mapper.modelMapper().map(productDto, Product.class);
	}
	
	public ProductDto toDto(Product product) {
		return mapper.modelMapper().map(product, ProductDto.class);
	}
}
