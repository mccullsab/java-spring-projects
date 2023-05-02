package com.abbymcculloch.blackbelt.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.abbymcculloch.blackbelt.models.LoginUser;
import com.abbymcculloch.blackbelt.models.Name;
import com.abbymcculloch.blackbelt.models.User;
import com.abbymcculloch.blackbelt.services.NameService;
import com.abbymcculloch.blackbelt.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	
    @Autowired
    private UserService userService;
    
    @Autowired
    private NameService nameService;
   
//    RENDER LOGIN FORM------------
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
       return "redirect:/names";
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
           return "redirect:/names";
       }
   }
   
   @GetMapping("/logout")
   public String logoutLogic(HttpSession session) {
   	session.invalidate();
   	return "redirect:/";
   }

//   POST LOGIN
   
//   READ ALL NAMES
   
   @GetMapping("/names")
   public String dashboard(HttpSession session, Model model) {
//   	put this check in all gets
   	if(session.getAttribute("userId") == null) {
   		return "redirect:/";
   	}
	List<User> users = userService.allUsers();
   	List<Name> nameList = nameService.allNames();
   	model.addAttribute("users", users);
   	model.addAttribute("nameList", nameList);
   	return "dashboard.jsp";
   }
   

   
//	READ ONE NAME

   @GetMapping("/names/{id}")
   public String nameDetails(@PathVariable("id")Long id, Model model, HttpSession session) {
   	if(session.getAttribute("userId") == null) {
   		return "redirect:/";
   	}
   	Name oneName = nameService.findName(id);
   	model.addAttribute("oneName", oneName);
   	return "detail.jsp";
   }
   
 //CREATE NAME--------------------

 //render create page

 @GetMapping("/names/new")
 public String renderCreateNameForm(Model model, HttpSession session) {
 	if(session.getAttribute("userId") == null) {
		return "redirect:/";
	}
 	Name newName = new Name();
 	model.addAttribute("newName", newName);
 	
// 	drop down to pick from users - removed for login and reg
// 	model.addAttribute("userList", userService.allUsers());
 	
 	return "create.jsp";
 }


 @PostMapping("/names/new")
 public String processCreateNameForm(
 		@Valid @ModelAttribute("newName") Name newName, 
 		BindingResult result, Model model
 		) {
 	nameService.createName(newName, result);
 	if(result.hasErrors()) {
// 		removed for login and reg
// 		model.addAttribute("userList", userService.allUsers());
 		return "create.jsp";
 	}
 	return "redirect:/names";
 }
 
//EDIT NAME------------------------

//Render edit form
@GetMapping("/names/{id}/edit")
public String renderEditNameForm(
		@PathVariable("id")Long id,
		Model model, HttpSession session
		) {
	if(session.getAttribute("userId") == null) {
		return "redirect:/";
	}
//	removed for login and reg
//	model.addAttribute("userList", userService.allUsers());
	
//	if some types - if name.owner.id is the same as the user id session if it is continue, otherwise redirect 
	Name oneName = nameService.findName(id);
	model.addAttribute("oneName", oneName);
	return "edit.jsp";
}

//process edit form
@PutMapping("/names/{id}/edit")
public String processEditNameForm(
		@PathVariable("id")Long id,
		@Valid @ModelAttribute("oneName") Name oneName,
		BindingResult result,
		Model model
		) {
	if(result.hasErrors()) {
//		removed for login and reg
//		model.addAttribute("userList", userService.allUsers());
		return "edit.jsp";
	}
	else {
		nameService.updateName(oneName);
		return "redirect:/names";
	}
}


//DELETE NAME--------------------

@DeleteMapping("/names/{id}")
public String deleteName(@PathVariable("id")Long id) {
	nameService.removeName(id);
	return "redirect:/names";
}


@PostMapping("/names/{id}/upvote")
public String addVote(@PathVariable("id") Long id, @RequestParam(value="userId") Long userId, Model model) {
	Name name = nameService.findName(id);
	User user = userService.findById(userId);
	name.getUsers().add(user);
	nameService.updateName(name);
//	System.out.println(name);
//	System.out.println(user);

	return "redirect:/names";
}


}
