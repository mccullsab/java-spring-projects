package com.abbymcculloch.booksmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abbymcculloch.booksmvc.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home(Model model) {
		return "redirect:/books";
	}
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId")Long bookId) {
		model.addAttribute("book", bookService.findBook(bookId));
		return "show.jsp";
	}
}
