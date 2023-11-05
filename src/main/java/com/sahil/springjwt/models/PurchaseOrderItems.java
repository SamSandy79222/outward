package com.sahil.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="purchaseOrderItems")
@Setter
@Getter
public class PurchaseOrderItems {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pOItemid;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	private long rate;
	private long qty;
	private long per;
	private long discount;
	private long total;
	private long gstValue;
	private long amount;
	
	
	
}
