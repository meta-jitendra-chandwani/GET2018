package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setEmp_code(resultSet.getString("emp_code"));
		employee.setFirst_name(resultSet.getString("first_name"));
		employee.setMiddle_name(resultSet.getString("middle_name"));
		employee.setDob(resultSet.getDate("dob"));
		employee.setGender(resultSet.getString("gender"));
		employee.setPrimary_contact_number(resultSet.getString("primary_contact_number"));
		employee.setSecondary_contact_number(resultSet.getString("secondary_contact_number"));
		employee.setEmail_id(resultSet.getString("email_id"));
		employee.setSkype_id(resultSet.getString("skype_id"));
		employee.setProfile_picture(resultSet.getString("profile_picture"));
		employee.setPassword(resultSet.getString("password"));
		employee.setSkills(resultSet.getString("skills"));
		employee.setEnable(resultSet.getBoolean("enable"));
		return employee;
	}
}
