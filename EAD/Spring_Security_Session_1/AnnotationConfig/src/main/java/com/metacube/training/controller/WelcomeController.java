package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class WelcomeController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "login";
	}
	
	@GetMapping("/login")
	 public String login() {
	 return "login";
	 }

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest request) {
		if (request.isUserInRole("ADMIN")) {
			return "redirect:/admin/security";
		}
		if(request.isUserInRole("EMPLOYEE")){
			return "redirect:/employee/security";
		}		
		return "redirect:/error";
	}
	

}