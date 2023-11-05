package com.sahil.springjwt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Purchase;
import com.sahil.springjwt.models.PurchaseOrder;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
	Set<Purchase> findByUserId(long userId);

}
