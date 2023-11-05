package com.sahil.springjwt.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.sahil.springjwt.models.Purchase;
import com.sahil.springjwt.models.PurchaseOrder;
import com.sahil.springjwt.repository.PurchaseRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@PostMapping
	private ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase){
		Purchase purchase2=purchaseRepository.save(purchase);
		return new ResponseEntity<>(purchase2,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Purchase> updatePurchase(@PathVariable long id,@RequestBody Purchase purchase){
		if (purchaseRepository.findById(id).isPresent()) {
			
			Purchase existPurchase=new Purchase();
			existPurchase.setPId(id);
			existPurchase.setWarehouse(purchase.getWarehouse());
			existPurchase.setSuppliers(purchase.getSuppliers());
			existPurchase.setContactName(purchase.getContactName());
			existPurchase.setCreatedDate(purchase.getCreatedDate());
			existPurchase.setDueDate(purchase.getDueDate());
			existPurchase.setType(purchase.getType());
			existPurchase.setUser(purchase.getUser());
			existPurchase.setStatus(purchase.getStatus());
			existPurchase.setTaxType(purchase.getTaxType());
			existPurchase.setBillingAddress(purchase.getBillingAddress());
			existPurchase.setShippingAddress(purchase.getShippingAddress());
			existPurchase.setPoNo(purchase.getPoNo());
			existPurchase.setPoDate(purchase.getPoDate());
			existPurchase.setDeliveryDate(purchase.getDeliveryDate());
			existPurchase.setDelieveryNote(purchase.getDelieveryNote());
			existPurchase.setSupplierReference(purchase.getSupplierReference());
			existPurchase.setBuyerOrder(purchase.getBuyerOrder());
			existPurchase.setDispatchDocumentNo(purchase.getDispatchDocumentNo());
			existPurchase.setDispatchThrough(purchase.getDispatchThrough());
			existPurchase.setEwayBillNo(purchase.getEwayBillNo());
			existPurchase.setVehicleNo(purchase.getVehicleNo());
			existPurchase.setPlaceOfSupply(purchase.getPlaceOfSupply());
			existPurchase.setPaymentTerm(purchase.getPaymentTerm());
			existPurchase.setAccountNumber(purchase.getAccountNumber());
			existPurchase.setBankName(purchase.getBankName());
			existPurchase.setBranch(purchase.getBranch());
			existPurchase.setIfscCode(purchase.getIfscCode());
			existPurchase.setPurchaseItems(purchase.getPurchaseItems());
			existPurchase.setInvoiceNo(purchase.getInvoiceNo());
			Purchase purchasesaved=purchaseRepository.save(existPurchase);
			return new ResponseEntity<Purchase>(purchasesaved,HttpStatus.OK);
					
			
		}else {
			return new ResponseEntity<Purchase>(HttpStatus.BAD_REQUEST);

		}
	}
	
	
	@GetMapping
	public ResponseEntity<List<Purchase>> getAllPurchase(){
		List<Purchase> purchaseList=purchaseRepository.findAll();
		return new ResponseEntity<List<Purchase>>(purchaseList,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public Optional<Purchase> purchaseListById(@PathVariable long id){
		Optional<Purchase> purchaseDetail=purchaseRepository.findById(id);
		return purchaseDetail;
	}
	
	@DeleteMapping("/{id}")
	private String deletePurchase(@PathVariable long id) {
		if (purchaseRepository.findById(id).isPresent()) {
			purchaseRepository.deleteById(id);
			return"purchase with id "+id+" is deleted succesfully";
		}
		else {
			return "purchase with id "+id+" is not present";
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Set<Purchase>> getPurchaseById(@PathVariable long id){
		
		Set<Purchase> purchases=purchaseRepository.findByUserId(id);
		return new ResponseEntity<Set<Purchase>>(purchases,HttpStatus.FOUND);
	}
	
}
