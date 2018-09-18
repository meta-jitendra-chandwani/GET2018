package com.metacube.training.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobTitle;

@Repository
@Transactional
public interface JobTitleRepository<P> extends CrudRepository<JobTitle, Integer> {

	@Modifying
	@Query("update JobTitle set job_title = :job_title where job_id = :job_id")
	int updateJob(@Param("job_title") String job_title,
			@Param("job_id") int job_id);

}
