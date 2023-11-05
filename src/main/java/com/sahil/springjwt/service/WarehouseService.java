package com.sahil.springjwt.service;

import java.util.List;
import java.util.Optional;

import com.sahil.springjwt.dto.WarehouseDto;

public interface WarehouseService  {

	WarehouseDto createWarehouse(WarehouseDto warehouseDto);
	List<WarehouseDto> allWarehouse();
	Optional<WarehouseDto> getWarehouse(long warehouseId);
	public String deleteWarehouse(Long warehouseId);
    WarehouseDto updateWarehouse(Long id, WarehouseDto warehouseDTO);

}
