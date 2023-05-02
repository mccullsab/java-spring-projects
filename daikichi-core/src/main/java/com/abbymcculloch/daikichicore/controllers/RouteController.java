package com.abbymcculloch.daikichicore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("daikichi")

public class RouteController {
	
//localhost:8080/daikichi/travel/{place}
	@GetMapping("/travel/{location}")
	public String searchTravel(@PathVariable("location") String place) {
		return "Congratulations! You will soon travel to " + place;
	}
	
//localhost:8080/daikichi/lotto/{number}
	@GetMapping("lotto/{number}")
	public String lottery(@PathVariable("number")Integer numb) {
		if(numb % 2 == 1) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		if(numb % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		return "please enter a number.";
	}
}
