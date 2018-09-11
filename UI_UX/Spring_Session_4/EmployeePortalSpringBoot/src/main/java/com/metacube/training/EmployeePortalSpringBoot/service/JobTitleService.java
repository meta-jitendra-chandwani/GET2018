package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.JobTitle;


public interface JobTitleService {
	List<JobTitle> getAllJobTitle();

	boolean deleteJobTitle(int id);

	boolean updateJobTitle(JobTitle jobTitle);

	boolean createJobTitle(JobTitle jobTitle);
	
	JobTitle getJobTitleById(int id);
}
