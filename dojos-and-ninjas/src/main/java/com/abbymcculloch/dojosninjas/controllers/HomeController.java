package com.abbymcculloch.dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abbymcculloch.dojosninjas.models.Dojo;
import com.abbymcculloch.dojosninjas.models.Ninja;
import com.abbymcculloch.dojosninjas.services.DojoService;
import com.abbymcculloch.dojosninjas.services.NinjaService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
@Autowired
private NinjaService ninjaService;

@Autowired
private DojoService dojoService;

////READ ALL NINJAS-----------------
//
//@GetMapping("/ninjas")
//
//public String ninjaBoard(Model model) {
//	List<Ninja> ninjaList = ninjaService.allNinjas();
//	model.addAttribute("ninjaList", ninjaList);
//	return "dashboard.jsp";
//}

//READ ONE DOJO -----------------

@GetMapping("/dojos/{id}")
public String dojoDetails(@PathVariable("id")Long id, Model model) {
	model.addAttribute("oneNinja", dojoService.findDojo(id));
	return "dojosDetail.jsp";
}

////READ ONE NINJA -----------------
//
//
//@GetMapping("/ninjas/{id}")
//public String ninjaDetails(@PathVariable("id")Long id, Model model) {
//	Ninja oneNinja = ninjaService.findNinja(id);
//	model.addAttribute("oneNinja", oneNinja);
//	return "ninjaDetails.jsp";
//}


//CREATE DOJO--------------------

//render create page

@GetMapping("/dojos")
public String renderCreateDojoForm(
		@ModelAttribute("dojo")Dojo dojo, Model model) {
	List<Dojo> dojos = dojoService.allDojos();
	model.addAttribute("dojos", dojos);
	return "createDojo.jsp";
}

//process create

@PostMapping("/dojos")
public String processCreateDojoForm(
		@Valid @ModelAttribute("dojo") Dojo dojo, 
		BindingResult result,
		HttpSession session
		) {
	if(result.hasErrors()) {
		return "createDojo.jsp";
	}
	dojoService.createDojo(dojo);
//	session for loginreg
	session.setAttribute("dojoId", dojo.getId());
//	
	return "redirect:/dojos";
}

//CREATE NINJA--------------------

//render create page

@GetMapping("/ninjas")
public String renderCreateNinjaForm(
		@ModelAttribute("ninja")Ninja ninja, Model model) {
	Ninja ninja1 = new Ninja();
	model.addAttribute("ninjas", ninja1);


	
//	drop down to pick from dojos - removed for login and reg
	model.addAttribute("dojos", dojoService.allDojos());
	
	return "createNinja.jsp";
}

//process create ninja - need donor key and matching id

@PostMapping("/ninjas")
public String processCreateNinjaForm(
		@Valid @ModelAttribute("ninja") Ninja ninja, 
		BindingResult result, Model model
		) {
	if(result.hasErrors()) {
//		removed for login and reg
//		model.addAttribute("dojoList", dojoService.allDojos());
		return "createNinja.jsp";
	}
	ninjaService.createNinja(ninja);
	return "redirect:/ninjas";
}




}

