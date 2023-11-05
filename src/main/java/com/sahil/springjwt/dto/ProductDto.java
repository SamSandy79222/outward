package com.sahil.springjwt.dto;

import java.util.Date;

import com.sahil.springjwt.models.Brand;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

	
	private long productId;
	private String productName;
	private String partNo;
	private String hsn_sac;
	private String createdBy;
	private Date createdAt;
	private Brand brand;

}
