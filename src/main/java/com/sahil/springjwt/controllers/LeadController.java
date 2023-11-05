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

import com.sahil.springjwt.models.Leads;
import com.sahil.springjwt.repository.LeadRepository;

@RestController
@RequestMapping("/lead")
public class LeadController {

	@Autowired
	LeadRepository leadRepository;
	 
	@PostMapping
	public ResponseEntity<Leads> createLead(@RequestBody Leads leads1){
		Leads leads12=leadRepository.save(leads1);
		return new ResponseEntity<Leads>(leads12,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Leads> updateLeads(@PathVariable long id,@RequestBody Leads leads){
		
		if (leadRepository.findById(id).isPresent()) {
			Leads existLead=new Leads();
			existLead.setLeadsId(id);
			existLead.setCustomer(leads.getCustomer());
			existLead.setLeadTitle(leads.getLeadTitle());
			existLead.setLeadDescription(leads.getLeadDescription());
			existLead.setLeadStatus(leads.getLeadStatus());
			existLead.setLeadValue(leads.getLeadValue());
			existLead.setLeadSource(leads.getLeadSource());
			existLead.setUser(leads.getUser());
			existLead.setLeadDate(leads.getLeadDate());
			
			Leads leadssaved=leadRepository.save(existLead);
			return new ResponseEntity<Leads>(leadssaved,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Leads>(HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Leads>> getAllLeads(){
		List<Leads> leads=leadRepository.findAll();
		return new ResponseEntity<List<Leads>>(leads,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public Optional<Leads> findByid(@PathVariable long id) {
		Optional<Leads> leads=leadRepository.findById(id);
		return leads;
		
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteLead(@PathVariable long id) {
		if (leadRepository.findById(id).isPresent()) {
			leadRepository.deleteById(id);
			return "succesfully delte the lead";
		}
		else {
			return "lead with id "+id+" is not present";
		}
	}
	
	
	
}
