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

import com.sahil.springjwt.dto.BrandDto;
import com.sahil.springjwt.models.Brand;
import com.sahil.springjwt.repository.BrandRepository;
import com.sahil.springjwt.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	BrandService brandService;
	
	@Autowired 
	BrandRepository brandRepository;
	
	
	@PostMapping
	public ResponseEntity<BrandDto> createBrand(@RequestBody BrandDto brandDto){
		BrandDto brand=brandService.createBrand(brandDto);
		return new ResponseEntity<>(brand,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{brandId}")
	public String deleteBrand(@PathVariable long brandId) {
		return brandService.deleteBrand(brandId);
	}
	
	@GetMapping
	public ResponseEntity<List<BrandDto>> getAllBrands(){
		
		List<BrandDto> brands=brandService.getAllBrands();
		return new ResponseEntity<List<BrandDto>>(brands,HttpStatus.FOUND);
	}
	
	@GetMapping("/{brandId}")
	private Optional<BrandDto> brandlist(@PathVariable long brandId){
		return brandService.getBrand(brandId);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Brand> updateBrand(@PathVariable long id,@RequestBody Brand brand){
		if (brandRepository.findById(id).isPresent()) {
			Brand existbrand=new Brand();
			existbrand.setBrandId(id);
			existbrand.setBrandName(brand.getBrandName());
			existbrand.setCreatedBy(brand.getCreatedBy());
			Brand savedBrand=brandRepository.save(existbrand);
			return new ResponseEntity<>(savedBrand,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

		}
	}
	
	}
	

