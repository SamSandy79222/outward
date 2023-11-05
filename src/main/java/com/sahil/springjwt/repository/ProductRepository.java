package com.sahil.springjwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
