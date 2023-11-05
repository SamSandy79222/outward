package com.sahil.springjwt.controllers;

import java.util.List;
import java.util.Optional;

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

import com.sahil.springjwt.models.PurchaseReturn;
import com.sahil.springjwt.models.SaleReturn;
import com.sahil.springjwt.repository.SaleReturnRepository;

@RestController
@RequestMapping("/salereturn")
public class SaleReturnController {

	@Autowired
	private SaleReturnRepository saleReturnRepository;
	
	@PostMapping
	private ResponseEntity<SaleReturn> createSaleReturn(@RequestBody SaleReturn saleReturn){
		
		SaleReturn saleReturn2=saleReturnRepository.save(saleReturn);
		return new ResponseEntity<>(saleReturn2,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SaleReturn> updateSaleReturn(@PathVariable long id,@RequestBody SaleReturn saleReturn){
		
		if (saleReturnRepository.findById(id).isPresent()) {
			
			SaleReturn existSaleReturn=new SaleReturn();
			existSaleReturn.setSrid(id);
			existSaleReturn.setWarehouse(saleReturn.getWarehouse());
			existSaleReturn.setCustomer(saleReturn.getCustomer());
			existSaleReturn.setInvoiceNo(saleReturn.getInvoiceNo());
			
			existSaleReturn.setDate(saleReturn.getDate());
			existSaleReturn.setType(saleReturn.getType());
			existSaleReturn.setReferenceBy(saleReturn.getReferenceBy());
			existSaleReturn.setShippingAddress(saleReturn.getShippingAddress());
			existSaleReturn.setInstallationAddress(saleReturn.getInstallationAddress());
			existSaleReturn.setPoNo(saleReturn.getPoNo());
			existSaleReturn.setPoDate(saleReturn.getPoDate());
			existSaleReturn.setDeliveryDate(saleReturn.getDeliveryDate());
			existSaleReturn.setDelieveryNote(saleReturn.getDelieveryNote());
			existSaleReturn.setSupplierReference(saleReturn.getSupplierReference());
			existSaleReturn.setBuyerOrder(saleReturn.getBuyerOrder());
			existSaleReturn.setDispatchDocumentNo(saleReturn.getDispatchDocumentNo());
			
			existSaleReturn.setDispatchThrough(saleReturn.getDispatchThrough());
			existSaleReturn.setEwayBillNo(saleReturn.getEwayBillNo());
			existSaleReturn.setVehicleNo(saleReturn.getVehicleNo());
			existSaleReturn.setPlaceOfSupply(saleReturn.getPlaceOfSupply());
			existSaleReturn.setPaymentTerm(saleReturn.getPaymentTerm());
			existSaleReturn.setAccountNumber(saleReturn.getAccountNumber());
			existSaleReturn.setBankName(saleReturn.getBankName());
			existSaleReturn.setBranch(saleReturn.getBranch());
			existSaleReturn.setIfscCode(saleReturn.getIfscCode());
			existSaleReturn.setSaleReturnItems(saleReturn.getSaleReturnItems());

			SaleReturn saveSaleReturn=saleReturnRepository.save(existSaleReturn);
			return new ResponseEntity<SaleReturn>(saveSaleReturn,HttpStatus.ACCEPTED);

			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

		}
	}
	
	@GetMapping
	public ResponseEntity<List<SaleReturn>> getAllSaleReturn(){
		List<SaleReturn> saleList=saleReturnRepository.findAll();
		return new ResponseEntity<List<SaleReturn>>(saleList,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public Optional<SaleReturn> getSaleReturnById(@PathVariable long id){
		Optional<SaleReturn> salereturn=saleReturnRepository.findById(id);
		return salereturn;
	}
}
