package com.metacube.training.EmployeePortalSpringBoot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortalSpringBoot.model.Employee;
import com.metacube.training.EmployeePortalSpringBoot.service.EmployeeService;

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
			@RequestParam(name = "password") String password,
			HttpServletRequest request) {
		if (employeeService.validateUser(emp_code, password)) {
			request.getSession().setAttribute("empCode", emp_code);
			return new ModelAndView("employee/dashboard", "username", emp_code);
		} else {
			return new ModelAndView("employee/error");
		}
	}

	@GetMapping(path = "/employees")
	public String getAllprojects(Model model, HttpServletRequest request) {
		model.addAttribute(
				"employees",
				employeeService.getEmployee(request.getSession()
						.getAttribute("empCode").toString()));
		return "employee/employees";
	}

	@PostMapping(path = "employees")
	public String saveemployee(@ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:/employee/employees";
	}

	@GetMapping(path = "/employees/edit")
	public String editemployee(Model model,
			@RequestParam("emp_code") String emp_code) {
		model.addAttribute("employee",
				employeeService.getEmployeeById(emp_code));
		return "admin/editEmployee";
	}

	/**
	 * Search
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/search")
	public String searchEmployee(Model model) {
		return "employee/search";
	}

	@PostMapping(path = "/search")
	public String search(@RequestParam(name = "search") String username,
			Model model, HttpServletRequest request) {
		request.getSession().setAttribute("empCode", username);
		model.addAttribute("employees",
				employeeService.getEmployeeById(username));
		return "employee/search";
	}

	/**
	 * LogOut
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "employee/login";
	}
}