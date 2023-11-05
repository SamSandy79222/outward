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

import com.sahil.springjwt.dto.WarehouseDto;
import com.sahil.springjwt.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	WarehouseService warehouseService;
	
	@PostMapping
	public ResponseEntity<WarehouseDto> createWarehouse(@RequestBody WarehouseDto warehouseDto){
		WarehouseDto war=warehouseService.createWarehouse(warehouseDto);
		return new ResponseEntity<WarehouseDto>(war,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<WarehouseDto>> getAllWarehouses(){
		List<WarehouseDto> warehouses=warehouseService.allWarehouse();
		return new ResponseEntity<List<WarehouseDto>>(warehouses,HttpStatus.FOUND);
	}
	@GetMapping("/{warehouseId}")
	public Optional<WarehouseDto> getWarehouse(@PathVariable long warehouseId){
		return warehouseService.getWarehouse(warehouseId);
	}
	
	@DeleteMapping("/{warehouseId}")
	public String deleteWarehouse(@PathVariable long warehouseId) {
		return warehouseService.deleteWarehouse(warehouseId);
	}
	
	@PutMapping("/{id}")
	public WarehouseDto updateWarehouse(@PathVariable Long id,@RequestBody WarehouseDto dto) {
		return warehouseService.updateWarehouse(id, dto);
	}
}
