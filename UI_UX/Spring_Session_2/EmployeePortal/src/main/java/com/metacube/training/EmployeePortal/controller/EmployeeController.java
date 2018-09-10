package com.metacube.training.EmployeePortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortal.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/login")
	public String login() {
		return "employee/login";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam(name = "username") String emp_code,
			@RequestParam(name = "password") String password,Model model) {
		System.out.println(emp_code + "\n" + password);
		
		model.addAttribute("employees", employeeService.getEmployee(emp_code));
		return employeeService.validateUser(emp_code, password) ? new ModelAndView(
				"employee/dashboard", "username", emp_code) : new ModelAndView(
				"employee/error");

	}

	
}
