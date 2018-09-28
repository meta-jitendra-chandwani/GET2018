package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.JobTitle;

public interface JobTitleDAO {
	List<JobTitle> getAllJobTitle();

	boolean deleteJobTitle(int id);

	boolean updateJobTitle(JobTitle jobTitle);

	void createJobTitle(JobTitle jobTitle);
	
	JobTitle getJobTitleById(int id);
}
