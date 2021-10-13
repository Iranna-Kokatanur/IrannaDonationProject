package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.DonationDetails;
import com.example.demo.entity.Donor;
import com.example.demo.repos.DonationCampRepository;

@Service
public class DonationCampService {
	
	@Autowired 
	private DonationCampRepository repo;
	
	public DonationCamp addDonationCamp(DonationCamp entity) {
		
		return this.repo.save(entity);
		
	}
	
      public List<DonationCamp> findAll(){
		
		return this.repo.findAll();
		
	}
      
     public List<DonationCamp> findByLocation(String location){
  		return this.repo.findByLocation(location);
  	}
     public int remove(int regNumber) {
         int rowdeleted=0;
         if(this.repo.existsById(regNumber)) {
             this.repo.deleteById(regNumber);
             rowdeleted=1;
         }
         return rowdeleted;
     }
     
     
     public int update(int regNumber,String donationCampName,String location) {
 		
 		return this.repo.update(regNumber,donationCampName,location);
 	}

}
