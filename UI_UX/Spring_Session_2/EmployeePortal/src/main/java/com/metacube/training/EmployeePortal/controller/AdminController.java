package com.metacube.training.EmployeePortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortal.model.Employee;
import com.metacube.training.EmployeePortal.model.Project;
import com.metacube.training.EmployeePortal.service.EmployeeService;
import com.metacube.training.EmployeePortal.service.ProjectService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);
	}

	@GetMapping(path = "/projects/add")
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@PostMapping(path = "projects")
	public String saveproject(@ModelAttribute("project") Project project) {
		if(project!= null && project.getId() == null) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@GetMapping(path = "/projects")
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";//html hai
	}

	@GetMapping(path = "/projects/edit")
	public String editproject(Model model, @RequestParam("id") Long id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@GetMapping(path = "/projects/delete")
	public String deleteproject(@RequestParam("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}
	
	
	
	
	
	
	
	@GetMapping(path = "/employees/add")
	public String createemployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/editEmployee";
	}

	@PostMapping(path = "employees")
	public String saveemployee(@ModelAttribute("employee") Employee employee) {
		if(employee!= null && employee.getEmp_code() == null) {
			System.out.println("insert me aa gya");
			employeeService.createEmployee(employee);	
		}else {
			System.out.println("update me aa gya");
			employeeService.updateEmployee(employee);		}
		return "redirect:/admin/employees";//employee list
	}

	@GetMapping(path = "/employees")
	public String getAllemployee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "admin/employees";//html hai
	}

	@GetMapping(path = "/employees/edit")
	public String editemployee(Model model, @RequestParam("emp_code") String emp_code) {
		model.addAttribute("employee", employeeService.getEmployeeById(emp_code));
		return "admin/editEmployee";
	}

	@GetMapping(path = "/employees/delete")
	public String deleteemployee(@RequestParam("emp_code") String emp_code) {
		employeeService.deleteEmployee(emp_code);
		return "redirect:/admin/employees";
	}
	
}