package com.sahil.springjwt.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.springjwt.dto.BrandDto;
import com.sahil.springjwt.mapper.BrandMapper;
import com.sahil.springjwt.models.Brand;
import com.sahil.springjwt.repository.BrandRepository;
import com.sahil.springjwt.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandMapper brandMapper;
	@Autowired
	BrandRepository brandRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public BrandDto createBrand(BrandDto brandDto) {
		Brand brand=brandMapper.toModel(brandDto);
		Brand brand1=brandRepository.save(brand);
		BrandDto brandcreate=brandMapper.toDto(brand1);
		return brandcreate;
	}
	@Override
	public List<BrandDto> getAllBrands() {
//		List<Brand> brands=brandRepository.findAll();
		List<Brand> brands=brandRepository.brandList();
		return brands.stream().map(brandMapper::toDto).collect(Collectors.toList());
	}
	
	@Override
	public Optional<BrandDto> getBrand(long brandId) {
Optional<Brand> brand=brandRepository.findById(brandId);
return brand.map(brand1 ->modelMapper.map(brand1, BrandDto.class));
	}
	
	@Override
	public String deleteBrand(long brandId) {
		brandRepository.deleteById(brandId);
		return "succesfully deleted the brand";
		
	}
	
	
	
	


}
