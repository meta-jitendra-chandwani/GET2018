package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(String emp_code);

	List<Employee> getAllEmployee();

	List<Employee> getEmployee(String emp_code);

	boolean deleteEmployee(String emp_code);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);

	boolean validateUser(String emp_code, String password);

	boolean updateUserPassword(String emp_code,String password);

}
