package com.abbymcculloch.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.abbymcculloch.bookclub.models.Book;
import com.abbymcculloch.bookclub.models.LoginUser;
import com.abbymcculloch.bookclub.models.User;
import com.abbymcculloch.bookclub.services.BookService;
import com.abbymcculloch.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
     @Autowired
     private UserService userService;
     
     @Autowired
     private BookService bookService;
    
//     RENDER LOGIN FORM------------
    @GetMapping("/")
    public String renderLogregForm(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "logreg.jsp";
    }
    
    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	User registeredUser = userService.register(newUser, result);
        // to do some extra validations and create a new user!
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "logreg.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        else {        
        session.setAttribute("userId", registeredUser.getId());
        session.setAttribute("userName", registeredUser.getUserName());
        return "redirect:/books";
        }
    }
    
    @PostMapping("/login")
    public String processLogin(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        User loginUser = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "logreg.jsp";
        }
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        else {
            session.setAttribute("userId", loginUser.getId());
            session.setAttribute("userName", loginUser.getUserName());
            return "redirect:/books";
        }
    }
    
    @GetMapping("/logout")
    public String logoutLogic(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
 
//    POST LOGIN
    
//    READ ALL BOOKS
    
    @GetMapping("/books")
    public String dashboard(HttpSession session, Model model) {
//    	put this check in all gets
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	List<Book> bookList = bookService.allBooks();
    	model.addAttribute("bookList", bookList);
    	return "dashboard.jsp";
    }
    
//	READ ONE BOOK


    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable("id")Long id, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Book oneBook = bookService.findBook(id);
    	model.addAttribute("oneBook", oneBook);
    	return "detail.jsp";
    }
    
  //CREATE BOOK--------------------

  //render create page

  @GetMapping("/books/new")
  public String renderCreateBookForm(Model model, HttpSession session) {
  	if(session.getAttribute("userId") == null) {
		return "redirect:/";
	}
  	Book newBook = new Book();
  	model.addAttribute("newBook", newBook);
  	
//  	drop down to pick from users - removed for login and reg
//  	model.addAttribute("userList", userService.allUsers());
  	
  	return "create.jsp";
  }


  @PostMapping("books/new")
  public String processCreateBookForm(
  		@Valid @ModelAttribute("newBook") Book newBook, 
  		BindingResult result, Model model
  		) {
  	if(result.hasErrors()) {
//  		removed for login and reg
//  		model.addAttribute("userList", userService.allUsers());
  		return "create.jsp";
  	}
  	bookService.createBook(newBook);
  	return "redirect:/books";
  }
  
//EDIT BOOK------------------------

//Render edit form
@GetMapping("/books/{id}/edit")
public String renderEditBookForm(
		@PathVariable("id")Long id,
		Model model, HttpSession session
		) {
	if(session.getAttribute("userId") == null) {
		return "redirect:/";
	}
//	removed for login and reg
//	model.addAttribute("userList", userService.allUsers());
	
//	if some types - if book.owner.id is the same as the user id session if it is continue, otherwise redirect 
	Book oneBook = bookService.findBook(id);
	model.addAttribute("oneBook", oneBook);
	return "edit.jsp";
}

//process edit form
@PutMapping("/books/{id}/edit")
public String processEditBookForm(
		@PathVariable("id")Long id,
		@Valid @ModelAttribute("oneBook") Book oneBook,
		BindingResult result,
		Model model
		) {
	if(result.hasErrors()) {
//		removed for login and reg
//		model.addAttribute("userList", userService.allUsers());
		return "edit.jsp";
	}
	else {
		bookService.updateBook(oneBook);
		return "redirect:/books";
	}
}


//DELETE BOOK--------------------

@DeleteMapping("/books/{id}")
public String deleteBook(@PathVariable("id")Long id) {
	bookService.removeBook(id);
	return "redirect:/books";
}


    
}
