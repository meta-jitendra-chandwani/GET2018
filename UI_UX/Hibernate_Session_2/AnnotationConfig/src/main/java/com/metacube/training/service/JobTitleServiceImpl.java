package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.JobTitleRepository;
import com.metacube.training.service.JobTitleService;

@Service
public class JobTitleServiceImpl implements JobTitleService {

	@Autowired
	private JobTitleRepository<JobTitle> jobTitleRespository;

	@Override
	public List<JobTitle> getAllJobTitle() {
		return (List<JobTitle>) jobTitleRespository.findAll();
	}

	@Override
	public void deleteJobTitle(int id) {
		jobTitleRespository.delete(id);
	}

	@Override
	public boolean updateJobTitle(JobTitle jobTitle) {
		return jobTitleRespository.updateJob(jobTitle.getJobTitle(),
				jobTitle.getId()) > 0;
	}

	@Override
	public void createJobTitle(JobTitle jobTitle) {
		jobTitleRespository.save(jobTitle);
	}

	@Override
	public JobTitle getJobTitleById(int id) {
		return jobTitleRespository.findOne(id);
	}

}
