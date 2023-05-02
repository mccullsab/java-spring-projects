package com.abbymcculloch.dojogold.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FarmController {
	@GetMapping("/")
	public String home() {
		return "game.jsp";
	}
}
