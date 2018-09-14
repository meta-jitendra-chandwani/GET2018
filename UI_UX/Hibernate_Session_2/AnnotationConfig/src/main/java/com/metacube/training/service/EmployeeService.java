package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(int emp_code);

	List<Employee> getAllEmployee();


	void deleteEmployee(int emp_code);

	boolean updateEmployee(Employee employee);

	void createEmployee(Employee employee);

	boolean validateUser(int emp_code, String password);

	boolean updateUserPassword(int emp_code,String password);
	
	List<Employee> getEmployeeByProject(int project_id);
}
