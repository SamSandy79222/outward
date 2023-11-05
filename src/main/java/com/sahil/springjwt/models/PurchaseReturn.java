 package com.sahil.springjwt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import java.util.Date ;

@Entity
@Table(name="purchaseReturn")
@Getter
@Setter
public class PurchaseReturn {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pRId;
	
	@ManyToOne
	@JoinColumn(name="warehouseId")
	private Warehouse warehouse;
	
	private String supplierCompanyName;
	
	private long invoiceNumber;
	
	@Temporal(TemporalType.DATE)
	private Date Date;
	
	@Temporal(TemporalType.DATE)
	private Date DueDate;
	
	private String Type;
	private String taxType;
	
	@ManyToOne
	@JoinColumn(name="suppliersId")
	private Suppliers suppliers;
	
	private String shippingAddress;
	
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
	private long accountNumber;
	private String bankName;
	private String branch;
	private String IfscCode;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="pRid")
	private List<PurchaseReturnItems> purchaseReturnItems;
}
