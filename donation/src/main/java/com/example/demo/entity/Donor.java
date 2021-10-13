package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="donor")
@NoArgsConstructor
@AllArgsConstructor
public class Donor {
	
	@Id
	@Column(name = "regNumber")
    int regNumber;
	@Column(name = "bloodGroup")
	String bloodGroup;
	@Column(name = "regLocation")
	String regLocation;
	@Column(name = "firstName")
     String firstName;
	@Column(name = "lastName")
	String lastName;
	@Column(name = "regDate")
	LocalDate regDate;
	@Column(name = "bloodDonatedDate")
	LocalDate bloodDonatedDate;
	@Column(name = "phoneNumber")
	Long phoneNumber;
	
//	@ManyToOne
//    @JoinColumn(name="column_id")
//    DonationCamp camp;
	
	

	
}
/*{"regNumber":101,"bloodGroup":"B+","regLocation":"Bangalore",
	"firstName":"Victor","lastName":"Jk","regDate":"1997/08/08","bloodDonatedDate":"1997/08/08"
}*/