package com.sahil.springjwt.controllers;

import java.lang.StackWalker.Option;
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

import com.sahil.springjwt.dto.QuotationDto;
import com.sahil.springjwt.models.Quotation;
import com.sahil.springjwt.repository.QuotationRepository;

@RestController
@RequestMapping("/Quotation")
public class QuotationController {

	@Autowired
	QuotationRepository quotationRepository;
	
	@PostMapping
	public ResponseEntity<Quotation> createQuotation(@RequestBody Quotation quotation){
		Quotation saveQuotation=quotationRepository.save(quotation);
		return new ResponseEntity<Quotation>(saveQuotation,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public String deleteQuotation(@PathVariable long id) {
		if (quotationRepository.existsById(id)) {
			quotationRepository.deleteById(id);
			return "succesfully delete the quotation with id"+id;
			
		}
		else {
			return "quotation with id "+id+" is not present";
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Quotation> updateQuotation(@PathVariable long id,@RequestBody QuotationDto quotationDto){
		
		if (quotationRepository.findById(id).isPresent()) {
			
			Optional<Quotation> updateQuotation=quotationRepository.findById(id);
			
			Quotation existQuotation= updateQuotation.get();
			existQuotation.setQuotationId(id);
			
			existQuotation.setDate(quotationDto.getDate());
			existQuotation.setStatus(quotationDto.getStatus());
			existQuotation.setTaxType(quotationDto.getTaxType());
			existQuotation.setQuotationSubject(quotationDto.getQuotationSubject());
			existQuotation.setPaymentTerm(quotationDto.getPaymentTerm());
			existQuotation.setDeliveryTerm(quotationDto.getDeliveryTerm());
			existQuotation.setQuotationValidity(quotationDto.getQuotationValidity());
			existQuotation.setEmployeeName(quotationDto.getEmployeeName());
			existQuotation.setReferencedBy(quotationDto.getReferencedBy());
			existQuotation.setRemark(quotationDto.getRemark());
			existQuotation.setWarranty(quotationDto.getWarranty());
			//trial
			existQuotation.setUser(quotationDto.getUser());
			
			existQuotation.setCustomer(quotationDto.getCustomer());
			existQuotation.setQuotatioItems(quotationDto.getQuotatioItems());
			Quotation quotation3=quotationRepository.save(existQuotation);
			return new ResponseEntity<Quotation>(quotation3,HttpStatus.OK);
			
			
		}
		else {
			return new ResponseEntity<Quotation>(HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping
	public ResponseEntity<List<Quotation>> getAllQuotation(){
		
		List<Quotation> quotation=quotationRepository.findAll();
		return new ResponseEntity<List<Quotation>>(quotation,HttpStatus.FOUND);
		
	}
	
	@GetMapping("/{id}")
	public Optional<Quotation> getById(@PathVariable long id){
		
		Optional<Quotation> getQuotation=quotationRepository.findById(id);
		
		return getQuotation;
	}
	
	@GetMapping("/user/{userId}")
	public List<Quotation> getQuotationByUserId(@PathVariable long userId){
				List<Quotation> quotationByUserId	=quotationRepository.findByUserId(userId);
				return quotationByUserId;
	}
	
	
	
	
	
	
	
}
