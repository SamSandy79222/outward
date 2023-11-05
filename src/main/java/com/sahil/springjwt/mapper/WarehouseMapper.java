package com.sahil.springjwt.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.sahil.springjwt.dto.WarehouseDto;
import com.sahil.springjwt.models.Warehouse;


@Component
@Configuration
public class WarehouseMapper {

	@Autowired
	Mapper mapper;
	
	public WarehouseDto toDto(Warehouse warehouse) {
		return mapper.modelMapper().map(warehouse, WarehouseDto.class);
	}
	
	public Warehouse toEntity(WarehouseDto warehouseDto) {
		return mapper.modelMapper().map(warehouseDto, Warehouse.class);
	}
}
