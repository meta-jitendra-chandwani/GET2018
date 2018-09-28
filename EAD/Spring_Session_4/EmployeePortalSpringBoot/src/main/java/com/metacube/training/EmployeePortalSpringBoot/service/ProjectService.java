package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Project;


public interface ProjectService {

	
	Project getProjectById(Long id);

	List<Project> getAllProjects();

	boolean deleteProject(Long id);

	boolean updateProject(Project project);

	boolean createProject(Project project);

}
