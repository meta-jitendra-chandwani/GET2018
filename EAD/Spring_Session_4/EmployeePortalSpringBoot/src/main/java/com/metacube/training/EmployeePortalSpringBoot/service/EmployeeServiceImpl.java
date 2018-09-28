package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.dao.EmployeeDAO;
import com.metacube.training.EmployeePortalSpringBoot.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee getEmployeeById(String emp_code) {
		return employeeDAO.getEmployeeById(emp_code);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	public boolean deleteEmployee(String emp_code) {
		Employee employee = employeeDAO.getEmployeeById(emp_code);
		return employeeDAO.deleteEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public boolean validateUser(String emp_code, String password) {
		return employeeDAO.validateUser(emp_code,password);
	}

	@Override
	public List<Employee> getEmployee(String emp_code) {
		return employeeDAO.getEmployee(emp_code);
	}

	@Override
	public boolean updateUserPassword(String emp_code,String password) {
		return employeeDAO.updateUserPassword(emp_code,password);
	}

}
