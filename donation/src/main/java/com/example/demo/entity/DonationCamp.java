package com.example.demo.entity;



import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repos.DonationRepository;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="donationcamp")
public class DonationCamp {
	
	
	@Id
	@Column(name = "regNumber")
	int regNumber;
	@Column(name = "donationCampName")
	String donationCampName;
	@Column(name = "location")
	String location;
	@Column(name = "dateOfHeld")
	LocalDate date;

//	@OneToMany(targetEntity = Donor.class, cascade = CascadeType.ALL)
//	@JoinColumn(name="donation_ref" ,referencedColumnName = "regNumber")
//	List<Donor> donorList=this.repo.findAll();

}
/*{
"regNumber": 102,
"donationCampName": "Sri",
"location": "Bangalore"
}*/