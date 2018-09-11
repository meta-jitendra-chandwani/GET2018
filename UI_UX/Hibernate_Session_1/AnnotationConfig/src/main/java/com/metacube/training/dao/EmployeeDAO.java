package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployee();

	Employee getEmployeeById(String emp_code);

	boolean deleteEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean createEmployee(Employee employee);

	boolean validateUser(String emp_code,String password);

	List<Employee> getEmployee(String emp_code);

	boolean updateUserPassword(String emp_code,String password);

}
