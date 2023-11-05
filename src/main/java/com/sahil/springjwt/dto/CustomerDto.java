package com.sahil.springjwt.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDto {

	private long customerId;
	private String companyName;
	private String customerName;
	private long phoneNo;
	private String gstNo;
	private String email;
	private String address;
	private String country;
	private String state;
	private String stateCode;
	private String city;
	private long zipCode;
	private String owner;
	private long openingBalance;
	private String openingBalanceType;
	private Date openingBalanceDate;
	private long panNo;
}
