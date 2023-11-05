package com.sahil.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahil.springjwt.models.Brand;


public interface BrandRepository extends JpaRepository<Brand, Long>{

	@Query(value="select * from brand",nativeQuery = true)
	public List<Brand> brandList();
}
