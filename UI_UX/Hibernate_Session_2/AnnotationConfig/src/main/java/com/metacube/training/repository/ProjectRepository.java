package com.metacube.training.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
public interface ProjectRepository<P> extends JpaRepository<Project, Long> {

	@Modifying
	@Query("update Project set name = (:name), description = (:description), start_date  = (:start_date), end_date  = (:end_date) where id = (:id)")
	int updateProject(@Param("name") String name,
			@Param("description") String description,
			@Param("start_date") Date start_date,
			@Param("end_date") Date end_date, @Param("id") Long id);

}
