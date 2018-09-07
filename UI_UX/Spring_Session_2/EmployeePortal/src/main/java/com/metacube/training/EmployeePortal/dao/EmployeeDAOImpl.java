package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortal.mappers.EmployeeMapper;
import com.metacube.training.EmployeePortal.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_PROJECT = "select * from employee where emp_code = ?";
	private final String SQL_DELETE_PROJECT = "delete from employee where emp_code = ?";
	private final String SQL_UPDATE_PROJECT = "update employee set first_name = ?, middle_name  = ?, dob=?,gender=?,primary_contact_number=?,secondary_contact_number=?,email_id=?,skype_id = ?,skills=?,enable=? where emp_code = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT_PROJECT = "insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public List<Employee> getAllEmployee() {
		System.out.println("Get All");
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}

	@Override
	public Employee getEmployeeById(String emp_code) {
		return jdbcTemplate.queryForObject(SQL_FIND_PROJECT,
				new Object[] { emp_code }, new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		System.out.println("Delete Employee");
		return jdbcTemplate.update(SQL_DELETE_PROJECT, employee.getEmp_code()) > 0;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		System.out.println("Update Employee");
		return jdbcTemplate.update(SQL_UPDATE_PROJECT,
				employee.getFirst_name(), employee.getMiddle_name(),
				employee.getDob(), employee.getGender(),
				employee.getPrimary_contact_number(),
				employee.getSecondary_contact_number(), employee.getEmail_id(),
				employee.getSkype_id(), employee.getSkills(),
				employee.getEnable(), employee.getEmp_code()) > 0;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		System.out.println("Create/Insert");
		return jdbcTemplate.update(SQL_INSERT_PROJECT, 
				employee.getFirst_name(), employee.getMiddle_name(),
				employee.getDob(), employee.getGender(),
				employee.getPrimary_contact_number(),
				employee.getSecondary_contact_number(), employee.getEmail_id(),
				employee.getSkype_id(), employee.getProfile_picture(),
				employee.getPassword(), employee.getSkills(),
				employee.getEnable()) > 0;
	}

}