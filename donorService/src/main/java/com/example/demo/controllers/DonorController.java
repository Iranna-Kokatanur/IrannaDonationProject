package com.example.demo.controllers;
import org.springframework.http.HttpEntity.*;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.Donor;
 

@Controller
public class DonorController {

    @Autowired
    private Donor object;

    String name=null;
    
    @Autowired
    private ModelAndView mdlView;

    @Autowired
    private RestTemplate template;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String init(Model model) {
     model.addAttribute("majHeading", "Donor");
     return "index";
    }

   @GetMapping(path="/addDonor")
   public String sendForm(Model model) {
      model.addAttribute("command",object);
      return "addDonor";
   }
   
   
   @PostMapping(path="/addDonor")
   public String submitForm(@Valid @ModelAttribute("command") Donor donor,BindingResult result) {
	   
	 name=donor.getRegLocation();
	   
     String nextStep="success";

     if(result.hasErrors()) {
    	 System.out.println(result);
         nextStep="addDonor";
     }
     else {
    	 HttpHeaders headers = new HttpHeaders();
    	 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	 headers.setContentType(MediaType.APPLICATION_JSON);
    	 HttpEntity<Donor> requestBody = new HttpEntity<>(donor,headers);
    	 
    	 
    	 template.postForObject("http://localhost:9090/api/v1/donations", requestBody, Donor.class);
     }
    return nextStep;
   }
   
   @GetMapping(path = "/getAllDonors")
   public String findAll(Model model) {

   Donor[] resp =template.getForObject("http://localhost:9090/api/v1/donations",
   Donor[].class);

   model.addAttribute("data",resp);
   return "showAll";

   }
   
   @GetMapping(path = "/showDonationCampByLocation/{name}")
   public String findDonationCamp(Model model,@PathVariable("name") String name) {
	  

   DonationCamp[] resp =template.getForObject("http://localhost:9090/api/v1/donationcamps/"+name,
		   DonationCamp[].class);
   model.addAttribute("data",resp);
   model.addAttribute("location",name);
   return "showCampByLoc";

   }

   
   @GetMapping(path="/showCampByLoc")
   public String sendForm1(Model model) {
      model.addAttribute("data",object);
      return "showCampByLoc";
   }
   
   @GetMapping(path="/location")
   public String findByLoc(@RequestParam("regLocation") String location,Model model) {
	   DonationCamp[] resp =template.getForObject("http://localhost:9090/api/v1/donationcamps/"+location,
			   DonationCamp[].class);
	   model.addAttribute("data",resp);
	   model.addAttribute("location",location);
	   return "showCamp";
   }
   
   @GetMapping(path="/unregister")
   public String sendForm2(Model model) {
      model.addAttribute("data",object);
      return "unregister";
   }
   
   @RequestMapping("/Unregister")
   public ResponseEntity<String> unregister(@RequestParam("regNumber")int regNumber,Model model) {
	   
	   HttpHeaders headers= new HttpHeaders();
	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	
	   HttpEntity<Donor> requestBody = new HttpEntity<>(headers);
	   
	   ResponseEntity<String>template=this.template.exchange("http://localhost:9090/api/v1/donations/"+regNumber,HttpMethod.DELETE, requestBody,String.class);
	   

	   
	   if(template.getBody().contains("1 deleted")) {
		   
		   return ResponseEntity.ok().body("Donor with regnumber "+regNumber+" unregistered");
	   }
	   else {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 NOT FOUND");
	   }
	   

	  
   }
   
   @GetMapping(path="/update")
   public String sendForm3(Model model) {
      model.addAttribute("data",object);
      return "update";
   }
   
   @RequestMapping(value="/Update")
   public ResponseEntity<String> update(@RequestParam("regNumber") int regNumber,@RequestParam("bloodGroup")String bloodGroup,@RequestParam("phoneNumber")Long phoneNumber) {
	   
	   HttpHeaders headers= new HttpHeaders();
	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	   
	   HttpEntity<Donor> requestBody = new HttpEntity<>(headers);
	   
	   this.template.exchange("http://localhost:9090/api/v1/donations/"+regNumber+"/"+bloodGroup+"/"+phoneNumber,HttpMethod.PUT, requestBody,String.class);
	  
	   return ResponseEntity.ok().body("Updated Details: PhoneNumber:= "+phoneNumber+", BloodGroup:= "+bloodGroup);
   }
   
}