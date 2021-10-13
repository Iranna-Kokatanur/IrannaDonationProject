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

 

@Controller
public class DonationCampController {

    @Autowired
    private DonationCamp object;

    String name=null;
    
    @Autowired
    private ModelAndView mdlView;

    @Autowired
    private RestTemplate template;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String init(Model model) {
     model.addAttribute("majHeading", "DonationCamp");
     return "index";
    }

   @GetMapping(path="/addDonationCamp")
   public String sendForm(Model model) {
      model.addAttribute("command",object);
      return "addDonationCamp";
   }
   
  
   

   
  
   
   @PostMapping(path="/addDonationCamp")
   public String submitForm(@Valid @ModelAttribute("command")DonationCamp donor,BindingResult result) {
	   
	 System.out.println(donor.getDate());
     String nextStep="success";

     if(result.hasErrors()) {
    	 System.out.println(result);
         nextStep="addDonationCamp";
     }
     else {
    	 HttpHeaders headers = new HttpHeaders();
    	 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	 headers.setContentType(MediaType.APPLICATION_JSON);
    	 HttpEntity<DonationCamp> requestBody = new HttpEntity<>(donor,headers);
    	 
    	 
    	 template.exchange("http://localhost:9090/api/v1/donationcamps",HttpMethod.POST, requestBody, DonationCamp.class);
     }
    return nextStep;
   }
   
   @GetMapping(path = "/getAllDonationCamps")
   public String findAll(Model model) {

   DonationCamp[] resp =template.getForObject("http://localhost:9090/api/v1/donationcamps",
   DonationCamp[].class);
   
   model.addAttribute("data",resp);
   return "showAll";

   }
   
   
   @GetMapping(path="/delete")
   public String sendForm1(Model model) {
      model.addAttribute("command",object);
      return "delete";
   }
   
   @RequestMapping("/remove")
  public ResponseEntity<String> delete(@RequestParam("regNumber")int campId,Model model) {
	   
	   HttpHeaders headers= new HttpHeaders();
	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	
	   HttpEntity<DonationCamp> requestBody = new HttpEntity<>(headers);
	   
	   ResponseEntity<String>template=this.template.exchange("http://localhost:9090/api/v1/donationcamps/"+campId,HttpMethod.DELETE, requestBody,String.class);
	   
       if(template.getBody().contains("1 deleted")) {
		   
		   return ResponseEntity.ok().body("Donation Camp with Id "+campId+" has been removed");
	   }
	   else {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 not found");
	   }
       
   }
       @GetMapping(path="/edit")
       public String sendForm2(Model model) {
          model.addAttribute("command",object);
          return "edit";
       }
       
       @RequestMapping(value="/editDetails")
     public ResponseEntity<String> update(@RequestParam("regNumber") int campId,@RequestParam("donationCampName")String campName,@RequestParam("location")String location) {
  	   
  	   HttpHeaders headers= new HttpHeaders();
  	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
  	   
  	   HttpEntity<DonationCamp> requestBody = new HttpEntity<>(headers);
  	   
  	   this.template.exchange("http://localhost:9090/api/v1/donationcamps/"+campId+"/"+campName+"/"+location,HttpMethod.PUT, requestBody,String.class);
  	  
  	   return ResponseEntity.ok().body("Updated Details: CampId:= "+campId+", DonationCampName:= "+campName+", Location:= "+location);
     }
	  
 
   
   
}