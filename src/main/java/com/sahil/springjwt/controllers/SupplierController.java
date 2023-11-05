package com.sahil.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.dto.SuppliersDto;
import com.sahil.springjwt.models.Suppliers;
import com.sahil.springjwt.repository.SupplierRepository;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	SupplierRepository supplierRepository;
	
	@PostMapping
	public ResponseEntity<SuppliersDto> createSupplier(@RequestBody SuppliersDto suppliersDto){
		Suppliers suppliers=new Suppliers();
		suppliers.setCompanyname(suppliersDto.getCompanyname());
		suppliers.setSupplierName(suppliersDto.getSupplierName());
		suppliers.setPhoneNo(suppliersDto.getPhoneNo());
		suppliers.setGstNo(suppliersDto.getGstNo());
		suppliers.setEmail(suppliersDto.getEmail());
		suppliers.setAddress(suppliersDto.getAddress());
		suppliers.setCountry(suppliersDto.getCountry());
		suppliers.setState(suppliersDto.getState());
		suppliers.setStateCode(suppliersDto.getStateCode());
		suppliers.setCity(suppliersDto.getCity());
		suppliers.setZipCode(suppliersDto.getZipCode());
		suppliers.setPanNo(suppliersDto.getPanNo());
		suppliers.setAccountNumber(suppliersDto.getAccountNumber());
		suppliers.setBankName(suppliersDto.getBankName());
		suppliers.setBranch(suppliersDto.getBranch());
		suppliers.setIfsc(suppliersDto.getIfsc());
		suppliers.setOpeningBalance(suppliersDto.getOpeningBalance());
		suppliers.setOpeningBalanceType(suppliersDto.getOpeningBalanceType());
		suppliers.setOpeningBalanceDate(suppliersDto.getOpeningBalanceDate());
		
		supplierRepository.save(suppliers);
		return new ResponseEntity<SuppliersDto>(suppliersDto,HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Suppliers> updateSupplier(@PathVariable long id, @RequestBody Suppliers suppliers){
		if (supplierRepository.findById(id).isPresent()) {
			Suppliers existsuppliers=new Suppliers();
			
			existsuppliers.setSupplierId(id);
			existsuppliers.setCompanyname(suppliers.getCompanyname());
			existsuppliers.setSupplierName(suppliers.getSupplierName());
			existsuppliers.setPhoneNo(suppliers.getPhoneNo());
			existsuppliers.setGstNo(suppliers.getGstNo());
			existsuppliers.setEmail(suppliers.getEmail());
			existsuppliers.setAddress(suppliers.getAddress());
			existsuppliers.setCountry(suppliers.getCountry());
			existsuppliers.setState(suppliers.getState());
			existsuppliers.setStateCode(suppliers.getStateCode());
			existsuppliers.setCity(suppliers.getCity());
			existsuppliers.setZipCode(suppliers.getZipCode());
			existsuppliers.setPanNo(suppliers.getPanNo());
			existsuppliers.setAccountNumber(suppliers.getAccountNumber());
			existsuppliers.setBankName(suppliers.getBankName());
			existsuppliers.setBranch(suppliers.getBranch());
			existsuppliers.setIfsc(suppliers.getIfsc());
			existsuppliers.setOpeningBalance(suppliers.getOpeningBalance());
			existsuppliers.setOpeningBalanceType(suppliers.getOpeningBalanceType());
			existsuppliers.setOpeningBalanceDate(suppliers.getOpeningBalanceDate());
			supplierRepository.save(existsuppliers);
			return new ResponseEntity<Suppliers>(existsuppliers,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Suppliers>(HttpStatus.NOT_FOUND);

		}
				
	}
	
	@GetMapping
	public ResponseEntity<List<Suppliers>> supplierList(){
		List<Suppliers> suppliers=supplierRepository.findAll();
		return new ResponseEntity<List<Suppliers>>(suppliers,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public Optional<Suppliers> getSupplier(@PathVariable long id){
		if (supplierRepository.findById(id).isPresent()) {
			Optional<Suppliers> getSupplierInfo=supplierRepository.findById(id);
			return getSupplierInfo;
		}
		else {
			return null;
		}
	}
	
	@DeleteMapping("/{id}")
	public String deleteSupplier(@PathVariable long id) {
		if (supplierRepository.findById(id).isPresent()) {
			supplierRepository.deleteById(id);
			return "succsfully delete the supplier with id"+id;
		}
		else {
			return "supplier with id "+id+" dont exist";
		}
	}
	
	
	
	
}
