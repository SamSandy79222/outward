package com.sahil.springjwt.service;

import java.util.List;
import java.util.Optional;

import com.sahil.springjwt.dto.BrandDto;
import com.sahil.springjwt.models.Brand;

public interface BrandService {

	public BrandDto createBrand(BrandDto brandDto);
	public List<BrandDto> getAllBrands();
	
	Optional<BrandDto> getBrand(long brandId);
	public String deleteBrand(long brandId);
}
