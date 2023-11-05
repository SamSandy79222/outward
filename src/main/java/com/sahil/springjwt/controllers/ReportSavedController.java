package com.sahil.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.models.ReportSaved;
import com.sahil.springjwt.repository.ReportSavedRepository;

@RestController
@RequestMapping("/reportsaved")
public class ReportSavedController {

	
	@Autowired
	ReportSavedRepository reportSavedRepository;
	
	@GetMapping
	public ResponseEntity<List<ReportSaved>> getAll(){
		List<ReportSaved> allReport=reportSavedRepository.findAll();
		return new ResponseEntity<List<ReportSaved>>(allReport,HttpStatus.FOUND);
	}
}
