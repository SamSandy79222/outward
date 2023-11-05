package com.sahil.springjwt.models;

import javax.persistence.Column;
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
@Table(name="saleReturnItem")
@Setter
@Getter
public class SaleReturnItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sritemid;
	
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
