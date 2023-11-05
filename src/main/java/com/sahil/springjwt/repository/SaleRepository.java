package com.sahil.springjwt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	Set<Sale> findByUsersId(long usersId);

	
	
}
