package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int emp_code);

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	void createEmployee(Employee employee);

	boolean validateUser(int emp_code,String password);


	boolean updateUserPassword(int emp_code,String password);

}
