package com.sahil.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Leads;

public interface LeadRepository extends JpaRepository<Leads, Long>{

}
