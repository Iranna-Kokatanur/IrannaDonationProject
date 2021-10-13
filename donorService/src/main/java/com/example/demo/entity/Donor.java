package com.example.demo.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;
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
public class Donor {
	
	@Range(min=100, max=500, message="Should be between 100-500.")
    int regNumber;
	
	String bloodGroup;
	
	String regLocation;
	
     String firstName;
	
	String lastName;
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate regDate;
	@DateTimeFormat(iso = ISO.DATE)
	LocalDate bloodDonatedDate;
	
	Long phoneNumber;
	
	

	
}
/*{"regNumber":101,"bloodGroup":"B+","regLocation":"Bangalore",
	"firstName":"Victor","lastName":"Jk","regDate":"1997/08/08","bloodDonatedDate":"1997/08/08"
}*/