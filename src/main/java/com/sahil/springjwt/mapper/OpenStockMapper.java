package com.sahil.springjwt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import com.sahil.springjwt.dto.OpenStockDto;
import com.sahil.springjwt.models.OpenStock;

@Configuration
@Controller
public class OpenStockMapper {

	
	@Autowired
	Mapper mapper;
	
	public OpenStock toEntity(OpenStockDto openStockDto) {
		return mapper.modelMapper().map(openStockDto, OpenStock.class);
	}
	
	public OpenStockDto toDto(OpenStock openStock) {
		return mapper.modelMapper().map(openStock, OpenStockDto.class);
	}
}
