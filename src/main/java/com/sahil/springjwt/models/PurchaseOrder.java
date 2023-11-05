package com.sahil.springjwt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="purchaseOrder")
@Getter
@Setter
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long purchaseId;
	
	@ManyToOne
	@JoinColumn(name="warehouseId")
	private Warehouse warehouse;
	
	@ManyToOne
	@JoinColumn(name="suppliersId")
	private Suppliers suppliers;
	
	private String contactName;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfPurchase;
	
	private String type;
	private String status;
	private String billingAddress;
	private String shippingAddress;
	private String remarks;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="POid")
	private List<PurchaseOrderItems> purchaseOrderItems;
	
	@ManyToMany
	@JoinTable(name="OwnerWithPo")
	private List<User> users;
	
	
}
