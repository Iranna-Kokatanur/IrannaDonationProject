package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Donor;

import com.example.demo.repos.DonationRepository;

@Service
public class DonationService {
	
	@Autowired 
	private DonationRepository repo;
	
    public List<Donor> findAll(){
		
		return this.repo.findAll();
	}
    
    public Donor addDonor(Donor entity) {
		
		return this.repo.save(entity);
		
	}

    public List<Donor> findByBloodGroup(String group){
		return this.repo.findByBloodGroup(group);
	
	}
    
    public int remove(int regNumber) {
        int rowdeleted=0;
        if(this.repo.existsById(regNumber)) {
            this.repo.deleteById(regNumber);
            rowdeleted=1;
        }
        return rowdeleted;
    }
    
    public int update(int regNumber,String bloodGroup,Long phoneNumber) {
		
		return this.repo.update(regNumber,bloodGroup,phoneNumber);
	}
}
