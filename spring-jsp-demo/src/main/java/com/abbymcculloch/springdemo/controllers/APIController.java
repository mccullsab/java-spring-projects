package com.abbymcculloch.springdemo.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
	
//	get, patch, post, delete, put
	@RequestMapping("/option1") 
	public ArrayList<String> option1Routing() {
		ArrayList<String> skills = new ArrayList<>();
		skills.add("breaking code");
		skills.add("debudding");
		return skills;
	}
	
	@RequestMapping(value = "/option2", method=RequestMethod.GET)
	public String option2Routing() {
		return "option 2";
		
	}
	
//	@PostMapping, @PutMapping, @DeleteMapping
	@GetMapping("/option3")
	public String option3Routing() {
		return "option 3: get mapping";
	}
	
	
	
}
