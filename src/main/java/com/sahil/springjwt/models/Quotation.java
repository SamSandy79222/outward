package com.sahil.springjwt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="quotation")
@Setter
@Getter
public class Quotation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long quotationId;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String Status;
	
	
	private String taxType;
	private String quotationSubject;
	private String paymentTerm;
	private String deliveryTerm;
	private String quotationValidity;
	private String employeeName;
	private String referencedBy;
	
	private String remark;
	
	private long warranty;
	
	
	

	
	@ManyToOne
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name="ownerWithQuotation")
//	@JsonIgnore

	private List<User> user;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="quotationId")
//	@JsonIgnore
	private List<QuotatioItem> quotatioItems;
	
	
}
