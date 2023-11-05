package com.sahil.springjwt.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.springjwt.dto.OpenStockDto;
import com.sahil.springjwt.mapper.OpenStockMapper;
import com.sahil.springjwt.models.OpenStock;
import com.sahil.springjwt.repository.OpenStockRepository;
import com.sahil.springjwt.service.OpenStockService;

@Service
public class OpenStockServiceImpl implements OpenStockService{
	@Autowired
	OpenStockRepository openStockRepository;
	@Autowired
	OpenStockMapper openStockMapper;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public OpenStockDto createOpenStock(OpenStockDto openStockDto) {
		OpenStock openStock=openStockMapper.toEntity(openStockDto);
		OpenStock stock=openStockRepository.save(openStock);
		OpenStockDto stock1=openStockMapper.toDto(stock);
		return stock1;
	}

	@Override
	public List<OpenStockDto> getAllOpenStockDto() {
List<OpenStock> stocks=openStockRepository.findAll();
return stocks.stream().map(stock1-> modelMapper.map(stock1, OpenStockDto.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteOpenStock(Long stockId) {
		openStockRepository.deleteById(stockId);
		return "succesfully delete the product";
	}

	@Override
	public Optional<OpenStockDto> getOpenstock(Long stockId) {
		Optional<OpenStock> stock=openStockRepository.findById(stockId);		
		return  stock.map(stock1 ->modelMapper.map(stock1, OpenStockDto.class));
	}

	@Override
	public OpenStockDto updateOpenStockDto(Long stockId, OpenStockDto openStockDto) {

		if (openStockRepository.existsById(stockId)) {
			OpenStock openStockEntity=openStockMapper.toEntity(openStockDto);
			openStockEntity.setStockId(stockId);
			OpenStock openStock=openStockRepository.save(openStockEntity);
			return openStockMapper.toDto(openStock);
		}
		return null;
	}

}
