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

import com.sahil.springjwt.models.Sale;
import com.sahil.springjwt.models.SaleOrder;
import com.sahil.springjwt.repository.SaleRepository;

@RestController
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private SaleRepository saleRepository;
	
	@PostMapping
	private ResponseEntity<Sale> createSale(@RequestBody Sale sale){
		Sale sale2=saleRepository.save(sale);
		return new ResponseEntity<Sale>(sale2,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	private ResponseEntity<Sale> updateSale(@PathVariable long id,@RequestBody Sale sale){
		if (saleRepository.findById(id).isPresent()) {
			Sale existsale=new Sale();
			existsale.setSaleId(id);
			existsale.setWarehouse(sale.getWarehouse());
			existsale.setCustomerCompany(sale.getCustomerCompany());
			existsale.setInvoiceNo(sale.getInvoiceNo());
			existsale.setContactName(sale.getContactName());
			existsale.setDate(sale.getDate());
			existsale.setDueDate(sale.getDueDate());
			existsale.setType(sale.getType());
			existsale.setQuotationNo(sale.getQuotationNo());
			existsale.setSaleAgent(sale.getSaleAgent());
			existsale.setUsers(sale.getUsers());
			
			existsale.setDeliveryDate(sale.getDeliveryDate());
			
			existsale.setInstallationDate(sale.getInstallationDate());
			existsale.setTaxType(sale.getTaxType());
			existsale.setReferencedBy(sale.getReferencedBy());
			existsale.setRemark(sale.getRemark());
			existsale.setBillingAddress(sale.getBillingAddress());
			existsale.setShippingAddress(sale.getShippingAddress());
			existsale.setInstallationAddress(sale.getInstallationAddress());
			
			existsale.setSoNo(sale.getSoNo());
			existsale.setSoDate(sale.getSoDate());
			
			existsale.setDelieveryDate(sale.getDelieveryDate());
			
			existsale.setDelieveryNote(sale.getDelieveryNote());
			existsale.setSupplierReference(sale.getSupplierReference());
			existsale.setBuyerOrder(sale.getBuyerOrder());
			existsale.setDispatchedDocumentNumber(sale.getDispatchedDocumentNumber());
			existsale.setDispatchThrough(sale.getDispatchThrough());
			existsale.setEwayBillNumber(sale.getEwayBillNumber());
			existsale.setVehicleNumber(sale.getVehicleNumber());
			existsale.setPlaceOfSupply(sale.getPlaceOfSupply());
			existsale.setPaymentTerm(sale.getPaymentTerm());
			existsale.setSaleItem(sale.getSaleItem());
			Sale salesaved=saleRepository.save(existsale);
			
			return new ResponseEntity<Sale>(salesaved,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Sale>(HttpStatus.NOT_ACCEPTABLE);

		}
	}
	
	@GetMapping
	public ResponseEntity<List<Sale>> getAllSale(){
		
		List<Sale> getSale=saleRepository.findAll();
		return new ResponseEntity<List<Sale>>(getSale,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public Optional<Sale> getSaleById(@PathVariable long id){
		Optional<Sale> saleWithId=saleRepository.findById(id);
		return saleWithId;
	}
	
	@DeleteMapping("/{id}")
	public String deleteSale(@PathVariable long id) {
		if (saleRepository.findById(id).isPresent()) {
			saleRepository.deleteById(id);
			return "succesfully delete the sale with id"+id;
			
		}
		else {
			return " Sale with id "+id+" is not present";

		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Set<Sale>> getSaleByUsserId(@PathVariable long id){
		
		Set<Sale> sales=saleRepository.findByUsersId(id);
		return new ResponseEntity<Set<Sale>>(sales,HttpStatus.FOUND);
	}
	
	
	
	
	
}
