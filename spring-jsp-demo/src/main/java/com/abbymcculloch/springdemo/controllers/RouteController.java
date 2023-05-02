package com.abbymcculloch.springdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
//	localhost:8080/search?festival=easter
//	fest stores the value from the route
//	festival is used in the route and is the value
	@GetMapping("/search")
	public String searchFestival(@RequestParam("festival")String fest) {
		return "year searched for " + fest;
	}
	
//	localhost:8080/pet?name=pepper&age=14
	@GetMapping("/pet")
	public String searchPet(
			@RequestParam(value="name", required=false) String nameInMethod,
			@RequestParam(value="age", required=false) Integer ageInMethod
			) {
		if(nameInMethod == null) {
			return "This is a random pet";
		}
		if(ageInMethod == null) {
			return nameInMethod + " is a mysterious pet";
		}
		return nameInMethod + " is " + ageInMethod + " years old.";
	}
	
//	localhost:8080/activity/1
	@GetMapping("/activity/{name}/{id}")
//	order of path variables matters
	public String activityPath(
			@PathVariable("name") String act,
			@PathVariable("id")Integer id) {
		return "Activity ID: " + id + " Activity: " + act;
	}
	

}
