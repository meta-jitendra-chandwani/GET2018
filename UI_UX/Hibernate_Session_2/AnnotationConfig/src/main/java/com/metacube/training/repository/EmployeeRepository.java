package com.metacube.training.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository<P> extends
		CrudRepository<Employee, Integer> {

	@Modifying
	@Query("update Employee set first_name = :first_name, middle_name  = :middle_name, dob=:dob,gender=:gender,primary_contact_number=:primary_contact_number,secondary_contact_number=:secondary_contact_number,email_id=:email_id,skype_id = :skype_id,skills=:skills,enable=:enable,password=:password where emp_code = :emp_code")
	int updateEmployee(@Param("first_name") String first_name,
			@Param("middle_name") String middle_name, @Param("dob") Date dob,
			@Param("gender") String gender,
			@Param("primary_contact_number") String primary_contact_number,
			@Param("secondary_contact_number") String secondary_contact_number,
			@Param("email_id") String email_id,
			@Param("skype_id") String skype_id, @Param("skills") String skills,
			@Param("enable") boolean enable,
			@Param("password") String password, @Param("emp_code") int emp_code);

	@Modifying
	@Query("update Employee set password=:password where emp_code = :emp_code")
	int updateUserPassword(@Param("password") String password,
			@Param("emp_code") int emp_code);

	@Query("select e from Job_detail j,Employee e where e.emp_code=j.employeeCode AND j.currentProjectId= :project_id")
	List<Employee> getEmployeeByProject(@Param("project_id") int project_id);

}
