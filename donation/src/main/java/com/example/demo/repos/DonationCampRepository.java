package com.example.demo.repos;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonationCamp;




@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp,Integer>{
	
	List<DonationCamp>findByLocation(String location);
	
	@Query(nativeQuery = true,
			value="update donationcamp set location =:location,donation_camp_name=:donationCampName where reg_number =:regNumber")
	@Modifying
	@Transactional
	public int update(@Param("regNumber")int regNumber,@Param("donationCampName") String donationCampName,@Param("location") String location);

}
