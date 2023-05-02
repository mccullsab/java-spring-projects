package com.abbymcculloch.sessionsforms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
//	SESSION--------------
	
	@GetMapping("sessions/home")
	public String setSession(HttpSession session){

//		1. if count is not available set count to 0
		if(session.getAttribute("count") == null) {
		session.setAttribute("count", 0);
		}else {
//			1. get count from session
			Integer count = (Integer)session.getAttribute("count");
//			2. if available, make count = count + 1
			session.setAttribute("count", count +1);
		}
		return "sessions/home.jsp";
	}
	
	@GetMapping("/sessions/display")
	public String displaySession() {
		return "sessions/display.jsp";
	}
	
//FORM SUBMISSION (GET)---------------
//	render form on jsp
	@GetMapping("/search/form")
	public String renderSearchFrom() {
		return "/searchForm/searchForm.jsp";
	}
//	http://localhost:8080/search/result?keywords=cats
//	process and display form info
	@GetMapping("/search/result")
	public String displaySearchResult(@RequestParam("keyword")String keyFromParams, HttpSession session) {
		session.setAttribute("keyword", keyFromParams);
		return "searchForm/displaySearchResult.jsp";
	}
	
//FORM SUBMISSION (POST)---------------
	
//	render form
	@GetMapping("/review/form")
	public String renderReviewForm() {
		return "reviewForm/reviewForm.jsp";
	}
	
	
//	process form
	@PostMapping("/review/process")
	public String processReviewResult(
			@RequestParam("title") String title,
			@RequestParam("reviewer")String reviewer,
			@RequestParam("rating")Integer rating,
			@RequestParam("description")String description,
			HttpSession session,
			RedirectAttributes redirectAttributes
			) {
		if(rating < 0) {
			redirectAttributes.addFlashAttribute("ratingErr", "Rating must be positive");
			redirectAttributes.addFlashAttribute("title", title);
			return "redirect:/review/form";
		}
		
		session.setAttribute("title", title);
		session.setAttribute("reviewer", reviewer);
		session.setAttribute("rating", rating);
		session.setAttribute("description", description);

		return "redirect:/review/result";
	}
	
//	display results
	@GetMapping("/review/result")
	public String displayReviewResult() {
		return "reviewForm/displayReviewResult.jsp";
	}
	
//	clear session
	@GetMapping("/clear")
	public String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/review/form";
	}
	
}
