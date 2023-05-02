package com.abbymcculloch.mvcdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abbymcculloch.mvcdemo.models.Donation;
import com.abbymcculloch.mvcdemo.services.DonationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	private DonationService donationService;

//	GET ALL -------------
	@GetMapping("/donations")
	public List<Donation> finalAllDonations(){
		return donationService.allDonations();
	}
	
//	CREATE -------------
	//	diff route than above bc post
	@PostMapping("/donations")
	public Donation addDonation(
			@RequestParam("donationName") String donationName,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("donor") String donor,
			@RequestParam("description") String description
			) {
//		order below has to match the model
		Donation newDonation = new Donation(donationName, donor, description, quantity);
		return donationService.createDonation(newDonation);
	}
	
//	GET ONE------------
	@GetMapping("/donations/{id}")
	public Donation oneDonation(@PathVariable("id")Long id) {
		return donationService.findDonation(id);
	}
	
//	UPDATE -------------
	@PutMapping("/donations/{id}")
	public Donation editDonation(
			@PathVariable("id")Long id,
			@RequestParam("donationName") String donationName,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("donor") String donor,
			@RequestParam("description") String description) {
		Donation oneDonation = donationService.findDonation(id);
		oneDonation.setDescription(description);
		oneDonation.setDonor(donor);
		oneDonation.setDonationName(donationName);
		oneDonation.setQuantity(quantity);

		return donationService.updateDonation(oneDonation);
	}
	
	
//	DELETE-------------

	@DeleteMapping("/donations/{id}")
	public void deleteDonation(@PathVariable("id") Long id) {
		donationService.removeDonation(id);
	}
	
//	CREATE -------------
	@PostMapping("/donations2")
	public Donation addDonation2(
			@Valid @ModelAttribute("newDonation") Donation newDonation, BindingResult result
			) {
		return donationService.createDonation(newDonation);
	}
	
//	UPDATE -------------
	//	path variable should come first, post can not have any path variables called id but put can
	@PostMapping("/donations2/{id}")
	public Donation addDonation2(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("oneDonation") Donation oneDonation, BindingResult result
			) {
		return donationService.updateDonation(oneDonation);
	}
}




























