package com.sahil.springjwt.dto;

import com.sahil.springjwt.models.Product;
import com.sahil.springjwt.models.Warehouse;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OpenStockDto {
	private long stockId;
	private Product product;
	private Warehouse warehouse;
	private long quantity;

}
