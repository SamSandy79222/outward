package com.sahil.springjwt.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sahil.springjwt.models.Customer;
import com.sahil.springjwt.models.QuotatioItem;
import com.sahil.springjwt.models.User;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class QuotationDto {

	
	private long quotationId;
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

	
	
	private Customer customer;
	
	
	private List<User> user;
	

	private List<QuotatioItem> quotatioItems;
}
