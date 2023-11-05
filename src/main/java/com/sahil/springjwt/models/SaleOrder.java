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
@Table(name="saleOrder")
@Setter
@Getter
public class SaleOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long saleId;
	
	@ManyToOne
	@JoinColumn(name="warehouseId")
	private Warehouse warehouse;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String quotationStatus;
	
	@ManyToMany
	@JoinTable(name="ownerWithSalesOrder")
	private List<User> users;
	
	private String taxType;
//for customer details
	private String companyName;
	private String contactName;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	private String remark;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="soId")
	private List<SaleOrderItems>saleOrderItems;
}
