package com.sahil.springjwt.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.models.Purchase;
import com.sahil.springjwt.models.SaleOrder;
import com.sahil.springjwt.repository.SaleOrderRepository;

@RestController
@RequestMapping("/saleorder")
public class SaleOrderController {

	@Autowired
	SaleOrderRepository saleOrderRepository;
	
	@PostMapping
	private ResponseEntity<SaleOrder> createSaleOrder(@RequestBody SaleOrder saleOrder){
		SaleOrder saleOrder2=saleOrderRepository.save(saleOrder);
		return new ResponseEntity<>(saleOrder2,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SaleOrder> updateSaleOrder(@PathVariable long id,@RequestBody SaleOrder saleOrder){
		
		if (saleOrderRepository.findById(id).isPresent()) {
			
			SaleOrder existSaleOrder=new SaleOrder();
			existSaleOrder.setSaleId(id);
			existSaleOrder.setWarehouse(saleOrder.getWarehouse());
			existSaleOrder.setDate(saleOrder.getDate());
			existSaleOrder.setQuotationStatus(saleOrder.getQuotationStatus());
			existSaleOrder.setUsers(saleOrder.getUsers());
			existSaleOrder.setTaxType(saleOrder.getTaxType());
			existSaleOrder.setCompanyName(saleOrder.getCompanyName());
			existSaleOrder.setContactName(saleOrder.getContactName());
			
			existSaleOrder.setCustomer(saleOrder.getCustomer());
			existSaleOrder.setRemark(saleOrder.getRemark());
			existSaleOrder.setSaleOrderItems(saleOrder.getSaleOrderItems());
			SaleOrder savedSales=saleOrderRepository.save(existSaleOrder);
			return new ResponseEntity<SaleOrder>(savedSales,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<SaleOrder>(HttpStatus.NOT_FOUND);

		}
	}
	
	@GetMapping
	public ResponseEntity<List<SaleOrder>> getAllSaleOrder(){
		List<SaleOrder> allSaleOrders=saleOrderRepository.findAll();
		return new ResponseEntity<List<SaleOrder>>(allSaleOrders,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public Optional<SaleOrder> getSaleById(@PathVariable long id){
		Optional<SaleOrder> saleOrder=saleOrderRepository.findById(id);
		return saleOrder;
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Set<SaleOrder>> getPurchaseById(@PathVariable long id){
		
		Set<SaleOrder> sales=saleOrderRepository.findByUsersId(id);
		return new ResponseEntity<Set<SaleOrder>>(sales,HttpStatus.FOUND);
	}
	
	
	
}
