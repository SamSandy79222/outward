package com.sahil.springjwt.controllers;

import java.util.List;
import java.util.Optional;

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

import com.sahil.springjwt.dto.ProductDto;
import com.sahil.springjwt.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
		ProductDto product=productService.createProduct(productDto);
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable long productId) {
		return productService.deleteProduct(productId);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProduct(){
		List<ProductDto> productList=productService.getAllProducts();
		return new ResponseEntity<List<ProductDto>>(productList,HttpStatus.FOUND);
	}
	
	@GetMapping("/{productId}")
	public Optional<ProductDto> product(@PathVariable long productId){
		return productService.getProduct(productId);
	}
	
	@PutMapping("/{id}")
	public ProductDto updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto) {
	return productService.updateProduct(id, productDto);	
	} 
	
	
}
