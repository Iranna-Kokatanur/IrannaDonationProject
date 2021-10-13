package com.example.demo.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.DonationDetails;
import com.example.demo.entity.Donor;
import com.example.demo.services.DonationCampService;
import com.example.demo.services.DonationDetailsService;
import com.example.demo.services.DonationService;

import javassist.expr.NewArray;

@RestController
@RequestMapping(path ="/api/v1/donationdetails")
public class DonationDetailsController {
	
   private DonationCampService service;
   
   List<DonationDetails>list3=new ArrayList<>();
	
	@Autowired
	public void setService(DonationCampService service) {
		
		this.service=service;
	}  
	
    private DonationService service1;
	
	@Autowired
	public void setService(DonationService service) {
		
		this.service1=service;
	}
	
    private DonationDetailsService service2;
	
	@Autowired
	public void setService(DonationDetailsService service) {
		
		this.service2=service;
	}
	
	
	DonationDetails details=null;
	@GetMapping
	public List<DonationDetails> findAllDonors(){
		List<DonationDetails>list2=new ArrayList<>();
		List<DonationCamp>list=this.service.findAll();
		List<Donor>list1=this.service1.findAll();
		
		for(DonationCamp e:list) {
			for(Donor e1:list1) {
				if(e.getLocation().equals(e1.getRegLocation())) {
					details=new DonationDetails(e1.getRegNumber(),e1.getFirstName(),e1.getLastName(),
							e1.getBloodGroup(),e1.getBloodDonatedDate(),e1.getRegDate(),
							e1.getRegLocation(),e.getDonationCampName(),e.getRegNumber(),e1.getPhoneNumber());
					this.service2.save(details);
				    list2.add(details);
				}
			}
		}
		System.out.println(list2);
		this.list3=list2;
		return list2;
	}
	
	
	@GetMapping(path = "/search/{location}")
	public List<DonationDetails> findByLocation(@PathVariable("location") String location) {
//		List<DonationDetails>list=this.service2.findAllTheDetails();
		List<DonationDetails>list2=new ArrayList<>();
		for(DonationDetails e:this.list3) {
			if(e.getRegLocation().equals(location)) {
				list2.add(e);
			}
		}
		return list2;
	}
	@GetMapping(path="/searchby/{campName}")
	public List<DonationDetails> findAllByCampName(@PathVariable("campName") String campName){
//		List<DonationDetails>list=this.service2.findAllTheDetails();
		List<DonationDetails>list2=new ArrayList<>();
		for(DonationDetails e:this.list3) {
			if(e.getDonationCampName().equals(campName)) {
				list2.add(e);
			}
		}
		return list2;
	}
	@GetMapping(path="/find/{bloodGroup}")
	public List<DonationDetails> findByBloodGroup(@PathVariable("bloodGroup") String bloodGroup){
//		List<DonationDetails>list=this.service2.findAllTheDetails();
		List<DonationDetails>list2=new ArrayList<>();
		for(DonationDetails e:this.list3) {
			if(e.getBloodGroup().equals(bloodGroup)) {
				list2.add(e);
			}
		}
		return list2;
	}
	@GetMapping(path="/findby/{bloodGroup}")
	public List<DonationDetails> findByBloodGroupAndDate(@PathVariable("bloodGroup") String bloodGroup){
//		List<DonationDetails>list=this.service2.findAllTheDetails();
		List<DonationDetails>list2=new ArrayList<>();
		for(DonationDetails e:this.list3) {
			long date = ChronoUnit.MONTHS.between(
				     YearMonth.from(e.getBloodDonatedDate()), 
				     YearMonth.from(LocalDate.now())
				);
			if(e.getBloodGroup().equals(bloodGroup) && date>=6) {
				list2.add(e);
			}
		}
		return list2;
	}
	
	
	
}
