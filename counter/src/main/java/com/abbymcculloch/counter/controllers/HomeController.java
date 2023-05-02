package com.abbymcculloch.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer count = (Integer)session.getAttribute("count");
			session.setAttribute("count", count +1);
		}
		return "home.jsp";
	}
	
	@GetMapping("/counter")
	public String displaySession() {
		return "counter.jsp";
	}
	
}
