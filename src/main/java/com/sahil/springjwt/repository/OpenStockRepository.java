package com.sahil.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.OpenStock;


public interface OpenStockRepository extends JpaRepository<OpenStock, Long>{

}
