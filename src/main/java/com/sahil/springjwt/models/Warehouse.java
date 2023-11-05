package com.sahil.springjwt.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="warehouse")
@Setter
@Getter
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long warehouseId;
	
	@Column(nullable = false)
	private String warehouseName;
	
	@Column(nullable = false)
	private String warehouseLocation;
	
	@CreationTimestamp
	@Column(nullable = false,updatable = false)
	private Date createdAt;
	
	@OneToMany(mappedBy = "warehouse",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<OpenStock> stock;
	
////	 for purchaseorder
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "warehouse")
//	@JsonIgnore
//	private List<PurchaseOrder> purchaseOrders;
//	//for purchase return
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "warehouse")
//	@JsonIgnore
//	private List<PurchaseReturn> purchaseReturns;
//	
//	//for salereturn
//	
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "warehouse")
//	@JsonIgnore
//	private List<SaleReturn> saleReturns;
//	
//	//for dc(delievery challan)
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "warehouse")
//	@JsonIgnore
//	private List<Dc> dcs;
	
}
