package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonationDetails;


@Repository
public interface DonationDetailsRepository extends JpaRepository<DonationDetails,Integer>{
	
}
