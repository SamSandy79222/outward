package com.sahil.springjwt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="dc")
@Setter
@Getter

public class Dc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dcid;
	
	
	
	@ManyToOne
	@JoinColumn(name="warehouseId")
	private Warehouse warehouse;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	private String contactName;
//	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	private String type;
//
	@ManyToMany
	@JoinTable(name="ownerWithDc")
	private List<User> users;
	
	private String status;
	private String delieverydate;
	private String installationdate;
	private String taxtype;
	private String remark;
	private String shippingaddress;
	private String installationaddress;
	
	private long poNo;
	
	@Temporal(TemporalType.DATE)
	private Date poDate;
	
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	private String delieveryNote;
	
	private String supplierReference;
	private String buyerOrder;
	private long dispatchDocumentNo;
	private String dispatchThrough;
	private long ewayBillNo;
	private String vehicleNo;
	private String placeOfSupply;
	private String paymentTerm;
	
	private long partNo;
//	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="dChallanId")
	private List<Dcitems> dcitems;
	
}
