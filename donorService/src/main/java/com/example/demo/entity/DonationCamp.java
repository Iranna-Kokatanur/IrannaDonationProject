package com.example.demo.entity;



import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;



import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Component
@NoArgsConstructor
@AllArgsConstructor

public class DonationCamp {
	
	
	
	int regNumber;
	
	String donationCampName;
	
	String location;
	
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