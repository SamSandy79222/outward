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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="suppliers")
@Setter
@Getter
public class Suppliers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@Temporal(TemporalType.DATE)
	private Date openingBalanceDate;
	
	
//	//for purchaseOrder
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "suppliers")
//	@JsonIgnore
//	private List<PurchaseOrder> purchaseOrders;
}
