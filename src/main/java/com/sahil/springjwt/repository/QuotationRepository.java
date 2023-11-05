package com.sahil.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation, Long>{

	
List<Quotation> findByUserId(long userId);
}
