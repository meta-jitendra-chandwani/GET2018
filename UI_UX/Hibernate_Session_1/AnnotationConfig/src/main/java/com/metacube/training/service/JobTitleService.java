package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.JobTitle;


public interface JobTitleService {
	List<JobTitle> getAllJobTitle();

	boolean deleteJobTitle(int id);

	boolean updateJobTitle(JobTitle jobTitle);

	void createJobTitle(JobTitle jobTitle);
	
	JobTitle getJobTitleById(int id);
}
