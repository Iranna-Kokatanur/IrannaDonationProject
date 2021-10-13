package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="donationdetails")
public class DonationDetails {
	
	@Id
	@Column(name = "regNumber")
	int regNumber;
	@Column(name = "firstName")
	String firstName;
	@Column(name = "lastName")
	String lastName;
	@Column(name = "bloodGroup")
	String bloodGroup;
	@Column(name = "bloodDonatedDate")
	LocalDate bloodDonatedDate;
	@Column(name = "regDate")
	LocalDate regDate;
	@Column(name = "regLocation")
	String regLocation;
	@Column(name = "donationCampName")
	String donationCampName;
	@Column(name = "CampNameId")
	int CampNameId;
	@Column(name = "phoneNumber")
	Long PhoneNumber;
	

}
