package com.example.demo.controllers;
import org.springframework.http.HttpEntity.*;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.DonationDetails;

 

@Controller
public class DonationDetailsController {

    @Autowired
    private DonationDetails object;

    @Autowired
    private ModelAndView mdlView;

    @Autowired
    private RestTemplate template;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String init(Model model) {
     model.addAttribute("majHeading", "DonationDetails");
     return "index";
    }


   
   @GetMapping(path = "/getAllDonations")
   public String findAll(Model model) {

	   DonationDetails[] resp =template.getForObject("http://localhost:9090/api/v1/donationdetails",
			   DonationDetails[].class);

   model.addAttribute("data",resp);
   return "showAll";

   }
   

   
   @GetMapping("/findByBloodGroup")
   public String sendForm(Model model) {
	   model.addAttribute("data",object);
	   return "findByBloodGroup";
   }
   @GetMapping(path = "/bloodGroup")
   public String findAllByBloodGroup(@RequestParam String bloodGroup,Model model) {

	   DonationDetails[] resp =template.getForObject("http://localhost:9090/api/v1/donationdetails/find/"+bloodGroup,
			   DonationDetails[].class);
  
   model.addAttribute("data",resp);
   model.addAttribute("bloodGroup",bloodGroup);
   return "byBloodGroup";

   }
   @GetMapping("/findByCampName")
   public String sendForm1(Model model) {
	   model.addAttribute("data",object);
	   return "findByCampName";
   }
   
   @GetMapping(path = "/campName")
   public String findAllByCampName(@RequestParam("donationCampName") String campName,Model model) {

	   DonationDetails[] resp =template.getForObject("http://localhost:9090/api/v1/donationdetails/searchby/"+campName,
			   DonationDetails[].class);
   model.addAttribute("CampName",campName);
   model.addAttribute("data",resp);
   return "byCampName";

   }
   @GetMapping("/findByLoc")
   public String sendForm2(Model model) {
	   model.addAttribute("data",object);
	   return "findByLoc";
   }
   @GetMapping(path = "/location")
   public String findAllByLocation(@RequestParam("regLocation") String location,Model model) {

	   DonationDetails[] resp =template.getForObject("http://localhost:9090/api/v1/donationdetails/search/"+location,
			   DonationDetails[].class);

   model.addAttribute("data",resp);
   model.addAttribute("Location",location);
   return "byLocation";

   }
   
   @GetMapping("/findByEligibility")
   public String sendForm3(Model model) {
	   model.addAttribute("data",object);
	   return "findByEligibility";
   }
   @GetMapping(path = "/eligibility")
   public String findAllByEligibility(@RequestParam String bloodGroup,Model model) {

	   DonationDetails[] resp =template.getForObject("http://localhost:9090/api/v1/donationdetails/findby/"+bloodGroup,
			   DonationDetails[].class);

   model.addAttribute("data",resp);
   return "byEligibility";

   }
}