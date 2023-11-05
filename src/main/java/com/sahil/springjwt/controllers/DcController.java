package com.sahil.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.models.Dc;
import com.sahil.springjwt.repository.DcRepository;

import lombok.Getter;

@RestController
@RequestMapping("/delieverchallan")
public class DcController {

	
	@Autowired
	DcRepository dcRepository;
	
	@PostMapping
	public ResponseEntity<Dc> createDc(@RequestBody Dc dc){
		Dc dc2=dcRepository.save(dc);
		return new ResponseEntity<Dc>(dc2,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dc> updateDc(@PathVariable long id,@RequestBody Dc dc){
		
		if (dcRepository.findById(id).isPresent()) {
			
			Dc existDc=new Dc();
			existDc.setDcid(id);
			existDc.setWarehouse(dc.getWarehouse());
			
			existDc.setCustomer(dc.getCustomer());
			existDc.setContactName(dc.getContactName());
			existDc.setDate(dc.getDate());
			existDc.setDueDate(dc.getDueDate());
			existDc.setType(dc.getType());
			existDc.setUsers(dc.getUsers());
			existDc.setStatus(dc.getStatus());
			existDc.setDelieverydate(dc.getDelieverydate());
			existDc.setInstallationdate(dc.getInstallationdate());
			existDc.setTaxtype(dc.getTaxtype());
			existDc.setRemark(dc.getRemark());
			existDc.setShippingaddress(dc.getShippingaddress());
			existDc.setInstallationaddress(dc.getInstallationaddress());
			existDc.setPoNo(dc.getPoNo());
			existDc.setPoDate(dc.getPoDate());
			existDc.setDeliveryDate(dc.getDeliveryDate());
			existDc.setDelieveryNote(dc.getDelieveryNote());
			existDc.setSupplierReference(dc.getSupplierReference());
			existDc.setBuyerOrder(dc.getBuyerOrder());
			
			existDc.setDispatchDocumentNo(dc.getDispatchDocumentNo());
			existDc.setDispatchThrough(dc.getDispatchThrough());
			existDc.setEwayBillNo(dc.getEwayBillNo());
			existDc.setVehicleNo(dc.getVehicleNo());
			existDc.setPlaceOfSupply(dc.getPlaceOfSupply());
			existDc.setPaymentTerm(dc.getPaymentTerm());
			existDc.setPartNo(dc.getPartNo());
			existDc.setDcitems(dc.getDcitems());
			
			Dc savedDc=dcRepository.save(existDc);
			return new ResponseEntity<Dc>(savedDc,HttpStatus.ACCEPTED);
			}
		else {
			return new ResponseEntity<Dc>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Dc>> getAllDc(){
		List<Dc> dcs=dcRepository.findAll();
		return new ResponseEntity<List<Dc>>(dcs,HttpStatus.FOUND);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Dc>> getById(@PathVariable long id){
		List<Dc> dcs=dcRepository.findByUsersId(id);
		return new ResponseEntity<List<Dc>>(dcs,HttpStatus.FOUND);
	}
	
}
