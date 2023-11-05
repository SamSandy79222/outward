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

import com.sahil.springjwt.dto.CustomerDto;
import com.sahil.springjwt.models.Customer;
import com.sahil.springjwt.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping
	public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
		
		Customer customer=new Customer();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setCompanyName(customerDto.getCompanyName());
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setPhoneNo(customerDto.getPhoneNo());
		customer.setGstNo(customerDto.getGstNo());
		customer.setEmail(customerDto.getEmail());
		customer.setAddress(customerDto.getAddress());
		customer.setCountry(customerDto.getCountry());
		customer.setState(customerDto.getState());
		customer.setStateCode(customerDto.getStateCode());
		customer.setCity(customerDto.getCity());
		customer.setZipCode(customerDto.getZipCode());
		customer.setOwner(customerDto.getOwner());
		customer.setOpeningBalance(customerDto.getOpeningBalance());
		customer.setOpeningBalanceType(customerDto.getOpeningBalanceType());
		customer.setOpeningBalanceDate(customerDto.getOpeningBalanceDate());
		customer.setPanNo(customerDto.getPanNo());
		
		customerRepository.save(customer);
		return new ResponseEntity<CustomerDto>(customerDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id,@RequestBody CustomerDto customerDto){
		if (customerRepository.findById(id).isPresent()) {
			Customer existcustomer=new Customer();
			existcustomer.setCustomerId(id);
			existcustomer.setCompanyName(customerDto.getCompanyName());
			existcustomer.setCustomerName(customerDto.getCustomerName());
			existcustomer.setPhoneNo(customerDto.getPhoneNo());
			existcustomer.setGstNo(customerDto.getGstNo());
			existcustomer.setEmail(customerDto.getEmail());
			existcustomer.setAddress(customerDto.getAddress());
			existcustomer.setCountry(customerDto.getCountry());
			existcustomer.setState(customerDto.getState());
			existcustomer.setStateCode(customerDto.getStateCode());
			existcustomer.setCity(customerDto.getCity());
			existcustomer.setZipCode(customerDto.getZipCode());
			existcustomer.setOwner(customerDto.getOwner());
			existcustomer.setOpeningBalance(customerDto.getOpeningBalance());
			existcustomer.setOpeningBalanceType(customerDto.getOpeningBalanceType());
			existcustomer.setOpeningBalanceDate(customerDto.getOpeningBalanceDate());
			existcustomer.setPanNo(customerDto.getPanNo());
			
		Customer customer=	customerRepository.save(existcustomer);
			return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);

		}
		else {
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> customers=customerRepository.findAll();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.FOUND);
	}
	
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable long id){
		Optional<Customer> customer=customerRepository.findById(id);
		return customer;
	}
	
@DeleteMapping("/{id}")
public String deleteCustomer(@PathVariable long id) {
	
	if (customerRepository.findById(id).isPresent()) {
		customerRepository.deleteById(id);
		return "succesfully delete the customer with id "+id;
	}
	else {
		return "customer with id "+id+"is not present";
	}
}
	

	
	
}
