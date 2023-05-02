package com.abbymcculloch.omikuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
//	Render form
	@GetMapping("/")
	public String home() {
		return "omikujiForm.jsp";
	}

//	process form - post
	@PostMapping("/process")
	public String process(
			@RequestParam("number")Integer number,
			@RequestParam("city")String city,
			@RequestParam("person")String person,
			@RequestParam("hobby")String hobby,
			@RequestParam("thing")String thing,
			@RequestParam("nice")String nice,
			HttpSession session,
			RedirectAttributes redirectAttributes			
			) {
		if(number > 25) {
			redirectAttributes.addFlashAttribute("numberErr", "Number must be less than 25");
			return "redirect:/";
		}
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);

		return "redirect:/show";
	}
	
//render
	@GetMapping("/show")
	public String display() {
		return "omikujiRender.jsp";
	}
	
}
