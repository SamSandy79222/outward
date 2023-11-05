package com.sahil.springjwt.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name="brand")
@Setter
@Getter
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long brandId;
	
	@Column(name="BrandName")
	private String brandName;
	
	@Column(name="CreatedBy")
	private String createdBy;
	
	
	@OneToMany(mappedBy = "brand",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Product> product;
	
	
}
