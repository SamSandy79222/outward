package com.sahil.springjwt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="LeadTable")
@Setter
@Getter
public class Leads {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leadsId;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
//	@CreationTimestamp
//	@Column(updatable = true)
	
	@Temporal(TemporalType.DATE)
	private Date leadDate;
	
	private String leadTitle;
	private String leadDescription;
	private String leadStatus;
	private long leadValue;
	private String leadSource;
	
	@ManyToMany
	@JoinTable(name="ownerWithLeadsId")
	private List<User> user;
}
