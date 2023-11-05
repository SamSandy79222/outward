package com.sahil.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name="warehousereport")
@Setter
@Getter
public class ReportSaved {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String partNo;
    private Long quantity;
    private Long inward;
    private Long outward;
    private Long closingStock;
}
