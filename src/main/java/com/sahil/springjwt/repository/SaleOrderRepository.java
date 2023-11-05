package com.sahil.springjwt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.SaleOrder;

public interface SaleOrderRepository extends JpaRepository<SaleOrder, Long>{
	Set<SaleOrder> findByUsersId(long usersId);
}	

