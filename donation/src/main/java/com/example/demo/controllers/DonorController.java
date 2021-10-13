package com.example.demo.controllers;

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

import com.example.demo.entity.Donor;

import com.example.demo.services.DonationService;


@RestController
@RequestMapping(path ="/api/v1/donations")
public class DonorController {
	
	private DonationService service;
	
	@Autowired
	public void setService(DonationService service) {
		
		this.service=service;
	}

	@GetMapping
	public List<Donor> findAll(){
		return this.service.findAll();
	}
	
	
	
	@PostMapping
	public ResponseEntity<Donor> add(@RequestBody  Donor entity){
		Donor addedEntity = this.service.addDonor(entity);
		System.out.println(addedEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	
	@DeleteMapping(path="/{regNumber}")
	   public ResponseEntity<String> unregister(@PathVariable("regNumber") int regNumber){
	       int count = this.service.remove(regNumber);

	       if(count ==1) {
	          return ResponseEntity.ok().body(count +" deleted");

	       } else {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
	       }


	   }
	@PutMapping(path = "/{regNumber}/{bloodGroup}/{phoneNumber}")
	public ResponseEntity<String> findByRegNumber(@PathVariable("regNumber") int regNumber,@PathVariable("bloodGroup") String bloodGroup,@PathVariable("phoneNumber")Long phoneNumber) {
	
		int count=this.service.update(regNumber, bloodGroup,phoneNumber);
		return ResponseEntity.ok().body(count+" row updated");
	}
}
