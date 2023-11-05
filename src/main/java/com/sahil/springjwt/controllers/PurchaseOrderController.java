package com.sahil.springjwt.controllers;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.server.header.CrossOriginResourcePolicyServerHttpHeadersWriter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.models.PurchaseOrder;
import com.sahil.springjwt.repository.PurchaseOrderRepository;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@PostMapping
	public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
		
		PurchaseOrder purchaseOrder2=purchaseOrderRepository.save(purchaseOrder);
		return new ResponseEntity<>(purchaseOrder2,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable long id,@RequestBody PurchaseOrder purchaseOrder){
		
		if (purchaseOrderRepository.findById(id).isPresent()) {
			PurchaseOrder existPurchaseOrder=new PurchaseOrder();
			
			existPurchaseOrder.setPurchaseId(id);
			existPurchaseOrder.setWarehouse(purchaseOrder.getWarehouse());
			existPurchaseOrder.setSuppliers(purchaseOrder.getSuppliers());
			existPurchaseOrder.setContactName(purchaseOrder.getContactName());
			existPurchaseOrder.setDateOfPurchase(purchaseOrder.getDateOfPurchase());
			existPurchaseOrder.setType(purchaseOrder.getType());
			existPurchaseOrder.setStatus(purchaseOrder.getStatus());
			existPurchaseOrder.setBillingAddress(purchaseOrder.getBillingAddress());
			existPurchaseOrder.setShippingAddress(purchaseOrder.getShippingAddress());
			existPurchaseOrder.setRemarks(purchaseOrder.getRemarks());
			existPurchaseOrder.setPurchaseOrderItems(purchaseOrder.getPurchaseOrderItems());
			existPurchaseOrder.setUsers(purchaseOrder.getUsers());
			PurchaseOrder savePurchaseorder=purchaseOrderRepository.save(existPurchaseOrder);
			return new ResponseEntity<PurchaseOrder>(savePurchaseorder,HttpStatus.ACCEPTED);
			
		}
		else {
			return new ResponseEntity<PurchaseOrder>(HttpStatus.NOT_ACCEPTABLE);

		}
	}
	
	@GetMapping
	public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrder(){
		
		List<PurchaseOrder> purchaseOrders=purchaseOrderRepository.findAll();
		return new ResponseEntity<List<PurchaseOrder>>(purchaseOrders,HttpStatus.FOUND);
		
		
	}
	
	@GetMapping("/{id}")
	public Optional<PurchaseOrder> getPurchaseOrderById(@PathVariable long id){
		Optional<PurchaseOrder> purchaseOrder=purchaseOrderRepository.findById(id);
		return purchaseOrder;
	}
	
	@DeleteMapping("/{id}")
	public String deletePurchaseOrder(@PathVariable long id) {
		if (purchaseOrderRepository.findById(id).isPresent()) {
			purchaseOrderRepository.deleteById(id);
			return "succesfully delete the purchaseORder with id "+id;
		}
		else {
			return "purchase order with id"+id+"is not present";
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<PurchaseOrder>> getPurchaseById(@PathVariable long id){
		
		List<PurchaseOrder> purchases=purchaseOrderRepository.findByUsersId(id);
		return new ResponseEntity<List<PurchaseOrder>>(purchases,HttpStatus.FOUND);
	}
	
}
