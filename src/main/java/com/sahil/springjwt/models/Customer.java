package com.sahil.springjwt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Temporal(TemporalType.DATE)
	private Date openingBalanceDate;
	
	private long panNo;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "customer")
	@JsonIgnore
	private List<Quotation> quotation;
	
	
//	//-------------------------enquiry
//	@OneToMany(mappedBy = "customer",cascade =CascadeType.REMOVE)
//	@JsonIgnore
//	 private List<Enquiry> enquiries;
//	//-------------------------lead
//	
//	@OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
//	@JsonIgnore
//	private List<Leads> leads; 
//	
//	//salereturn 
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "customer")
//	@JsonIgnore
//	private List<SaleReturn> saleReturns;

}
