package com.sahil.springjwt.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="quotationItem")
@Setter
@Getter
public class QuotatioItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long quotationItemId;
	private long quantity;
	private long rate;
	private long mrp;
	private long discount;
	private long igst;
	private long cgst;
	private long sgst;

	private long netValue;
	private long taxValue;
	private long grossValue;

	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "productId")
	private Product product;

	
	
}
