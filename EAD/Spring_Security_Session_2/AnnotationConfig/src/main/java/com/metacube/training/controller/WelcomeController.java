package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class WelcomeController {
	
	@GetMapping(value ={"/login","/"})
	 public String login() {
	 return "login";
	 }

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest request,RedirectAttributes redirectAttributes) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin/dashboard";
		}
		if(request.isUserInRole("ROLE_USER")){
//			String userName=request.getParameter("username");
//			System.out.println("======="+request.getParameter("username")+"======");
			return "redirect:/employee/dashboard";
		}		
		return "redirect:/error";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(){
		System.out.println("==================Error=======================");
		return "error";
	}
}