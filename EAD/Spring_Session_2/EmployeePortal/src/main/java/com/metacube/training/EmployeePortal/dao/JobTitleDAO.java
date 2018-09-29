package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EmployeePortal.model.JobTitle;

public interface JobTitleDAO {
	List<JobTitle> getAllJobTitle();

	boolean deleteJobTitle(int id);

	boolean updateJobTitle(JobTitle jobTitle);

	boolean createJobTitle(JobTitle jobTitle);
	
	JobTitle getJobTitleById(int id);
}
