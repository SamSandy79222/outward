package com.sahil.springjwt.models;

import javax.persistence.CascadeType;
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
@Table(name="opentock")
@Setter
@Getter
public class OpenStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stockId;
	
	@ManyToOne
	@JoinColumn(nullable = false,name="Products")
	private Product product;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(nullable = false,name = "Warehouses")
	private Warehouse warehouse;
	
	@Column(name = "Quantity",nullable = false)
	private long quantity;
}
