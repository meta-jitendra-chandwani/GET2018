package com.metacube.training.EmployeePortalSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortalSpringBoot.model.Employee;
import com.metacube.training.EmployeePortalSpringBoot.model.JobTitle;
import com.metacube.training.EmployeePortalSpringBoot.model.Project;
import com.metacube.training.EmployeePortalSpringBoot.model.Skill;
import com.metacube.training.EmployeePortalSpringBoot.service.EmployeeService;
import com.metacube.training.EmployeePortalSpringBoot.service.ProjectService;
import com.metacube.training.EmployeePortalSpringBoot.service.JobTitleService;
import com.metacube.training.EmployeePortalSpringBoot.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private JobTitleService jobTitleService;

	@Autowired
	private SkillService skillService;

	/**
	 * Project
	 * 
	 * @return
	 */

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
		if (project != null && project.getId() == null) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@GetMapping(path = "/projects")
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
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

	/**
	 * Employee
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping(path = "/employees/add")
	public String createemployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/editEmployee";
	}

	@PostMapping(path = "employees")
	public String saveemployee(@ModelAttribute("employee") Employee employee) {
		if (employee != null && employee.getEmp_code() == "") {
			employeeService.createEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return "redirect:/admin/employees";
	}

	@GetMapping(path = "/employees")
	public String getAllemployee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "admin/employees";
	}

	@GetMapping(path = "/employees/edit")
	public String editemployee(Model model,
			@RequestParam("emp_code") String emp_code) {
		model.addAttribute("employee",
				employeeService.getEmployeeById(emp_code));
		return "admin/editEmployee";
	}

	@GetMapping(path = "/employees/delete")
	public String deleteemployee(@RequestParam("emp_code") String emp_code) {
		employeeService.deleteEmployee(emp_code);
		return "redirect:/admin/employees";
	}

	/**
	 * Job Functionalities
	 */

	@RequestMapping(path = "/jobs/add", method = RequestMethod.GET)
	public String createjob(Model model) {
		System.out
				.println(" job called: /project/add (GET): response: admin/editProject");

		model.addAttribute("job", new JobTitle());
		return "admin/editJob";
	}

	@RequestMapping(path = "/jobs", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("job") JobTitle jobTitle) {
		System.out
				.println("jobs called: /projects (POST) : response: admin/editProject(redirect)");

		if (jobTitle != null && jobTitle.getId() == 0) {
			jobTitleService.createJobTitle(jobTitle);
		} else {
			jobTitleService.updateJobTitle(jobTitle);
		}
		return "redirect:/admin/jobs";
	}

	@RequestMapping(path = "/jobs", method = RequestMethod.GET)
	public String getAlljobs(Model model) {
		System.out
				.println("called jobs: /projects (GET): response: admin/projects");

		model.addAttribute("jobs", jobTitleService.getAllJobTitle());
		return "admin/jobs";
	}

	@RequestMapping(path = "/jobs/edit", method = RequestMethod.GET)
	public String editJob(Model model, @RequestParam("id") int id) {
		System.out
				.println("called:/projects/edit(GET) response: admin/editProject");

		model.addAttribute("job", jobTitleService.getJobTitleById(id));
		return "admin/editjob";
	}

	@RequestMapping(path = "/jobs/delete", method = RequestMethod.GET)
	public String deleteJobTitle(@RequestParam("id") int id) {
		jobTitleService.deleteJobTitle(id);
		return "redirect:/admin/jobs";
	}

	/**
	 * skills
	 */

	@RequestMapping(path = "/skills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skills";
	}

	@RequestMapping(path = "/skills/add", method = RequestMethod.GET)
	public String createSkills(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/addSkill";
	}

	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skill skill) {
		if (skill != null && skill.getId() == 0) {
			skillService.createSkill(skill);
		}
		return "redirect:/admin/skills";
	}

	/**
	 * search
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String searchEmployee(Model model) {
		return "admin/search";
	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") String username,
			Model model) {
		model.addAttribute("employees",
				employeeService.getEmployeeById(username));
		return "admin/search";
	}

}