package com.example.demo.entity;

import java.time.LocalDate;



import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DonationDetails {
	
	
	int regNumber;
	
	String firstName;
	
	String lastName;
	
	String bloodGroup;
	
	LocalDate bloodDonatedDate;
	
	LocalDate regDate;
	
	String regLocation;
	
	String donationCampName;
	
	int CampNameId;
	
	Long PhoneNumber;
	

}
