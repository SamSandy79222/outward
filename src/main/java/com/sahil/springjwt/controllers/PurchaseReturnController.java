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

import com.sahil.springjwt.models.PurchaseReturn;
import com.sahil.springjwt.repository.PurchaseReturnRepository;

@RestController
@RequestMapping("/purchasereturn")
public class PurchaseReturnController {
	
	@Autowired
	private PurchaseReturnRepository purchaseReturnRepository;
	
	@PostMapping
	public ResponseEntity<PurchaseReturn> createPurchaseReturn(@RequestBody PurchaseReturn purchaseReturn){
		PurchaseReturn purchaseReturn2=purchaseReturnRepository.save(purchaseReturn);
		return new ResponseEntity<>(purchaseReturn2,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PurchaseReturn> udpatePurchaseReturn(@PathVariable long id,@RequestBody PurchaseReturn purchaseReturn){
		
		if (purchaseReturnRepository.findById(id).isPresent()) {
			
			PurchaseReturn existPurchaseReturn=new PurchaseReturn();
			existPurchaseReturn.setPRId(id);
			existPurchaseReturn.setWarehouse(purchaseReturn.getWarehouse());
			existPurchaseReturn.setSupplierCompanyName(purchaseReturn.getSupplierCompanyName());
			existPurchaseReturn.setInvoiceNumber(purchaseReturn.getInvoiceNumber());
			existPurchaseReturn.setDate(purchaseReturn.getDate());
			existPurchaseReturn.setDueDate(purchaseReturn.getDueDate());
			existPurchaseReturn.setType(purchaseReturn.getType());
			existPurchaseReturn.setTaxType(purchaseReturn.getTaxType());
			existPurchaseReturn.setSuppliers(purchaseReturn.getSuppliers());
			existPurchaseReturn.setShippingAddress(purchaseReturn.getShippingAddress());
			
			existPurchaseReturn.setPoNo(purchaseReturn.getPoNo());
			existPurchaseReturn.setPoDate(purchaseReturn.getPoDate());
			existPurchaseReturn.setDeliveryDate(purchaseReturn.getDeliveryDate());
			
			existPurchaseReturn.setDelieveryNote(purchaseReturn.getDelieveryNote());
			existPurchaseReturn.setSupplierReference(purchaseReturn.getSupplierReference());
			existPurchaseReturn.setBuyerOrder(purchaseReturn.getBuyerOrder());
			existPurchaseReturn.setDispatchDocumentNo(purchaseReturn.getDispatchDocumentNo());
			
			existPurchaseReturn.setDispatchThrough(purchaseReturn.getDispatchThrough());
			existPurchaseReturn.setEwayBillNo(purchaseReturn.getEwayBillNo());
			existPurchaseReturn.setVehicleNo(purchaseReturn.getVehicleNo());
			existPurchaseReturn.setPlaceOfSupply(purchaseReturn.getPlaceOfSupply());
			existPurchaseReturn.setPaymentTerm(purchaseReturn.getPaymentTerm());
			existPurchaseReturn.setAccountNumber(purchaseReturn.getAccountNumber());
			existPurchaseReturn.setBankName(purchaseReturn.getBankName());
			existPurchaseReturn.setBranch(purchaseReturn.getBranch());
			existPurchaseReturn.setIfscCode(purchaseReturn.getIfscCode());
			existPurchaseReturn.setPurchaseReturnItems(purchaseReturn.getPurchaseReturnItems());
			
			PurchaseReturn savedPurchaseReturn=purchaseReturnRepository.save(existPurchaseReturn);
 return new ResponseEntity<PurchaseReturn>(savedPurchaseReturn,HttpStatus.ACCEPTED);
		}
		else {
			 return new ResponseEntity<PurchaseReturn>(HttpStatus.NOT_ACCEPTABLE);

		}
	}
	
	@GetMapping
	public ResponseEntity<List<PurchaseReturn>> getAllPurchaseReturn(){
		
		List<PurchaseReturn> purchaseReturn=purchaseReturnRepository.findAll();
		return new ResponseEntity<List<PurchaseReturn>>(purchaseReturn,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public Optional<PurchaseReturn> getPurchaseReturnById(@PathVariable long id){
		Optional<PurchaseReturn> purchasereturn=purchaseReturnRepository.findById(id);
		return purchasereturn;
	}
	

	@DeleteMapping("/{id}")
	public String deletePurchaseReturn(@PathVariable long id) {
		if (purchaseReturnRepository.findById(id).isPresent()) {
			return "succesfully removed the purchasereturn id "+id;
		}
		else {
			return "purchaserReturn with id "+id+" is not present";
		}
	}
}
