package com.example.demo.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Donor;



@Repository
public interface DonationRepository extends JpaRepository<Donor,Integer>{

	List<Donor>findByBloodGroup(String bloodGroup);
	
	@Query(nativeQuery = true,
			value="update donor set blood_group =:bloodGroup,phone_number=:phoneNumber where reg_number =:regNumber")
	@Modifying
	@Transactional
	public int update(@Param("regNumber")int regNumber,@Param("bloodGroup") String bloodGroup,@Param("phoneNumber") Long phoneNumber);
	
	
}
