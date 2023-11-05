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

import com.sahil.springjwt.dto.OpenStockDto;
import com.sahil.springjwt.service.OpenStockService;

@RestController
@RequestMapping("/openstock")
public class OpenStockController {

	@Autowired
	OpenStockService openStockService;
	
	@PostMapping
	public ResponseEntity<OpenStockDto> createOpenStock(@RequestBody OpenStockDto openStockDto){
		OpenStockDto stock=openStockService.createOpenStock(openStockDto);
		return new ResponseEntity<OpenStockDto>(stock, HttpStatus.CREATED); 
	}
	
	@GetMapping
	public ResponseEntity<List<OpenStockDto>> getAllProductDto(){
		return new ResponseEntity<List<OpenStockDto>>(openStockService.getAllOpenStockDto(),HttpStatus.FOUND);
	}
	
	@GetMapping("/{stockId}")
	public Optional<OpenStockDto> getOpenStock(@PathVariable long stockId){
		return openStockService.getOpenstock(stockId);
	}
	
	@PutMapping("/{stockId}")
	public OpenStockDto updateOpenStockDto(@PathVariable long stockId,@RequestBody OpenStockDto openStockDto) {
		return openStockService.updateOpenStockDto(stockId, openStockDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStock(@PathVariable long id) {
	return	openStockService.deleteOpenStock(id);
		
	}
}
