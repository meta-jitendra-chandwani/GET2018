package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.EmployeeDAO;
import com.metacube.training.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee getEmployeeById(int emp_code) {
		return employeeDAO.getEmployeeById(emp_code);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDAO.getAllEmployee();
	}

	@Override
	public boolean deleteEmployee(int emp_code) {
		Employee employee = employeeDAO.getEmployeeById(emp_code);
		return employeeDAO.deleteEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public void createEmployee(Employee employee) {
		employeeDAO.createEmployee(employee);
	}

	@Override
	public boolean validateUser(int emp_code, String password) {
		return employeeDAO.validateUser(emp_code,password);
	}

	

	@Override
	public boolean updateUserPassword(int emp_code,String password) {
		return employeeDAO.updateUserPassword(emp_code,password);
	}

}
