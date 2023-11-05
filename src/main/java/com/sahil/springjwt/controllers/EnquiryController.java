package com.sahil.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.models.Enquiry;
import com.sahil.springjwt.models.Leads;
import com.sahil.springjwt.repository.EnquiryRepository;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

	@Autowired
	EnquiryRepository enquiryRepository;
	
	
	@PostMapping
	public ResponseEntity<Enquiry> addEnquiry(@RequestBody Enquiry enquiry){
		Enquiry enquiry2=enquiryRepository.save(enquiry);
		return new ResponseEntity<Enquiry>(enquiry2,HttpStatus.CREATED);
	}
	
	
@PutMapping("/{id}")
public ResponseEntity<Enquiry> updateEnquiry(@PathVariable long id,@RequestBody Enquiry enquiry){
	if (enquiryRepository.findById(id).isPresent()) {
		Enquiry existenquiry=new Enquiry();
		existenquiry.setEnquiryId(id);
		existenquiry.setCustomer(enquiry.getCustomer());
		existenquiry.setEnquiryTitle(enquiry.getEnquiryTitle());
		existenquiry.setEnquiryDate(enquiry.getEnquiryDate());
		existenquiry.setEnquirySource(enquiry.getEnquirySource());
		existenquiry.setEnquiryStatus(enquiry.getEnquiryStatus());
		existenquiry.setUser(enquiry.getUser());
		Enquiry saveEnquiry=enquiryRepository.save(existenquiry);
		return new ResponseEntity<Enquiry>(saveEnquiry,HttpStatus.OK); 
	}
	else {
		return new ResponseEntity<Enquiry>(HttpStatus.NOT_FOUND);
	}
}

@DeleteMapping("/{id}")
public String deleteEnquiryById(@PathVariable long id) {
if (enquiryRepository.findById(id).isPresent()) {
	enquiryRepository.deleteById(id);
	return "succesfully delete the enquiry with id "+id;
}
else {
	return "enquiry with id "+ id +" is not there";
}
}


@GetMapping
public ResponseEntity<List<Enquiry>> getAllEnquiry(){
	List<Enquiry> getAllEnquiry=enquiryRepository.findAll();
	return new ResponseEntity<List<Enquiry>>(getAllEnquiry,HttpStatus.FOUND);
}
@GetMapping("/{id}")
public Optional<Enquiry> getEnquiryById(@PathVariable long id){
	Optional<Enquiry> enquiry=enquiryRepository.findById(id);
	return enquiry;
}


}
