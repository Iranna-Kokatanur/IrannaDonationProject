package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.DonationDetails;
import com.example.demo.entity.Donor;
import com.example.demo.repos.DonationDetailsRepository;

@Service
public class DonationDetailsService {
	
	@Autowired 
	private DonationDetailsRepository repo;
	
     public DonationDetails save(DonationDetails entity) {
		
		return this.repo.save(entity);
		
	}
     
//     public List<DonationDetails> findAllByCampName(String campName){
//    	
// 		return this.repo.findByCampName(campName);
// 	}
     
//     public List<DonationDetails> findByBloodGroup(String group){
//    	 
// 		return this.repo.findByBloodGroup(group);
// 	
// 	}
     public int remove(int rollNo) {
         int rowdeleted=0;
         if(this.repo.existsById(rollNo)) {
             this.repo.deleteById(rollNo);
             rowdeleted=1;
         }
         return rowdeleted;

     }
     public List<DonationDetails> findAllTheDetails() {
 		return this.repo.findAll();
 	  }
     
     
    

     
}
