package com.sahil.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Suppliers;

public interface SupplierRepository extends JpaRepository<Suppliers, Long>{

}
