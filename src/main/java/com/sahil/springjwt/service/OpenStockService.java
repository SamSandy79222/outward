package com.sahil.springjwt.service;

import java.util.List;
import java.util.Optional;

import com.sahil.springjwt.dto.OpenStockDto;

public interface OpenStockService{

	public OpenStockDto createOpenStock(OpenStockDto openStockDto);
	public List<OpenStockDto> getAllOpenStockDto();
	public String deleteOpenStock(Long stockId);
	public Optional<OpenStockDto> getOpenstock(Long stockId);
	public OpenStockDto updateOpenStockDto(Long stockId,OpenStockDto openStockDto);
}
