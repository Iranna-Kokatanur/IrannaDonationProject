package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.DonationDetails;
import com.example.demo.entity.Donor;
import com.example.demo.services.DonationCampService;
import com.example.demo.services.DonationService;

@RestController
@RequestMapping(path ="/api/v1/donationcamps")
public class DonationCampController {
	
	private DonationCampService service;
	
	@Autowired
	public void setService(DonationCampService service) {
		
		this.service=service;
	}  
	
	
	@GetMapping
	public List<DonationCamp> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping(path="/{location}")
	public List<DonationCamp> findByLocation(@PathVariable("location") String location){
		return this.service.findByLocation(location);
	}
	
	
	
	@PostMapping
	public ResponseEntity<DonationCamp> add(@RequestBody DonationCamp entity){
		DonationCamp addedEntity = this.service.addDonationCamp(entity);
		System.out.println(addedEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	
	@DeleteMapping(path="/{regNumber}")
	   public ResponseEntity<String> removeCamp(@PathVariable("regNumber") int regNumber){
	       int count = this.service.remove(regNumber);

	       if(count ==1) {
	          return ResponseEntity.ok().body(count +" deleted");

	       } else {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
	       }

	   }
	@PutMapping(path = "/{regNumber}/{donationCampName}/{location}")
	public ResponseEntity<String> findByRegNumber(@PathVariable("regNumber") int regNumber,@PathVariable("donationCampName") String donationCampName,@PathVariable("location")String location) {
	
		int count=this.service.update(regNumber, donationCampName,location);
		return ResponseEntity.ok().body(count+" row updated");
	}

}
