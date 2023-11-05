package com.sahil.springjwt.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.springjwt.dto.WarehouseDto;
import com.sahil.springjwt.mapper.WarehouseMapper;
import com.sahil.springjwt.models.Warehouse;
import com.sahil.springjwt.repository.WarehouseRepository;
import com.sahil.springjwt.service.WarehouseService;
@Service
public class WarehouseServiceImpl implements WarehouseService{
	
	@Autowired
	WarehouseMapper warehouseMapper;
	
	@Autowired
	WarehouseRepository warehouseRepository;
	
	@Autowired
	ModelMapper modelMapper;
	@Override
	public WarehouseDto createWarehouse(WarehouseDto warehouseDto) {
		Warehouse warehouse=warehouseMapper.toEntity(warehouseDto);
		warehouseRepository.save(warehouse);
		WarehouseDto warehouseDto2=warehouseMapper.toDto(warehouse);
		return warehouseDto2;
	}

	@Override
	public List<WarehouseDto> allWarehouse() {
		List<Warehouse> warehouses=warehouseRepository.findAll();
		return warehouses.stream().map(warehouse->modelMapper
				.map(warehouse, WarehouseDto.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteWarehouse(Long warehouseId) {
warehouseRepository.deleteById(warehouseId);	
return "warehouse deleted succesfully";
	}

	@Override
	public Optional<WarehouseDto> getWarehouse(long warehouseId) {
		Optional<Warehouse> warehouse=warehouseRepository.findById(warehouseId);

return warehouse.map(warehouseList->modelMapper.map(warehouseList, WarehouseDto.class));
	}

	@Override
	public WarehouseDto updateWarehouse(Long id, WarehouseDto warehouseDTO) {
if (warehouseRepository.existsById(id)) {
	Warehouse warehouse=warehouseMapper.toEntity(warehouseDTO);
	warehouse.setWarehouseId(id);
	Warehouse warehouse2=warehouseRepository.save(warehouse);
	return warehouseMapper.toDto(warehouse2);
}
return null;
	}
	

}
