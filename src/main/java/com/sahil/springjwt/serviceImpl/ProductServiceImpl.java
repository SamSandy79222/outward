package com.sahil.springjwt.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.springjwt.dto.ProductDto;
import com.sahil.springjwt.mapper.ProductMapper;
import com.sahil.springjwt.models.Product;
import com.sahil.springjwt.repository.ProductRepository;
import com.sahil.springjwt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public ProductDto createProduct(ProductDto productDto) {
	Product product=productMapper.toEntity(productDto);
	Product product1=productRepository.save(product);
	ProductDto productcreate=productMapper.toDto(product1);
		return productcreate;
	}

	@Override
	public List<ProductDto> getAllProducts() {
List<Product> products=productRepository.findAll();
return products.stream().map(product1 -> modelMapper
		.map(product1, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public Optional<ProductDto> getProduct(long productId) {
		Optional<Product> product=productRepository.findById(productId);
		
		return product.map(product1 ->modelMapper.map(product1, ProductDto.class));
	}

	@Override
	public String deleteProduct(long productId) {
		productRepository.deleteById(productId);
		return "product deleted succesfully";
	}

	@Override
	public ProductDto updateProduct(Long id, ProductDto productDto) {
if (productRepository.existsById(id)) {
	Product productEntity=productMapper.toEntity(productDto);
	productEntity.setProductId(id);
	Product product=productRepository.save(productEntity);
	return productMapper.toDto(product);
}		
return null;
	}
	
	

}
