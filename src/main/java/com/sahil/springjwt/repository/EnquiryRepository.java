package com.sahil.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springjwt.models.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long>{

}
