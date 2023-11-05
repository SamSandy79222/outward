package com.sahil.springjwt.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SuppliersDto {
	
	private long supplierId;
	private String companyname;
	private String supplierName;
	private long phoneNo;
	private String gstNo;
	private String email;
	private String address;
	private String country;
	private String state;
	private String stateCode;
	private String city;
	private long zipCode;
	private long panNo;
	private long accountNumber;
	private String bankName;
	private String branch;
	private String ifsc;
	private long openingBalance;
	private String openingBalanceType;
	private Date openingBalanceDate;
}
