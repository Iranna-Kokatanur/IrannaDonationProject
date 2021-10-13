package com.example.demo.entity;



import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;

import org.hibernate.validator.constraints.Range;
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
	
	
	@Range(min=100, max=500, message="Should be between 100-500.")
	int regNumber;
	
	String donationCampName;
	
	String location;
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate date;


}
/*{
"regNumber": 102,
"donationCampName": "Sri",
"location": "Bangalore"
}*/