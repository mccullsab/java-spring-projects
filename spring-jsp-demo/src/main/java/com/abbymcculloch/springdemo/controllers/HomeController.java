package com.abbymcculloch.springdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String renderHome() {
		return "home.jsp";
	}
	
	@GetMapping("/jstl")
	public String renderJSTLDemo(Model model) {
		String name = "pepper";
		Integer happiness = 10;
		String hackerCode = "<script>('Hi')</script>";

		
		model.addAttribute("jspName", name);
		model.addAttribute("jspHappiness", happiness);
		model.addAttribute("jspHack", hackerCode);
		
		ArrayList<String> skills = new ArrayList<>();
		skills.add("ski");
		skills.add("matt");
		skills.add("abby");
		model.addAttribute("skillList", skills);
		
		return "jstl.jsp";
		}
	}
