package com.sahil.springjwt.dto;


import com.sahil.springjwt.models.Product;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BrandDto {
	
	private long brandId;
	private String brandName;
	private String createdBy;
	private Product product;

}
