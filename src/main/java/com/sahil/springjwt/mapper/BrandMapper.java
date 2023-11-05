package com.sahil.springjwt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.sahil.springjwt.dto.BrandDto;
import com.sahil.springjwt.models.Brand;

@Component
@Configuration
public class BrandMapper {

	@Autowired
	Mapper mapper;
	
	public Brand toModel(BrandDto brandDto) {
		return mapper.modelMapper().map(brandDto, Brand.class);
	}
	
	public BrandDto toDto(Brand brand) {
		return mapper.modelMapper().map(brand, BrandDto.class);
	}
}
