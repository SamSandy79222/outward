package com.sahil.springjwt.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product")
@Setter
@Getter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	
	@Column(name="ProductName",unique = true)
	private String productName;
	
	@Column(name="PartNo")
	private String partNo;
	
	@Column(name="HSNSac")
	private String hsn_sac;
	
	@Column(name="CreatedBy")
	private String createdBy;
	
	@CreationTimestamp
	@Column(nullable = false,updatable = false)
	private Date createdAt;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	private Brand brand;
	
//	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
	@OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<OpenStock> stock;
	
	//for purchaseOrder
	
//	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "product")
//	private List<PurchaseOrder> purchaseOrders;
	
	
}
