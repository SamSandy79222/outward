package com.sahil.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
